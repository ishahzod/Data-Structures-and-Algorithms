import java.util.Scanner;
public class LargestNCubed {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an integer:");
		int n = in.nextInt();
		
		
		System.out.println("The largest n such that n^3 is less then " + n + " is " + cubed(n));
		
	}
	public static int cubed(int n){
		int i = 0;
		int cubed = 0;
		
		while(cubed<n){
			i++;
			cubed = i*i*i;
			if(cubed>n) break;
		}
		return i-1; 
	}
}
