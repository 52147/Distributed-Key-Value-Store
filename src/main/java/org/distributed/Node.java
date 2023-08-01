package org.distributed;

import java.io.*;
import java.net.*;

// Define the Node
public class Node extends Thread {
    private String id;
    private int port;
    private KeyValueStore store;
    private ServerSocket serverSocket;

    public Node(String id, int port) {
        this.id = id;
        this.port = port;
        this.store = new KeyValueStore();
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port);
            System.exit(-1);
        } finally {
            // ... other code ...
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                handleClient();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void handleClient() throws IOException {
            try (ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                 ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

                while (true) {
                    Message message = (Message) in.readObject();
                    String key = message.getKey();
                    String value;

                    switch (message.getOperation()) {
                        case "GET":
                            value = store.get(key);
                            out.writeObject(new Message(key, value, "RESPONSE"));
                            break;
                        case "PUT":
                            store.put(key, message.getValue());
                            out.writeObject(new Message(key, null, "RESPONSE"));
                            break;
                        case "DELETE":
                            store.delete(key);
                            out.writeObject(new Message(key, null, "RESPONSE"));
                            break;
                    }
                }
            } catch (EOFException e) {
                // Client has closed the connection
                System.out.println("Client disconnected");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
