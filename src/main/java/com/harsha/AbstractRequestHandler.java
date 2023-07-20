package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

public interface AbstractRequestHandler {
    public void handle(Request req, Response res);
    public void nextHandler(AbstractRequestHandler next);
    public AbstractRequestHandler getNextHandler();
}
