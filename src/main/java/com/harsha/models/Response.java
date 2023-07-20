package com.harsha.models;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private StringBuffer sb;

    public Response() {
        this.sb=new StringBuffer();
    }

    public StringBuffer getSb() {
        return sb;
    }

    public void setSb(StringBuffer sb) {
        this.sb = sb;
    }
}
