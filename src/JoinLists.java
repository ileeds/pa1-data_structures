/**
 * Ian Leeds
 * ileeds@brandeis.edu
 * A class which joins two circular doubly linked lists.
 */
public class JoinLists {
	
	/**
	 * The main used for testing the implementation of JoinLists in DoublyLinkedList
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Initialize the lists
		DoublyLinkedList list1 = new DoublyLinkedList();
		DoublyLinkedList list2 = new DoublyLinkedList();
		
		//Add values to the first list
		list1.addEnd("a");
		list1.addEnd("b");
		list1.addEnd("c");
		list1.addEnd("d");
		
		//Add values to the second list
		list2.addEnd(1);
		list2.addEnd(2);
		list2.addEnd(3);
		list2.addEnd(4);
		
		//make the lists circular
		list1.makeCircular();
		list2.makeCircular();
		
		//Merge the two lists
		DoublyLinkedList list3 = DoublyLinkedList.joinLists(list1, list2);
		
		//DO: Write the code to print the output of the join (list3)
		System.out.println(list3);
	}
	
}
