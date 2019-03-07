//Problem3
public class LeakyStack<T> {

	private T[] stack;
	private int bottom;
	private int top;
	private int cap; //capacity

	public LeakyStack(int cap) {

		this.cap = cap;
		this.stack = (T[]) new Object[this.cap];
		this.bottom = -1;
		this.top = -1;
	}

	// Method that returns the total# of elements in the stack
	public int size() {

		if (this.bottom == this.top) {
			if (this.top != -1)
				return 1;
			else
				return 0;
		} 
		else if (this.bottom < this.top)
			return ((this.top - this.bottom) + 1);
		else
			return (this.cap + ((this.top - this.bottom) + 1));
	}

	public boolean isEmpty() {
		return (this.top == -1);

	}

	// Adds to the top of the stack. If the cap is reached, an element is
	// removed from bottom

	public void push(T e) {

		// Check if cap is reached
		if (size() == this.cap) {
			this.bottom = (this.bottom + 1) % this.cap;
			this.top = (this.top + 1) % this.cap;
		} 
		else {
			if (isEmpty())
				this.bottom += 1;
			this.top += 1;
		}
		// Adds element to the top of the stack
		this.stack[this.top] = e;
	}
	
	
	// Overrides the Object class's toString method for this case
	@Override

	public String toString() {

		if (this.top == -1)
			return "";
		else {
			StringBuffer sBuffer = new StringBuffer();
			int start = this.bottom;

			// bottom most element gets appended
			sBuffer.append(this.stack[start]);

			// the remaining elements get appended
			while (start != this.top) {

				start = (start + 1) % this.cap;
				sBuffer.insert(0, this.stack[start] + " ");
			}
			return sBuffer.toString();
		}
	}
}