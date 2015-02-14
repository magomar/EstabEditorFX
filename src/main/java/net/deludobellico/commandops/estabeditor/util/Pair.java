package net.deludobellico.commandops.estabeditor.util;

/**
 * Created by Heine on 11/2/2014.
 */
public class Pair<K, V> {
    private final K key;
    private final V value;
    private final boolean printKey;

    public Pair(K key, V value, boolean printKey) {
        this.key = key;
        this.value = value;
        this.printKey = printKey;
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
        this.printKey = false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;
        if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
        if (value != null ? !value.equals(pair.value) : pair.value != null) return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
