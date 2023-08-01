package org.distributed;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Start a server
        Node node = new Node("Node1", 6000);
        node.start();

        // Give the server some time to start
        Thread.sleep(1000);

        // Start a client
        Client client = new Client("localhost", 6000);
        // Start a client
        client.send(new Message("key1", "value1", "PUT"));
        client.send(new Message("key1", null, "GET"));
        client.send(new Message("key1", null, "DELETE"));

    }
}
