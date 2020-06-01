package linkedListImpl;

import java.util.Objects;

@SuppressWarnings("ALL")
public class LinkedListImpl<T> {

    private NodeImpl<T> first;
    private NodeImpl<T> last;
    private int counter = 0;


    public LinkedListImpl() {}

    public void add(T value) {
        NodeImpl<T> node = new NodeImpl<T>(value, null);
        if(counter == 0) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
            last = node;
        }
        counter++;
    }

    public void add(T value, int index) {
        if (index == 0) {
            NodeImpl<T> node = new NodeImpl<T>(value, first);
            first = node;
        } else {
            NodeImpl<T> nodeBefore = getInstance(index -1);
            NodeImpl<T> node = new NodeImpl<T>(value, getInstance(index));
            nodeBefore.setNext(node);
        }
        counter++;
    }

    public T get(int index) {
        return getInstance(index).getValue();
    }

    public void clear() {
        first = null;
        last = null;
        counter = 0;
    }

    public int size() {
        return counter;
    }

    public boolean isEmpty() {
        return counter == 0 && Objects.isNull(first) && Objects.isNull(last);
    }

    public NodeImpl<T> remove(int index) {
        NodeImpl<T> node = getInstance(index);
        Objects.requireNonNull(getInstance(index - 1)).setNext(getInstance(index + 1));
        counter--;
        return node;
    }

    public boolean removeFirst(T value) {
        int i = indexOf(value);
        if (i > -1) {
            remove(i);
            counter--;
            return true;
        } else {
            return false;
        }
    }

    public int indexOf(T value) {
        NodeImpl<T> node;
        int i = 0;
        if (Objects.nonNull(value)) {
            for(node = this.first; node != null; node = node.getNext()) {
                if (value.toString().equals(node.getValue().toString())) {
                    return i;
                }
                ++i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T value) {
        int index = counter;
        NodeImpl<T> node;
        if (Objects.nonNull(value)) {
            for(node = last; index > 0; node = getInstance(index-1)) {
                --index;
                if (value.toString().equals(node.getValue().toString())) {
                    return index;
                }
            }
        }
        return -1;
    }

    public T set (T value, int index) {
        NodeImpl<T> beforeNode =  getInstance(index-1);
        NodeImpl<T> afterNode =  getInstance(index+1);
        NodeImpl<T> node = new NodeImpl<T>(value, afterNode);
        beforeNode.setNext(node);
        return node.getValue();
    }

    public boolean contains (T value) {
        return indexOf(value) != -1;
    }

    public T[] toArray() {
        NodeImpl<T> node;
        T[] list = (T[]) new Object[counter];
        int i = 0;
        for (node = first; node != null ; node = node.getNext()) {
            list[i] = node.getValue();
            i++;
        }
        return list;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        if (first != null) {
            toString(string, first);
        }
        string.append("]");
        return string.toString();
    }

    //Private

    private void toString(StringBuilder string, NodeImpl<T> node) {
        string.append(node.toString());
        if (node.getNext() != null) {
            string.append(",");
            toString(string, node.getNext());
        }
    }

    private NodeImpl<T> getInstance(int index) {
        if (index > counter -1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index!");
        } else {
            NodeImpl<T> node = first;
            for (int j = 0; j <= index; j++) {
                if (j == index) {
                    return node;
                }
                node = node.getNext();
            }
            return null;
        }
    }
}
