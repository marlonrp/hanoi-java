package stack;

import linkedListImpl.NodeImpl;

public class StackLinkedListImpl<T> {

    private NodeImpl<T> top = null;
    public int topIndex = 0;

    public StackLinkedListImpl() {}

    public void push(T value) {
        NodeImpl<T> node = new NodeImpl<T>(value, null);
        topIndex++;
        if (top == null) {
            this.top = node;
        } else {
            node.setNext(this.top);
            this.top = node;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia!");
        }
        NodeImpl<T> lastTop = this.top;
        this.top = lastTop.getNext();
        topIndex--;
        return lastTop.getValue();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T top() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia!");
        }
        return this.top.getValue();
    }

    public T get(int index) {
        return getInstance(index) == null ? null : getInstance(index).getValue();
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        if (top != null) {
            toString(string, top);
        }
        string.append("]");
        return string.toString();
    }

    private void toString(StringBuilder string, NodeImpl<T> node) {
        string.append(node.toString());
        if (node.getNext() != null) {
            string.append(",");
            toString(string, node.getNext());
        }
    }

    private NodeImpl<T> getInstance(int index) {
        if (index > topIndex -1 || index < 0) {
            return null;
        } else {
            NodeImpl<T> node = top;
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
