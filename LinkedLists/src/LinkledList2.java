//Linked List Class with a Node Inner Class
public class LinkledList2 {
	private class Node{
		private String item;
		private Node link; //no difference 
		
		public Node(){
			item = null;
			link = null;
		}
		
		public Node(String newItem, Node linkValue){
			item = newItem;
			link = linkValue;  //An inner class for the node class
		}
	} //End of Node Inner Class
	
	private Node head;
	
	public LinkledList2(){
		head = null;
	}
	
	/* Adds a node in at the start of list with specified data, as the head node*/
	public void addToStart(String itemName){
		head = new Node(itemName, head);
	}
	
	/*Removes the head node and returns true if the list contains at least 1 node*/
	
	public void addToString(String itemName){
		head = new Node(itemName, head);
	}
	
	public boolean deleteHeadNode(){    
		if(head != null){
			head = head.link;
			return true;
		}
		else 
			return false;
	}
	
	/*Return the number of nodes in the list. */
	public int size(){
		int count = 0;
		Node position = head;
		while(position != null){
			count++;
			position = position.link;
		}
		return count;
	}
	
	public boolean contains(String item){
		return (find(item) != null);
	}
	
	private Node find(String target){
		Node position = head;
		String itemAtPosition;
		while(position != null){
			itemAtPosition = position.item;
			if(itemAtPosition.equals(target))
			return position;
			position = position.link;
		}
		return null; //target not found
	}
	
	public void outputList(){
		Node position = head;
		while(position != null){
			System.out.println(position.item);
			position = position.link;
		}
	}
	
	public boolean isEmpty(){
		return (head == null);
	}
	
	public void clear(){
		head = null;
	}
}

