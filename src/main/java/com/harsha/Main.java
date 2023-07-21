package com.harsha;

import com.harsha.models.Request;
import com.harsha.models.Response;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuffer pipedData = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            if (System.in.available() > 0) {
                while (true) {
                    if ((line = reader.readLine()) != null) {
                        pipedData.append(line).append('\n');
                    } else {
                        break;
                    }
                }
            }
            /*System.out.println("Welcome to my own WC util tool");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();*/
            // Intialize handler and add chain
            AbstractRequestHandler checkCommand = new CheckCommandHandler();
            // Start handling the request
//            cmd = cmd.trim();
//            String[] cmdArr = cmd.split("\\s");

            Request req;
            if (pipedData.length() == 0)
                req = new Request(args, false);
            else
                req = new Request(args, true, pipedData);
            Response res = new Response();
            checkCommand.handle(req, res);

        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}