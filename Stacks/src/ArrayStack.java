//Array Impelementation of a Stack
public class ArrayStack {
	private String [] s;
	private int top =0;
	
	public ArrayStack(int capacity){
		s = new String[capacity];
	}
	
	public boolean isEmpty(){
		return top ==0;
	}
	
	public void push(String item){
		s[top++] = item;
	}
	
/*	//Loitering - holding a reference to object no longer needed
	public String pop(){
		return s[--top];
	}*/
	
	//Avoids Loitering
	public String pop(){
		String item = s[--top];
		s[top] = null;
		return item;
		
	}


}
