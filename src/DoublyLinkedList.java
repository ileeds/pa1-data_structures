import java.util.Scanner;

/**
 * Ian Leeds
 * ileeds@brandeis.edu
 * A basic implementation of a doubly linked list
 */
public class DoublyLinkedList {
	//Add the fields necessary for this class here
	//first node of list
	Node head;
	
	/**
	 * The node class used to store the nodes of the 
	 * doubly linked list.
	 */
	public class Node
	{
		//Implement a node containing a reference to a
		//previous node and a reference to a next node
		//as well as a value.
		Node previous;
		Node next;
		Object value;
		
		public Node(Node previous, Node next, Object value){
			this.previous=previous;
			this.next=next;
			this.value=value;
		}
		
		//return value stored in node as string representation
		public String toString(){
			return value.toString();
		}
	}
	
	
	
	/**
	 * The default constructor
	 */
	public DoublyLinkedList()
	{
		
	}
	
	
	
	/**
	 * Adds an item to the front of the doubly linked list
	 * @param item - the item to add
	 */
	public void addFront(Object item)
	{
		//new node with head as next node and item as value
		Node node=new Node(null, head, item);
		//if there is a head, previous pointer to this node
		if (head!=null){
			head.previous=node;
		}
		//head points to this node
		head=node;
		//previous pointer to null
		head.previous=null;
	}
	
	
	
	/**
	 * Inserts an item into a specified position in the doubly linked list
	 * @param item - the item to add
	 * @param position - the position in the list where the item should be inserted
	 */
	public void addMid(Object item, int position)
	{
		//adding to front
		if (position==0){
			addFront(item);
		//position does not exist
		}else if (position<0){
			throw new Error("Index out of bounds");
		}else{
			//traverse list until node before desired position
			int start=0;
			Node y=head;
			while (start!=position-1){
				y=y.next;
				if (y==null){
					throw new Error("Index out of bounds");
				}
				start++;
			}
			//attach input node to this node, and input node to next node
			Node x=new Node(null, y.next, item);
			if (x.next!=null){
				(x.next).previous=x;
			}
			y.next=x;
			x.previous=y;
		}
	}
	
	
	
	/**
	 * Adds an item to the end of the doubly linked list.
	 * @param item - the item to add
	 */
	public void addEnd(Object item)
	{
		Node y=head;
		//if no head, same as addFront
		if (head==null){
			addFront(item);
		//if no node after head, add to spot after head
		}else if (y.next==null){
			addMid(item,1);
		}else{
			//find last node
			while (y.next!=null){
				y=y.next;
			}
			//attach after last node
			Node x=new Node(y, null, item);
			y.next=x;
		}
	}
	
	
	
	/**
	 * Deletes the first item of the list. Writes an error message if the list is empty.
	 * @return a reference to the new first node of the list.
	 */
	public Node deleteFront()
	{
		//cannot delete from empty list
		if (head==null){
			throw new Error("List empty");
		}else{
			//move head to next, head previous to null
			head=head.next;
			if (head!=null){
				head.previous=null;
			}
			return null;
		}
	}
	
	
	
	/**
	 * Deletes the last item of the list. Writes an error message if the list is empty.
	 */
	public void deleteEnd()
	{
		if (head==null){
			throw new Error("List empty");
		}else{
			Node x=head;
			//find last node
			while (x.next!=null){
				x=x.next;
			}
			if (x.previous!=null){
				(x.previous).next=x.next;
			//if only head in list, head removed
			}else{
				head=x.next;
			}
		}
	}
	
	
	
	/**
	 * Deletes the first occurrence of the specified item from the list. Writes an error
	 * message if the list doesn't contain the item.
	 * @param item - the item to delete
	 */
	public void delete(Object item)
	{
		Node x=head;
		//finds item
		while (!x.value.equals(item)){
			x=x.next;
			if (x==null){
				throw new Error("Item not in list");
			}
		}
		//removes node with item
		if (x.previous!=null){
			(x.previous).next=x.next;
		}else{
			head=x.next;
		}
		if (x.next!=null){
			(x.next).previous=x.previous;
		}
	}
	
	
	
	/**
	 * Deletes all occurrences of the specified item from the list. Writes an error
	 * message if the list doesn't contain the item.
	 * @param item - the item to delete
	 */
	public void deleteAll(Object item)
	{
		Node x=head;
		boolean change=false;
		//similar to delete, but must traverse entire array
		while (x!=null){
			if (x.value.equals(item)){
				change=true;
				if (x.previous!=null){
					(x.previous).next=x.next;
				}else{
					head=x.next;
				}
				if (x.next!=null){
					(x.next).previous=x.previous;
				}
			}
			x=x.next;
			if (x==null && change==false){
				throw new Error("Item not in list");
			}
		}
	}
	
	
	
	/**
	 * Searches for the specified item in the list.
	 * @param item - the item to search for.
	 * @return true if the item is in the list, false otherwise.
	 */
	public boolean contains(Object item)
	{
		//returns false only if end of list reached without finding item
		Node x=head;
		while (!x.value.equals(item)){
			x=x.next;
			if (x==null){
				return false;
			}
		}
		return true;
	}
	
	
	
	/**
	 * Makes this list a circular one by having the last node refer
	 * back to the first.
	 */
	public void makeCircular()
	{
		Node x=head;
		//cannot make empty list circular
		if (x==null){
			throw new Error("List empty");
		}
		boolean circled=false;
		//for single node lists
		if (x.next==null){
			circled=true;
			x.next=head;
			head.previous=x;
		}
		//will traverse until end found, link end to head, and exit loop
		while (x.next!=null && circled==false){
			x=x.next;
			if (x.next==null){
				circled=true;
				x.next=head;
				head.previous=x;
			}
		}
	}
	
	
	
	/**
	 * Returns the first node of the list.
	 * @return the first node.
	 */
	public Node getFront()
	{
		//replace the following line with desired output
		return head;
	}
	
	
	
	/**
	 * Joins two circular lists by making the elements alternate.
	 * The first list will be in the odd positions and the second will
	 * be in the even positions. Do this without creating a new list or
	 * making new nodes.
	 * 
	 * For example:
	 *     listOdds = 1 2 3 4 (circular)
	 *     listEvens = a b c d (circular)
	 *     
	 *     returns 1 a 2 b 3 c 4 d (circular)
	 * @param listOdds - the list to merge into the odd positions.
	 * @param listEvens - the list to merge into the even positions. 
	 * @return the first node of the merged list.
	 */
	//had solution before, still working on solution with new headers
	public static DoublyLinkedList joinLists(DoublyLinkedList listOdds, DoublyLinkedList listEvens)
	{
		Node headOdd=listOdds.getFront();
		Node headEven=listEvens.getFront();
		do{
			//first odd to first even, then first even to second odd
			Node tempOne=headOdd.next;
			Node tempTwo=headEven.next;
			headOdd.next=headEven;
			headEven.previous=headOdd;
			headEven.next=tempOne;
			tempOne.previous=headEven;
			//headOdd and headEven to next node
			headOdd=tempOne;
			headEven=tempTwo;
		}while (!headOdd.equals(listOdds.getFront()) && !headEven.equals(listEvens.getFront()));
		//if odd longer than even, odds will already be attached correctly to end of list
		//... but if even longer than odd
		if (!headEven.equals(listEvens.getFront())){
			//end of list to current listEvens node
			(listOdds.getFront().previous).next=headEven;
			headEven.previous=listOdds.getFront().previous;
			//find end node of listEvens
			while (!headEven.next.equals(listEvens.getFront())){
				headEven=headEven.next;
			}
			//end node of listEvens to head of listOdds
			listOdds.getFront().previous=headEven;
			headEven.next=listOdds.getFront();
		}
		return listOdds;
	}
	
	
	
	public String toString()
	{
		//This procedure should visualize the contents of the list 
		//as a string. Refer to a similar procedure in ArrayQueue.
		//replace the following line with desired output
		Node temp = head;
        if (temp == null){
            return null;
        }
        String result = temp.value.toString();
        temp = temp.next;
        while (temp!=head && temp!=null) {
           result+=temp.value.toString();
           temp=temp.next;
        }
        return result;
	}
	
	
	
	/**
	 * A main with which to test the implementation of the queue.
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Initialize the list
		DoublyLinkedList dll = new DoublyLinkedList();
	    
	    //Create a scanner object and a string for storing the input
	    Scanner scan = new Scanner(System.in);
	    String cmd;
	    
	    //Print the program's commands to the user.
	    System.out.println("Commands:\n\taddFront OBJ\n\taddEnd OBJ" +
          "\n\taddMid OBJ POSITION\n\tdeleteFront\n\tdeleteEnd"+
          "\n\tdelete OBJ\n\tdeleteAll OBJ\n\tcontains OBJ\n\tquit");
	    
	    //Loop through accepting input and printing returned information until quit
	    while (!(cmd=scan.next()).equalsIgnoreCase("quit"))
	    {
	    	if (cmd.equalsIgnoreCase("addFront"))
	    	{
	    		dll.addFront(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("addEnd"))
	    	{
	    		dll.addEnd(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("addMid"))
	    	{
	    		dll.addMid(scan.next(), scan.nextInt());
	    	}
	    	else if (cmd.equalsIgnoreCase("deleteFront"))
	    	{
	    		dll.deleteFront();
	    	}
	    	else if (cmd.equalsIgnoreCase("deleteEnd"))
	    	{
	    		dll.deleteEnd();
	    	}
	    	else if (cmd.equalsIgnoreCase("delete"))
	    	{
	    		dll.delete(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("deleteAll"))
	    	{
	    		dll.deleteAll(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("contains"))
	    	{
	    		System.out.println("Contains: "+dll.contains(scan.next()));
	    	}
	    	
	    	//Show what the list looks like
	    	System.out.println("Contents:\n\t"+dll.toString());
	    }
	}
}
