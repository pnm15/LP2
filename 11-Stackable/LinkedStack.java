/*LinkedList: size,addFirst,removeFirst */
public class LinkedStack<Item> implements Iterable<Item> {
    private int n;          // size of the stack
    private Node first;     // top of stack

    // helper linked list class
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
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        int v = first.v;        // save item to return
        first = first.next;            // delete first node
        n--;
        return int;                   // return the saved item
    }
