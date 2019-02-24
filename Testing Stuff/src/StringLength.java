import java.util.Scanner;
public class StringLength {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a string:");
		String s = in.nextLine();
		System.out.println("Enter a number: ");
		double d = in.nextLong();
		
		System.out.println("The string is of length " + s.length() + " and the first character is " + s.charAt(0));
		System.out.println(d);
		
		
		int sum = 0;
		int item = 0;
		
		do{ item++;
			sum += item;
			if(sum >=4) continue;
		}while(item <7);
		
		System.out.println(sum);
	}

}
