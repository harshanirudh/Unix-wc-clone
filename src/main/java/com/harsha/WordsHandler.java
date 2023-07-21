package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class WordsHandler implements AbstractRequestHandler {
    private AbstractRequestHandler next;

    @Override
    public void handle(Request req, Response res) {
        int wordCount;
        if(!req.isReadFromPipedData()) {
            try (var reader = Files.newBufferedReader(Path.of(req.getFiles().get(0)));) {
                 wordCount = (int) reader
                        .lines()
                        .map(line -> line.split("\\s+"))
                        .flatMap(Arrays::stream)
                        .filter(word -> !word.isEmpty())
                        .count();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            wordCount=req.getPipedData().toString().trim().split("\\s+").length;
        }
        res.getSb().append("\t").append(wordCount);
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
