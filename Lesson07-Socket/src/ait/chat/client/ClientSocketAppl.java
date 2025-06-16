package ait.chat.client;

import ait.chat.client.task.MessageReceiver;
import ait.chat.client.task.MessageSender;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (16.06.2025)
 */
public class ClientSocketAppl {
    public static void main(String[] args) {
        if (args.length == 1) {
            args = new String[]{args[0], "9000"};
        }
        if (args.length == 0 ) {
            args = new String[]{"127.0.0.1", "9000"};
        }

        String serverHost = args[0]; // localhost
        int port = Integer.parseInt(args[1]);


        try  {

            Socket socket = new Socket(serverHost,port);
            new MessageReceiver(socket);
            new Thread(new MessageSender(socket)).start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
