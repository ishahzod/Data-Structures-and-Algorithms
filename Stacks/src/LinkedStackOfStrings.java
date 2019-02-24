//Linked List implementation of Stacks
public class LinkedStackOfStrings {
	private Node first;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void push(String item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public String pop(){
		String item = first.item;
		first = first.next;
		return item;
	}
	
	private class Node{
		private String item;
		private Node next;
	}
}
