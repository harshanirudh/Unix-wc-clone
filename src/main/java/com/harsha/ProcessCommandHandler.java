package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

public class ProcessCommandHandler implements AbstractRequestHandler {
    private AbstractRequestHandler next;

    @Override
    public void handle(Request req, Response res) {
        String[] cmd=req.getCmd();
        System.out.println("******Inside Process Command handler********");
        if (cmd[1].startsWith("-")) {
            System.out.println("****** options specified ********");
            String option = cmd[1];
            this.next= new BytesHandler();
//            switch (option) {
//                case "-c":
//                    this.next = new BytesHandler();
//                    break;
//                case "-l":
//                    this.next = new LinesHandler();
//                    break;
//                case "-w":
//                    this.next = new WordsHandler();
//                    break;
//                case "-m":
//                    this.next = new WordsHandler();
//                    break;
//                default:
//                    this.next = new AllHandler();
//                    break;
//            }
        }
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
