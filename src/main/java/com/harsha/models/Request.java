package com.harsha.models;

import java.util.List;

public class Request {
    private String [] cmd;
    private List<String> files;
    private boolean isReadFromPipedData;
    private StringBuffer pipedData;
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

    public boolean isReadFromPipedData() {
        return isReadFromPipedData;
    }

    public StringBuffer getPipedData() {
        return pipedData;
    }

    public void setPipedData(StringBuffer pipedData) {
        this.pipedData = pipedData;
    }

    public void setReadFromPipedData(boolean readFromPipedData) {
        isReadFromPipedData = readFromPipedData;
    }

    public Request(String[] cmd,boolean isReadFromPipedData) {
        this.cmd = cmd;
        this.isReadFromPipedData=isReadFromPipedData;
    }

    public Request(String[] cmd, boolean isReadFromPipedData, StringBuffer pipedData) {
        this.cmd = cmd;
        this.isReadFromPipedData = isReadFromPipedData;
        this.pipedData = pipedData;
    }
}
