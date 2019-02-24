import java.util.Scanner;
public class HasSubstring {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter string s1:");
		String s1 = in.nextLine();
		System.out.print("Enter string s2:");
		String s2 = in.nextLine();
		
		
		if(s1.contains(s2))
		System.out.println(s2 +" is a substring of " + s1);
		else
		System.out.println(s2 +" is not a substring of " + s1);
		
	}
}