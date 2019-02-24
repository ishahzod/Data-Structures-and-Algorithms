
public class LinkedStackOfStringsTest {

	public static void main(String[] args) {
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");      
		
		while(!stack.isEmpty()){
			String s = stack.pop();
			System.out.print(s + " ");
			//should print d c b a
		}

	}

}




/* Stack 
     d
	 c
	 b
	 a
*/ 


//The loop reads the stack from top to bottom, since it's popping,'
// d being the first, and a being the last. 