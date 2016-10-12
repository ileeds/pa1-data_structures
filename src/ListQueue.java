import java.util.Scanner;

/**
 * Ian Leeds
 * ileeds@brandeis.edu
 * A basic implementation of a queue using an doubly linked list.
 */
public class ListQueue {
	DoublyLinkedList list;
	int size=0;
	
	
	/**
	 * The default empty constructor.
	 */
	public ListQueue()
	{
		list=new DoublyLinkedList();
	}
	
	
	
	/**
	 * Adds an item to the queue.
	 * @param item - The item to add.
	 */
	public void enqueue(Object item)
	{
		list.addEnd(item);
		size++;
	}
	
	
	
	/**
	 * Dequeues the first item in the queue and returns it. Writes an error
	 * message if the queue is empty.
	 * @return The dequeued item.
	 */
	public Object dequeue()
	{
		//cannot dequeue from empty list
		if (isEmpty()){
			throw new Error("List is empty");
		}
		size--;
		DoublyLinkedList.Node x=list.getFront();
		list.deleteFront();
		return x;
	}
	
	
	
	/**
	 * Gets the current size of the queue.
	 * @return The size of the queue.
	 */
	public int size()
	{
		return size;
	}
	
	
	
	/**
	 * Tests whether the queue is empty.
	 * @return true if empty, false if not
	 */
	public boolean isEmpty()
	{
		if (size==0){
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * Tests whether the queue is full.
	 * @return true if empty, false if not
	 */
	public boolean isFull()
	{
		//never full
		return false;
	}
	
	
	
	public String toString()
	{
		return list.toString();
	}
	
	
	
	/**
	 * A main with which to test the implementation of the queue.
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Declare & Initialize the ListQueue
		ListQueue q = new ListQueue();
	    
	    //Create a scanner object and a string for storing the input
	    Scanner scan = new Scanner(System.in);
	    String cmd;
	    
	    //Print the program's commands to the user.
	    System.out.println("Commands:\n\tenqueue OBJ\n\tdequeue\n\tsize\n\t" +
          "isEmpty\n\tisFull\n\tquit");
	    
	    //Loop through accepting input and printing returned information until quit
	    while (!(cmd=scan.next()).equalsIgnoreCase("quit"))
	    {
	    	if (cmd.equalsIgnoreCase("enqueue"))
	    	{
	    		q.enqueue(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("dequeue"))
	    	{
	    		System.out.println("Dequeued: "+q.dequeue());
	    	}
	    	else if (cmd.equalsIgnoreCase("size"))
	    	{
	    		System.out.println("Size: "+q.size());
	    	}
	    	else if (cmd.equalsIgnoreCase("isEmpty"))
	    	{
	    		System.out.println("IsEmpty: "+q.isEmpty());
	    	}
	    	else if (cmd.equalsIgnoreCase("isFull"))
	    	{
	    		System.out.println("IsFull: "+q.isFull());
	    	}
	    	
	    	//Show what the queue looks like.
	    	System.out.println("Contents:\n\t"+q.toString());
	    }
	}
}

