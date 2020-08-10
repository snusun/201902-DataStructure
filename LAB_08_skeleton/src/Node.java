public class Node<K extends Comparable, E> {
    private K k;
    private E item;

    public Node() {
        this.k = null;
        this.item = null;
    }

    public Node(K newKey, E newItem) {
        this.k = newKey;
        this.item = newItem;
    }

    public void setKey(K newKey) {
        this.k = newKey;
    }

    public K getKey() {
        return this.k;
    }

    public void setItem(E newItem) {
        this.item = newItem;
    }

    public E getItem() {
        return this.item;
    }

    public String toString() {
        return String.format("[%2s%2s] ", "" + k, "" + item);
    }
}
