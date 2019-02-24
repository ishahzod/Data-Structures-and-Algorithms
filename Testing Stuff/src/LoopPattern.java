import java.util.*;

public class LoopPattern {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an integer to be a limit of the pattern:");
		int n = in.nextInt();
		
		System.out.println("\nPattern A:");
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=i; j++){
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("\nPattern B:");
		for(int i = n; i>0; i--){
			for(int j = 1; j <=i; j++){
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("\nPattern C:");
		for (int i = 1; i <= n; i++) {
			for(int k = 0; k<n-i; k++) {
				System.out.print("  ");
			}
			for (int j = i; j > 0; j--) {

				System.out.print(j+" ");
			}

			System.out.println();
		}
		
		//Loop through the lines from 1 to n (i=0 to n-1)
		System.out.println("\nPattern D:");
		for (int i = 0; i < n; i++) {

			// printing spaces, 2 at a time from j=i to 0
			for (int j = i; j>0; j--) {
				System.out.print("  ");
			}

			//Printing number incrementally from 1 to line number j
			for (int j = 1; j <= n-i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();

		}

	}

}