# Distributed Key-Value Store

This is a simple implementation of a distributed key-value store in Java. The system includes a server (known as `Node`) and a client (`Client`). The server handles multiple client connections concurrently and performs basic operations such as `PUT`, `GET`, and `DELETE` on the key-value store.

## Components

1. **Message**: This class is used to send messages between the client and the server. Each message contains a key, a value, and an operation (`PUT`, `GET`, `DELETE`).

2. **KeyValueStore**: This class represents the key-value store. It provides methods to put a key-value pair into the store, get a value from the store using its key, and delete a key-value pair from the store.

3. **Node**: This is the server class that listens for client connections on a specified port and creates a new thread to handle each connection.

4. **Client**: This is the client class that connects to the server and sends messages to it.

## Running the Code

1. First, start the `Node` (server). Specify the port number that the server should listen on. The server will start and wait for client connections.

2. Next, start the `Client`. Specify the host and port number of the server that the client should connect to. The client will connect to the server and can then send messages to the server.

3. The client can now send `PUT`, `GET`, and `DELETE` operations to the server. Each operation is sent as a `Message` object. The server responds to each operation with a message, and the client prints out the response it received.

Note: The server can handle multiple client connections concurrently.

## Example

Start the server:

Server started on port 6000

Start the client and send a `PUT` operation:
Sent message: Message{key='key1', value='value1', operation='PUT'}
Received response: Message{key='key1', value='null', operation='RESPONSE'}


Send a `GET` operation:

Sent message: Message{key='key1', value='null', operation='GET'}
Received response: Message{key='key1', value='value1', operation='RESPONSE'}


Send a `DELETE` operation:

Sent message: Message{key='key1', value='null', operation='DELETE'}
Received response: Message{key='key1', value='null', operation='RESPONSE'}



## Conclusion
## Conclusion

This project demonstrates some of the fundamental concepts of distributed systems, including network communication, concurrent processing, and simple data storage and retrieval.

1. **Network Communication**: The system uses sockets for network communication between the server and clients. This is a fundamental part of any distributed system.

2. **Concurrent Processing**: The server can handle multiple client connections concurrently, each in its own thread. This is another crucial aspect of distributed systems, allowing for increased throughput and better utilization of system resources.

3. **Data Storage and Retrieval**: The key-value store allows for simple data storage and retrieval operations. While this implementation is quite simple, it can be extended to include more complex data structures and operations.

Overall, this project provides a basic but powerful framework for understanding and building distributed systems. Further enhancements could include implementing advanced features like replication, sharding, consistency mechanisms, failure handling, and more.
