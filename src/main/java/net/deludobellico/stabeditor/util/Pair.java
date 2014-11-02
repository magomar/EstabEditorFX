package net.deludobellico.stabeditor.util;

/**
 * Created by Heine on 11/2/2014.
 */
public class Pair<K, V> {
    private K key;
    private V value;
    private boolean printKey;

    public Pair(K key, V value, boolean printKey) {
        this.key = key;
        this.value = value;
        this.printKey = printKey;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public String toString() {
        return printKey ? key.toString() : value.toString();
    }
}
