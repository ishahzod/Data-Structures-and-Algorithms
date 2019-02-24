
public class IntNode {
	private int data;
	private IntNode link;
	
	//default constructor
	public IntNode(int initialData){
		data = initialData;
		link = null;
	}
	public int getData(){
		return data;
	}
	
	public IntNode getLink(){
		return link;
	}
	
	public void setData(int newData){
		data = newData;
	}
	
	public void setLink(IntNode newLink){
		link = newLink;
	}

	
}
