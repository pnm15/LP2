package stack;

public class LinkedStack implements IStackable
{
    private int n;
    private Node first;

    private class Node {
        private int v;
        private Node next;
    }

    public LinkedStack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(int v) {
        Node oldfirst = first;
        first = new Node();
        first.v = v;
        first.next = oldfirst;
        n++;
    }

    public int pop() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Stack underflow");
        int v = first.v;
        first = first.next;
        n--;
        return v;
    }
}
