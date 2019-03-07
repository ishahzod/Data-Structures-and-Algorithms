//Binary Tree for Problem 1

public class P1_BTree {

	private int[] data;
	private int cap;   // capacity
	private int last; //refers to the last position 

	public P1_BTree(int capacity) {
		data = new int[capacity];
		cap = capacity;
		last = 0;
	}

	//Adds to the leaf of the tree (the last element of the data array), and increases num of leaves
	public void add(int item) {
		if (last >= cap)
			throw new IllegalStateException(); // checks for out of bounts 
		data[last] = item;
		last++;
	}

	public String inorder() {
		return inorderH(0);
	}

	public String inorderH(int p) {
		String r = "";
		if (last == 0)
			return r;
		
		//Equations for the left and right position of node i
		int rightP = p * 2 + 2;
		int leftP = p * 2 + 1;

		if (leftP < last)
			r += inorderH(leftP);
		
		r += data[p] + " ";
		
		if (rightP < last)
			r += inorderH(rightP);
		return r;
	}
}