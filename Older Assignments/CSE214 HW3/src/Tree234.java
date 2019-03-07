

class ItemData
{

	public double dData; // one data item
	public ItemData(double dd){ // constructor
		dData = dd;
	}
	public void displayItem(){ // display item, format "27"
		System.out.print(dData + " ");
	}
} 

class Node{
	private static final int ORDER = 4;
	private int numItems;
	private Node parent;
	private Node childArray[] = new Node[ORDER];
	private ItemData itemArray[] = new ItemData[ORDER - 1];


	// connect child to this node
	public void connect(int childNum, Node child){
		childArray[childNum] = child;
		if (child != null)
			child.parent = this;
	}

	// disconnect child from this node, return it
	public Node disconnect(int childNum){
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	public Node getChild(int childNum){
		return childArray[childNum];
	}

	public Node getParent()	{
		return parent;
	}

	public boolean isLeaf(){
		return (childArray[0] == null) ? true : false;
	}
	
	public int getNumItems(){
		return numItems;
	}

	public ItemData getItem(int index){
		return itemArray[index];
	}

	public boolean isFull(){
		return (numItems == ORDER - 1) ? true : false;
	}

	// -------------------------------------------------------------

	public int findItem(double key) // return index of

	/*Should use binary search if ORDER is large.
	Could also return the index of the pointer to chase
 	if the item is not found (for example: return -i means
	key not found, but you need to follow childArray[i]
	this would save looping in getnextchild */

	{ // item (within node)

		for (int j = 0; j < ORDER - 1; j++) { 
			if (itemArray[j] == null) // return -1
				break;
			else if (itemArray[j].dData == key)
				return j;
		}
		return -1;
	} 
	public int insert(ItemData newItem){
		// assumes node is not full
		numItems++; // will add new item
		double newKey = newItem.dData; // key of new item
		// Should start this for loop at numItems-1, rather than ORDER -2
		for (int j = ORDER - 2; j >= 0; j--) // start on right,
		{ 
			if (itemArray[j] == null) // if item null,
				continue; // go left one cell
			else {// not null,
				 // get its key
				double itsKey = itemArray[j].dData;
				if (newKey < itsKey) // if it's bigger
					itemArray[j + 1] = itemArray[j]; // shift it right
				else
				{
					itemArray[j + 1] = newItem; // insert new item
					return j + 1; // return index to
				} // new item
			} // end else (not null)
		} // end for // shifted all items,
		itemArray[0] = newItem; // insert new item
		return 0;
	}
	public ItemData remove(){  //removes the largest item
		// assumes node not empty
		ItemData temp = itemArray[numItems - 1]; // save item
		itemArray[numItems - 1] = null; // disconnect it
		numItems--; // one less item
		return temp; // return item
	}

	public void displayNode(){
		for (int j = 0; j < numItems; j++)
			itemArray[j].displayItem(); // "/56"
	}
} 

class Tree234{
	private Node root = new Node(); // make root node
	public int find(double key){
		Node currentN = root;
		int childNumber;
		while (true){
			if ((childNumber = currentN.findItem(key)) != -1)
				return childNumber; // found 
			else if (currentN.isLeaf())
				return -1; 			// not found
			else 					// search deeper
				currentN = getNextChild(currentN, key);

		}

	}
	public void insert(double dValue){

		Node currentN = root;
		ItemData tempItem = new ItemData(dValue);
		while (true){

			if (currentN.isFull()){
				split(currentN); // split it
				currentN = currentN.getParent(); // back up
				// search once
				currentN = getNextChild(currentN, dValue);
			} 
			else if (currentN.isLeaf()) // if node is leaf,
				break; // insert
			// node is not full, not a leaf; so go to lower level
			else
				currentN = getNextChild(currentN, dValue);
		} 
		currentN.insert(tempItem); // insert new ItemData
	} 
	public void split(Node thisNode){

		// assumes node is full
		ItemData itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;
		itemC = thisNode.remove(); // remove items from
		itemB = thisNode.remove(); // this node
		child2 = thisNode.disconnect(2); // remove children
		child3 = thisNode.disconnect(3); // from this node
		Node newRight = new Node(); // make new node
		if (thisNode == root){

			root = new Node(); // make new root
			parent = root; // root is our parent
			root.connect(0, thisNode); // connect to parent
		}

		else // this node not the root
			parent = thisNode.getParent(); // get parent
		// deal with parent
		itemIndex = parent.insert(itemB); // item B to parent
		int n = parent.getNumItems(); // total items?
		for (int j = n - 1; j > itemIndex; j--){ // connections

			Node temp = parent.disconnect(j); // one child
			parent.connect(j + 1, temp); // to the right
		}
		// connect newRight to parent
		parent.connect(itemIndex + 1, newRight);
		// deal with newRight
		newRight.insert(itemC); // item C to newRight
		newRight.connect(0, child2); // connect to 0 and 1
		newRight.connect(1, child3); // on newRight
	}
	// gets appropriate child of node during search for value

	public Node getNextChild(Node theNode, double theValue){
		// Should be able to do this w/o a loop, since we should know
		// index of correct child already
		// assumes node is not empty, not full, not a leaf
		int numItems = theNode.getNumItems();
		int j;
		for (j = 0; j < numItems; j++){
			if (theValue < theNode.getItem(j).dData)
				return theNode.getChild(j); // return left child
		}
		return theNode.getChild(j); // return right child
	}

	/*Various display methods for pre, in, and post order traversals */
	
	public void displayTree(int n){
		if (n == 5)
			displayPreorder(root, 0, 0);
		else if (n == 4)
			displayInorder(root, 0, 0);
		else if (n == 6)
			displayPostorder(root, 0, 0);
	}

	private void displayPreorder(Node thisNode, int level,int childNumber){
		thisNode.displayNode(); // display this node
		
		// call for each child of this node
		int numItems = thisNode.getNumItems();
		for (int j = 0; j < numItems + 1; j++)
		{
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null)
				displayPreorder(nextNode, level + 1, j);
			else
				return;
		}
	}
	
	private void displayInorder(Node thisNode, int level,int childNumber){
		// call ourselves for each child of this node
		int numItems = thisNode.getNumItems();
		for (int j = 0; j < numItems + 1; j++){
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null){
				displayInorder(nextNode, level + 1, j);
				thisNode.displayNode();
			}
			else
				return;
		}
	} 
	
	private void displayPostorder(Node thisNode, int level, int childNumber){
		// call ourselves for each child of this node
		int numItems = thisNode.getNumItems();
		for (int j = 0; j < numItems + 1; j++){
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null)
				displayPostorder(nextNode, level + 1, j);
			else
				return;
		}
		thisNode.displayNode(); // display this node
	} 
} 