package org.distributed;

import java.io.Serializable;

public class Message implements Serializable {
    private String key;
    private String value;
    private String operation;

    public Message(String key, String value, String operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public String getOperation() {
        return operation;
    }
    @Override
    public String toString() {
        return "Message{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
