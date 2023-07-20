package com.harsha;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    public void readFile(String fileName) throws IOException {

        File file= new File(fileName);
        System.out.println(file.getCanonicalPath());
    }
    public static void main(String args[]) throws IOException {
        FileUtil util=new FileUtil();
        util.readFile("../test.txt");
    }
}
