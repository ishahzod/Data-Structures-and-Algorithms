
//Array implementation of Queue
public class ArrayQueue {
	private String[] q; //queue elements
	private int n; //number of elements in queue
	private int first; //index of first element of queue
	private int last; //index of next available slot
	
	public ArrayQueue(int capacity){
		q = new String [capacity];
		n = 0;
		first = 0;
		last = 0; 
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() { 
		return n; 
	}
	
	public void enqueue(String item){
		if(n == q.length)
			throw new IndexOutofBoundsException();
		q[last++] = item; //add item
		if(last == q.length)
			last = 0;  //wrap around
		n++;
	}
	
	public String dequeue(){
		if(isEmpty())
			throw new NoSuchElementException("Queue underflow");
		String item = q[first];
		q[first] = null; //avoid loitering
		n--;
		first++;
		if(first == q.length)
			first = 0; //wrap around
		
		return item;
	}
	
	public String peek(){
		if(isEmpty())
			throw new NoSuchElementException("Queue underflow");
		return q[first];
	}
}
