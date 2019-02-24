
public class ResizingArray {
	
	private String[] s;
	private int top = 0;
	
	public ResizingArray(){
		s = new String[1];
	}
	
	public void push(String item){
		if(top == s.length){
			//resizing array: twice the size
			resize(2 * s.length);
		}
		s[top++] = item;
	}
	
	private void resize(int capacity){
		String [] copy = new String[capacity];
		for(int i= 0; i<top; i++)
			copy[i] = s[i];
		s = copy;
	}
	
	//Complexity: N+(2+4+8+..+2^logN) ~ 3N
	
}
