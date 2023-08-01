package org.distributed;

import java.io.*;
import java.net.*;

public class Client {
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Client(String host, int port) {
        try {
            clientSocket = new Socket(host, port);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
        System.out.println("Sent message: " + message.toString());

        try {
            Message response = (Message) in.readObject();
            System.out.println("Received response: " + response.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
