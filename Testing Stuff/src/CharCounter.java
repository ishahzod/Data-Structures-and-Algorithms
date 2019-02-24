import java.util.*;
public class CharCounter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a string:");
		String str = in.nextLine();
		System.out.print(" Enter a character:");
		char a = in.next().charAt(0);
		
		System.out.println(" " + a + " occurs " + count(str, a) + " times in the string");

	}
	
	public static int count(String str, char a){
		int count = 0;
		boolean seen = false; 
		for(int i = 0; i < str.length(); i++){
			if(a == str.charAt(i)){
				count ++;
				seen = true;
				//break;
			}
			if(seen) continue; 
		}
		return count; 
	}
}
