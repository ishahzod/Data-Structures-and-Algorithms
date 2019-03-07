//Problem1
import java.util.NoSuchElementException;

//LinkedList Queue with constructors and methods

public class LinkedQueue<T>  {
	private MyLinkedList<T> List;

	// constructors
	public LinkedQueue() {
		List = new MyLinkedList<T>();
	}


	public void enqueue(T item) {
		List.addLast(item);
	}

	public T dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		return List.removeFirst();
	}


	public T peekFront() {
		if (isEmpty())
			throw new NoSuchElementException();
		return List.getTop();
	}

	public boolean isEmpty() {
		return List.cap() < 0;
	}

	public int cap() {
		return List.cap();
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "";
		String rSt = "";  //return string
		T last = List.getBottom();
		while (List.getTop() != last) {
			T current = List.removeFirst();
			rSt += current + " ";
			List.addLast(current);
		}

		// last element in the list
		List.addLast(List.removeFirst());
		rSt += last;
		return rSt;
	}
}
