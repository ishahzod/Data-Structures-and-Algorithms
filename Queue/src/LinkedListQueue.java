
public class LinkedListQueue {
	private Node first, last;
	
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void enqueue(String item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) 
			first = last;
		else
			oldlast.next = last;
	}
	
	public String dequeue(){
		String item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		return item;
	}
	
	
	// Test
	public static void main(String [] args){
		LinkedListQueue queue = new LinkedListQueue();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		
		while(!queue.isEmpty()){
			String q = queue.dequeue();
			System.out.print(q + " ");
		}
	}

}
