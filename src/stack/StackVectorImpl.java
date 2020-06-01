package stack;

public class StackVectorImpl {

    private Object[] vector;
    int topIndex;

    public StackVectorImpl() {
        this.vector = new Object[10];
        topIndex = -1;
    }

    public void push(Object value) {
        if (isFull()) {
            throw new RuntimeException("Pilha ja está cheia!");
        }
        topIndex++;
        vector[topIndex] = value;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia!");
        }
        Object top = vector[topIndex];
        topIndex--;
        return top;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFull() {
        return topIndex == vector.length-1;
    }

    public Object top() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia!");
        }
        return vector[topIndex];
    }
}
