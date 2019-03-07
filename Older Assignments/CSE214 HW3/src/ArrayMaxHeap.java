import java.util.NoSuchElementException;

/*Implementation of Max Heap using arrays */
public class ArrayMaxHeap {

	private int[] data;
	private int cap;
	private int size;
	private final static int default_cap = 127;

	public ArrayMaxHeap() {
		this(default_cap);
	}

	public ArrayMaxHeap(int capacity) {
		cap = capacity;
		data = new int[cap];
		size = 0;
	}
	
	public void swap(int a, int b) {
		data[a] = data[a] ^ data[b];  //XOR logic
		data[b] = data[a] ^ data[b];
		data[a] = data[a] ^ data[b];
	}
	
	/*Insertion at leaf*/
	public void insert(int item) {
		if (isFull())
			throw new IllegalStateException();
		data[size] = item; 

		// swaps the node with the parent until the max heap condition is satisfied
		int currentP = size;
		int parentP = (currentP - 1) / 2;
		while (currentP > 0 && data[currentP] > data[parentP]) {
			swap(currentP, parentP);
			currentP = parentP;
			parentP = (currentP - 1) / 2;
		}
		size++;
	}

	public int deleteMax() {
		if (isEmpty())
			throw new NoSuchElementException();
		int r = data[0]; // item to be deleted
		size--;
		data[0] = data[size]; // swap last with root
		int currentP = 0;
		int childP = 1;
		while (childP < size) {
			if (childP + 1 < size && data[childP] < data[childP + 1])
				childP++;
			if (data[childP] > data[currentP])
				swap(childP, currentP);
			currentP = childP;
			childP = 2 * currentP + 1;
		}
		return r;
	}

	public boolean isFull() {
		return size == cap;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}


	@Override
	public String toString() {
		String rString = "[ ";
		for (int i = 0; i < size; i++)
			rString += data[i] + " ";
		return rString + "]";
	}
}