/**
 * Ian Leeds
 * ileeds@brandeis.edu
 * A basic implementation of a Stack
 */
public class Stack {
	//this array will store the data in the stack
	Object array[];
	int top=0;
	
	
	/**
	 * The default empty constructor. This initializes the max capacity
	 * of the stack to be 10.
	 */
	public Stack()
	{
		array=new Object[10];
	}
	
	
	
	/**
	 * This constructor initializes the max capacity of the stack to
	 * be the specified value.
	 * @param capacity - The capacity of the stack.
	 */
	public Stack(int capacity)
	{
		array=new Object[capacity];
	}
	
	
	
	/**
	 * Pushes a new item onto the top of the stack
	 * @param item - the item to push
	 */
	public void Push(Object item)
	{
		//item pushed past capacity
		if (top>=array.length){
			throw new Error("stack overflow");
		}else{
			top++;
			array[top]=item;
		}
	}
	
	
	
	/**
	 * Pops an item from the stack.
	 * @return the item that was previously on top of the stack
	 */
	public Object Pop()
	{
		//cannot pop from empty stack
		if (IsEmpty()){
			throw new Error("stack overflow");
		}else{
			top--;
			return array[top+1];
		}
	}

	
	
	/**
	 * Peeks at the top item on the stack without popping it.
	 * @return the top item of the stack
	 */
	public Object Peek()
	{
		return array[top];
	}
	
	
	
	/**
	 * Tests whether the stack is empty.
	 * @return true if empty, false if not
	 */
	public boolean IsEmpty()
	{
		//only empty if top is at 0
		if (top==0){
			return true;
		}
		return false;
	}
}
