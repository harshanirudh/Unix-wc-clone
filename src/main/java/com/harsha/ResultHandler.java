package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

public class ResultHandler implements AbstractRequestHandler {
    private AbstractRequestHandler next;
    @Override
    public void handle(Request req, Response res) {
        if(req.getFiles()!=null && !req.getFiles().isEmpty())
            res.getSb().append("\t").append(req.getFiles().get(0));
        System.out.println(res.getSb().toString().trim());

    }

    @Override
    public void nextHandler(AbstractRequestHandler next) {

    }
    @Override
    public AbstractRequestHandler getNextHandler() {
        return next;
    }

}
