import java.util.*;
public class LetterCount {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string of letter, numbers, spaces, and symbols:");
		String s = in.nextLine();
		
		System.out.println("The number of letters in the string is: " + countLetters(s));

	}
	
	public static int countLetters(String s){
		int c = 0;
		for(int i = 0; i<s.length();i++){
			if(Character.isAlphabetic(s.charAt(i)))
				c++;
			else continue;
		}
		return c;
	}

}
