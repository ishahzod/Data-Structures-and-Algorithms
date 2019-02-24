//Generic Linked List
public class LinkedList3<T> {   //parameter T for type of data stored in the node
	private class Node<T>{
		private T data;
		private Node<T> link;
		
		public Node(){
			data = null;
			link = null;
		}
		
		public Node(T newData, Node<T> linkValue){
			data = newData;
			link = linkValue;
		}
	}//End of Node<T> inner class
	
	private Node<T> head;
	
	public LinkedList3(){
		head = null;
	}
	
	public void addToStart(T itemData){
		head = new Node<T>(itemData, head);
	}
	
	public boolean deleteHeadNode(){
		if(head!= null){
			head = head.link;
			return true;
		}
		else 
			return false;
	}
	
	public int size(){
		int count = 0;
		Node<T> position = head;
		while(position != null){
			count ++;
			position = position.link;
		}
		return count;
	}
	
	public boolean contains(T item){
		return(find(item) != null);
	}
	
	private Node<T> find(T target){
		Node<T> position = head;
		T itemAtPosition;
		while(position != null){
			itemAtPosition = position.data;
			if(itemAtPosition.equals(target))
				return position;
			position = position.link;
		}
		return null;
	}
	
	public T findData(T target){
		return find(target).data;
	}
	
	public void outputList(){
		Node<T> position = head;
		while(position != null){
			System.out.println(position.data);
			position = position.link;
		}
	}
	
	public boolean isEmpty(){
		return(head == null);
	}
	
	public void clear(){
		head = null;
	}
	
	public boolean equals(Object otherObject){
		if(otherObject == null)
			return false;
		else if(getClass() != otherObject.getClass())
			return false;
		else{
			LinkedList3<T> otherList = (LinkedList3<T>)otherObject;
			if(size() != otherList.size())
				return false;
			Node<T> position = head;
			Node<T> otherPosition = otherList.head;
			while(position != null){
				if(!(position.data.equals(otherPosition.data)))
					return false;
				position = position.link;
				otherPosition = otherPosition.link;
			}
			return true; //no mismatch was not found
		}

	}

}
