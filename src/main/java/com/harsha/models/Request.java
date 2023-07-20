package com.harsha.models;

import java.util.List;

public class Request {
    private String [] cmd;
    private List<String> files;

    public String[] getCmd() {
        return cmd;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setCmd(String[] cmd) {
        this.cmd = cmd;
    }

    public void setFiles(List<String>  files) {
        this.files = files;
    }

    public Request(String[] cmd) {
        this.cmd = cmd;

    }
}
