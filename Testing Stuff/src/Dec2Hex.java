import java.util.*;
public class Dec2Hex {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a decimal value (0 to 15): ");
		int n = in.nextInt();
		int hex=0; 

		if(n >= 0 && n<=9){
			hex = n; 
			System.out.println(" The hex value is " + hex);
		}
		else if(n>9 && n<=15){
			hex = 'A' - 10 + n;
		System.out.println(" The hex value is " + (char)hex);		

		}
		else{
			System.out.println("Invalid input. Please try again.");
			main(null);
		}
	}
}
