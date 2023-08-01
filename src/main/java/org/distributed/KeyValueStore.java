package org.distributed;

import java.util.concurrent.ConcurrentHashMap;

public class KeyValueStore {
    private ConcurrentHashMap<String, String> store;

    public KeyValueStore() {
        this.store = new ConcurrentHashMap<>();
    }

    public String get(String key) {
        return this.store.get(key);
    }

    public void put(String key, String value) {
        this.store.put(key, value);
    }

    public void delete(String key) {
        this.store.remove(key);
    }
}
