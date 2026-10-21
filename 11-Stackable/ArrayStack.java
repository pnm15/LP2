package stack;

public class ArrayStack implements Stack
{
    private int size = 0;
    private int[] element;

    public ArrayStack()
    {
        this(100);
    }

    public ArrayStack(int theSize)
    {
        this.element = new int[theSize];
    }

    public int size()
    {
        return this.size;
    }

    public void push(Object theElement)
    {
        this.element[this.size] = (Integer) theElement;
        this.size++;
    }

    public int pop()
    {
        this.size--;
        return this.element[this.size];
    }
}
