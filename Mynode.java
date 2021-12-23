package hashtable;

public class Mynode<K, V> {
    K key;
    V value;
    Mynode<K, V> next;

    public Mynode(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Mynode<K, V> getNext() {
        return next;
    }

    public void setNext(Mynode<K, V> next) {
        this.next = (Mynode<K, V>) next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nK=").append(key).append(" V=").append(value);
        if(next != null)
        	builder.append(next);
        return builder.toString();
    }
}
