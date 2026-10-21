public class ArrayStack implements IStackable
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

    public void push(int v)
    {
        this.element[this.size] = v;
        this.size++;
    }

    public int pop()
    {
        this.size--;
        return this.element[this.size];
    }
}
