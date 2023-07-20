package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

public class CharHandler implements AbstractRequestHandler {
    private AbstractRequestHandler next;

    @Override
    public void handle(Request req, Response res) {
        System.out.println("*********** Inside CHars handler ********");
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
