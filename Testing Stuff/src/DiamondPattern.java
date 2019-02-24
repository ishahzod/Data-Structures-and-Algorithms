public class DiamondPattern {
	public static void main(String[] args) {
		hourglass(10);
	}
	public static void hourglass(int n){
		for(int i=1; i<=2*n; i++)
			System.out.print("-");
		System.out.println();
		// upper part
		for(int i=1; i<=n; i++){
			// print i-1 spaces
			for(int j=1; j<i; j++)
				System.out.print(" ");
			System.out.print("\\");
			// print 2*(n-i) spaces 
			for(int j=1; j<=2*(n-i); j++)
				System.out.print(" ");
			System.out.println("/");
		}
		// lower part
		for(int i=1; i<=n; i++){
			// n-i spaces
			for(int j=1; j<=n-i; j++)
				System.out.print(" ");
			System.out.print("/");
			// print 2*(i-1) spaces
			for(int j=1; j<=2*(i-1); j++)
				System.out.print(" ");
			System.out.println("\\");
		}
		for(int i=1; i<=2*n; i++)
			System.out.print("-");
		System.out.println();
	}
	public static void triangle(int n){
		// upper part
		for(int i=1; i<=n; i++){
			// n-i spaces
			for(int j=1; j<=n-i; j++)
				System.out.print(" ");
			System.out.print("/");
			// print 2*(i-1) spaces
			for(int j=1; j<=2*(i-1); j++)
				System.out.print(" ");
			System.out.println("\\");
		}
		for(int i=1; i<=2*n; i++)
			System.out.print("-");
	}
	public static void diamond(int n){
		// upper part
		for(int i=1; i<=n; i++){
			// n-i spaces
			for(int j=1; j<=n-i; j++)
				System.out.print(" ");
			System.out.print("/");
			// print 2*(i-1) spaces
			for(int j=1; j<=2*(i-1); j++)
				System.out.print(" ");
			System.out.println("\\");
		}
		// lower part
		for(int i=1; i<=n; i++){
			// print i-1 spaces
			for(int j=1; j<i; j++)
				System.out.print(" ");
			System.out.print("\\");
			// print 2*(n-i) spaces 
			for(int j=1; j<=2*(n-i); j++)
				System.out.print(" ");
			System.out.println("/");
		}
	}
	
	public static void Squares(int n){
		for(int j = 0; j < n; j++)
			System.out.print("*");
		System.out.println();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				if(j == 0 || j == n-1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			System.out.println();
		}
		for(int j = 0; j < n; j++)
			System.out.print("*");
	}
	
	public static void Triangles(int n){
		int odd = 1;
		int size = 5; // change this to how many rows
		int noOfSpaces = size - 1; // do not change
		for (int i = 1; i <= size; i++) {
			int k = 0;
			for (int j = 1; j <= noOfSpaces; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <=odd; j++) { //because you need 1 column, then 3. then 5, then 7 etc
				if (j <= i) {
					k++;
				}

			}
		}
	}
}
