package org.distributed;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {

    private ServerSocket serverSocket;

    public ServerThread(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
