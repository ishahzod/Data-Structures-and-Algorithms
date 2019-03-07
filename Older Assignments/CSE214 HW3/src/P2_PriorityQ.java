//Priority Queue for Problem 2

public class P2_PriorityQ {

	private ArrayMaxHeap h;

	public P2_PriorityQ() {
		h = new ArrayMaxHeap();
	}

	P2_PriorityQ(int capacity) {
		h = new ArrayMaxHeap(capacity);
	}

	public void enqueue(int item) {
		h.insert(item);
	}

	public int dequeue() {
		return h.deleteMax();
	}

	@Override
	public String toString() {
		return h.toString();
	}
}
