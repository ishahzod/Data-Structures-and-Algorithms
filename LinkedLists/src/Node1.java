
public class Node1 {
	private String item;
	private int count;
	private Node1 link; /*A node contains a reference to another node. 
							That reference is the link to the next node.*/
	
	public Node1(){
		link = null;   //We define a number of node classes so we numbered the names
		item = null;
		count = 0;       
	}
	
	public Node1(String newItem, int newCount, Node1 linkValue){
		setData(newItem, newCount);
		link = linkValue;
	}
	
	public void setData(String newItem, int newCount){
		item = newItem;
		count = newCount;
	}
	
	public void setLink(Node1 newLink){
		link = newLink;
	}
	
	public String getItem(){ 
		return item; 
	}
	
	public int getCount(){
		return count;
	}
	
	public Node1 getLink(){
		return link;
	}
	

}
