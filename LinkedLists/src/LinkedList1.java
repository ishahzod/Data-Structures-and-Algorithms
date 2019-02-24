
public class LinkedList1 {
	private Node1 head;   //declaring the head;
	
	public LinkedList1(){
		head = null;  //initially null
	}
	
	/*
	 Adds a node at the start of the list with the specified data.
	 The added node will be the first node in the list
	 */
	
	public void addToStart(String itemName, int itemCount){
		head = new Node1(itemName, itemCount, head);
		/*gives the location of the current first node on the list
	 	   hence, if a new node is created, its link field is set to head
		 */
	}
	
	
	/*Removes the head node and returns true if the list contained at least 
	 * one node. Returns false if the list was empty.
	 */
	
	public boolean deleteHeadNode(){    
		if(head != null){
			head = head.getLink();
			return true;
			
		/*This node will automatically be collected and its memory recycled
		 * by the compiler, along with any other nodes that are no
		 * longer accessible. 
		 */
		}
		else 
			return false;
	}
	
	/*Method to return the # of nodes in the list*/
	public int size(){
		int count = 0;
		Node1 position = head;
		
		while(position != null){   //The last node is indicated by the link field being equal to null
			count++;
			position = position.getLink();
		}
		return count;
	}
	
	public boolean contains(String item){
		return (find(item) != null);
	}
	
	/*Finds the first node containing the target item and returns the reference*/
	
	private Node1 find(String target){
		Node1 position = head;
		String itemAtPosition; 
		while(position != null){
			itemAtPosition = position.getItem();
			if(itemAtPosition.equals(target))
				return position;
		}
		return null; //target not found
	}
	
	public void outputList(){
		Node1 position = head;
		while(position != null){
			System.out.println(position.getItem() + " " + position.getCount());
			position = position.getLink();
		}
	}
	

}
