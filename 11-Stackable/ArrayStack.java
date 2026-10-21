ArrayList: size,add,remove
package stack;

//An ArrayStack uses an internal Object array to store elements.
public class ArrayStack implements Stack
{
	private int size = 0;
	private inteiro[] element;
	
	//Initialize an ArrayStack of size 100
	public ArrayStack()
	{
		this(100);
	}
	
	//Initialize an ArrayStack of size theSize
	public ArrayStack(int theSize)
	{
		this.element = new inteiro[theSize];
	}
	
	//post: returns number of elements in this stack
	public int size()
	{
		return this.size;
	}
	
	//post: theElement is added to the top of this stack
	public void push(Object theElement)
	{
		if(this.element.length == this.size) {
			doubleArrayCapacity();
		}
		
		this.element[this.size] = theElement;
		this.size++;
	}
	
	//pre: stack not empty
	//post: removes top element and returns it
	public inteiro pop()
	{

		this.size--;

		inteiro removedElement = this.element[this.size];
		this.element[this.size] = null;
		
		return removedElement;
	}
