package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LinesHandler implements AbstractRequestHandler {
    private AbstractRequestHandler next;

    @Override
    public void handle(Request req, Response res) {
//        System.out.println("*********** Inside Lines handler ********");
        try {
            int lineCount;
            if(!req.isReadFromPipedData())
                lineCount= Files.readAllLines(Path.of(req.getFiles().get(0))).size();
            else
                lineCount= (int) (req.getPipedData().chars().map(c->(char)c).filter(c->c=='\n').count());
            res.getSb().append("\t").append(lineCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.next.handle(req, res);
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
