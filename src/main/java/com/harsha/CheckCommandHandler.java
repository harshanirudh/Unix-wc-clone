package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CheckCommandHandler implements AbstractRequestHandler {
    private AbstractRequestHandler next;
    private List<String> files;

    public CheckCommandHandler() {
        this.files=new ArrayList<>();
    }

    @Override
    public void handle(Request req, Response res) {
        String[] cmd=req.getCmd();

        if (cmd == null || cmd.length == 0) {
            throw new RuntimeException("Command cannot be null or empty");
        }
        if (!cmd[0].equalsIgnoreCase("CCWC")) {
            throw new RuntimeException("Operation not supported");
        }

        BytesHandler bytesHandler = new BytesHandler();
        LinesHandler linesHandler = new LinesHandler();
        WordsHandler wordsHandler = new WordsHandler();
        CharHandler charHandler = new CharHandler();
        ResultHandler resultHandler = new ResultHandler();
        Set<String> options = null;
        try {
            options = getOptionsSelected(req);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(req.isReadFromPipedData() && req.getFiles()!=null && !req.getFiles().isEmpty())
            throw new RuntimeException("Invalid parameters, either pass file or piped data");
        RequestChainBuilder reqChain=new RequestChainBuilder(this);
        for (String option:options){
            if(option.equals(OptionConstants.LINES)) {
                reqChain.chain(linesHandler);
            }else if(option.equals(OptionConstants.WORDS)){
                reqChain.chain(wordsHandler);
            }else if(option.equals(OptionConstants.BYTES)){
                reqChain.chain(bytesHandler);
            }else if(option.equals(OptionConstants.CHARS)){
                reqChain.chain(charHandler);
            }

        }
        reqChain.chain(resultHandler);
        req.setFiles(files);
        reqChain.build().handle(req,res);


    }

    private Set<String> getOptionsSelected(Request req) throws IOException {
        String[] cmd = req.getCmd();
        Set<String> result = new HashSet<>();
        for (int i = 1; i < cmd.length; i++) {
            if (i == 1 && !cmd[i].startsWith("-")) {
                result.add(OptionConstants.LINES);
                result.add(OptionConstants.BYTES);
                result.add(OptionConstants.WORDS);
                File file= new File(cmd[i]);
                files.add(file.getCanonicalPath());
                return result;
            }
            if (!cmd[i].startsWith("-")) {
                for(int j=i ;j< cmd.length;j++){
                    File file= new File(cmd[j]);
                    files.add(file.getCanonicalPath());
                }
                return result;
            } else if (cmd[i].equals("-l")) {
                result.add(OptionConstants.LINES);
            } else if (cmd[i].equals("-c")) {
                result.add(OptionConstants.BYTES);
            } else if (cmd[i].equals("-w")) {
                result.add(OptionConstants.WORDS);
            } else if (cmd[i].equals("-m")) {
                result.add(OptionConstants.CHARS);
            }
        }
        if(result.size()==0 && req.isReadFromPipedData()){
            result.add(OptionConstants.LINES);
            result.add(OptionConstants.BYTES);
            result.add(OptionConstants.WORDS);
        }
        return result;
    }

    @Override
    public void nextHandler(AbstractRequestHandler next) {
        this.next = next;

    }

    @Override
    public AbstractRequestHandler getNextHandler() {
        return next;
    }
}
