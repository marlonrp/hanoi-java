package linkedListImpl;

public class NodeImpl<T> {

    private T value;
    private NodeImpl<T> next;

    public NodeImpl(T value, NodeImpl<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeImpl<T> getNext() {
        return next;
    }

    public void setNext(NodeImpl<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{\n" + value + "\n}";
    }

}
