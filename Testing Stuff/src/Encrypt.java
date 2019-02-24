/*Write a static public method called encrypt, that takes one String as an argument and returns a String. 
 * The method encrypts a word, by replacing each letter with the character two places ahead of it in the alphabet.
wrap around to the front (i.e. ‘y’ = ‘a’, ‘z’ = ‘b’). Assume that all input consists solely of lowercase letters, and that only one word is input.
 */

/*Write a static public method called reverse, that accepts one String as an argument, returns nothing, and prints the reverse of the input.*/

import java.util.*;
public class Encrypt {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a string you want to encrypt: ");
		String s = in.nextLine();

		encrypt(s);
		reverse(s);
		lowerUpper(s);
	}

	public static void encrypt(String s){
		String e = "";
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == 'y'|| s.charAt(i) == 'z')
				continue;	
			if(Character.isAlphabetic(s.charAt(i))) //&& !(s.charAt(i) == 'y'|| s.charAt(i) == 'z'))
				e += (char) (s.charAt(i) + 2);
		}
		for(int j =0; j<s.length(); j++){
			if(s.charAt(j) == 'y')
				e += 'a';
			if(s.charAt(j) == 'z')
				e+= 'b';
		}
			System.out.println("Encrypted string: " + e);
		}
	public static void reverse(String s){
		String reverse = "";
		
		for(int i=0; i<s.length(); i++){
			reverse += s.charAt(s.length() - (i+1));
		}
		System.out.println("Reversed String: " + reverse);
	}
	public static void lowerUpper(String s){
		String lower = "";
		String upper = "";
		
		for(int i = 0; i<s.length(); i++)
		{
			if(s.charAt(i) >= 'a' || s.charAt(i)<='z')
				upper += Character.toUpperCase(i);
			if(s.charAt(i) >= 'A' || s.charAt(i) <='Z')
				lower += Character.toLowerCase(i);
		
		}
		String finalString = lower + upper; 
		System.out.println("LowerUpper String: " + finalString);
	}
}
