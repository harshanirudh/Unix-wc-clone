package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BytesHandler implements AbstractRequestHandler {
    private AbstractRequestHandler next;

    @Override
    public void handle(Request req, Response res){
//        System.out.println("*********** Inside Bytes handler ********");
        try {
            int bytesCount=Files.readAllBytes(Path.of(req.getFiles().get(0))).length;
            res.getSb().append("\t").append(bytesCount);
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
