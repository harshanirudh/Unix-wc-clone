package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            /*System.out.println("Welcome to my own WC util tool");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();*/
            // Intialize handler and add chain
            AbstractRequestHandler checkCommand = new CheckCommandHandler();
            // Start handling the request
//            cmd = cmd.trim();
//            String[] cmdArr = cmd.split("\\s");
            Request req = new Request(args);
            Response res = new Response();
            checkCommand.handle(req, res);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}