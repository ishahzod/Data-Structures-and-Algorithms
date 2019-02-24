import java.util.Stack;

public class InfixtoPostfix {
	public static boolean operator(int xar) {
		if ((xar == '+') || (xar == '-') || (xar == '/') || (xar == '*'))
			return true;
		return false;
	}

	public static boolean openParentheses(char xar) {
		if ((xar == '{') || (xar == '[') || (xar == '('))
			return true;
		return false;
	}

	public static boolean closeParentheses(char xar) {
		if ((xar == '}') || (xar == ']') || (xar == ')'))
			return true;
		return false;
	}

	public static int precedenceLevel(char op) {
		switch (op) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		case '^':
			return 2;
		case '{':
		case '[':
		case '(':
		case '}':
		case ']':
		case ')':
			return -1;
		default:
			throw new IllegalArgumentException("Operator unknown: " + op);
		}
	}

	public static void main(String[] args) {
  // TODO Auto-generated method stub
  String exp="(1*(((2*(3/(4+5)))-6)+7))";
  System.out.println("infix= "+exp);
  String res="";
  Stack<Character> stack = new Stack<>();
  for(int i=0; i< exp.length(); i++){
   if(Character.isDigit( exp.charAt(i) ) ){
    res+=exp.charAt(i);
   }
   else if( operator(exp.charAt(i)) ){  
    while( !stack.isEmpty() && !openParentheses(exp.charAt(i)) &&
    (precedenceLevel(exp.charAt(i)) <= precedenceLevel( stack.peek())) )
     {
      res+=stack.peek();
      stack.pop();
     }//while
    stack.push( exp.charAt(i) ); 
   }//else if
   else if( openParentheses(exp.charAt(i)) ){
    stack.push(exp.charAt(i));
   }
   else if( closeParentheses(exp.charAt(i)) ){
    while( !stack.isEmpty() && !openParentheses(stack.peek()) ){
     res+=stack.peek();
     stack.pop();
    }
    stack.pop();
   }
  }//for
  while( !stack.isEmpty() ){
   res+=stack.peek();
   stack.pop();
  }
  System.out.println("postfix: "+res);
 }
}