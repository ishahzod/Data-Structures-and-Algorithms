//Problem1

public class MyLinkedList<L> {
	private Node<L> top;
	private Node<L> bottom;
	private int capacity;

	private static class Node<L> {
		private L data;
		private Node<L> next;

		public Node(L data) {
			this.data = data;
			next = null;
		}
		public void setData(L data) {
			this.data = data;
		}
		public L getData() {
			return data;
		}

		public void setNext(Node<L> next) {
			this.next = next;
		}		
		public Node<L> getNext() {
			return next;
		}
	} 

	// parametrized constructor
	public MyLinkedList() {
		top = bottom = null;
		capacity = 0;
	}

	// mutators and accessors
	public L getTop() {
		return top.getData();
	}

	public L getBottom() {
		return bottom.getData();
	}

	public int cap() {
		return capacity;
	}

	public L get(int index) {
		if (index < 0 || index >= capacity)
			throw new IndexOutOfBoundsException();
		if (index == 0)
			return top.getData();
		Node<L> current = top;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	public void addLast(L item) {
		Node<L> newNode = new Node<L>(item);
		if (capacity == 0)
			top = newNode;
		else
			bottom.setNext(newNode); // old tail
		bottom = newNode;
		capacity++;
	}

	// add with given index
	public void add(int index, L item) {
		if (index < 0 || capacity < index)
			throw new IndexOutOfBoundsException();
		if (index == 0) {
			return;
		}
		if (index == capacity) {
			addLast(item);
			return;
		}

		// now shouldn't go out of bounds
		Node<L> current = top;
		for (int i = 0; i < index - 1; i++)
			current = current.getNext();

		Node<L> newNode = new Node<L>(item);
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		capacity++;
	}

	public L removeFirst() {
		if (capacity <= 0)
			throw new IndexOutOfBoundsException();
		if (capacity == 1)
			bottom = null; 
		L ret = top.getData();
		top = top.getNext();
		capacity--;
		return ret;
	}

	public L removeLast() {
		if (capacity <= 0)
			throw new IndexOutOfBoundsException();
		L ret = bottom.getData();
		Node<L> current = top;
		for (int i = 0; i < capacity - 2; i++)
			current = current.getNext(); // stop at node before node to be removed
		current.setNext(null);
		bottom = current;
		if (capacity == 1)
			top = null; // linked list will be empty after removal 
		capacity--;
		return ret;
	}

	// remove at index
	public L remove(int index) {
		if (index < 0 || index >= capacity)
			throw new IndexOutOfBoundsException();
		if (index == 0)
			return removeFirst();
		if (index == capacity - 1)
			return removeLast();

		L ret;
		Node<L> current = top;
		for (int i = 0; i < index - 1; i++)
			current = current.getNext(); // stops before insertion
		ret = current.getNext().getData();
		current.setNext(current.getNext().getNext()); // removing the last item will output nulls
												
		capacity--;
		return ret;
	}

	@Override
    public String toString() {
	if (capacity <= 0) return "";
	if (capacity == 1) return top.getData().toString();
	
	String rSt = "";
	Node<L> current = top;
	while (current != null) {
	    rSt += current.getData() + " ";
	    current = current.getNext();
	}
	return rSt.substring(0, rSt.length()-1);
    }
}