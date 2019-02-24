import java.util.*;
public class PentagonalNumbers {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an integer for the n pentagonal numbers you want displayed:");
		int n = in.nextInt();

		for (int i = 1; i <=n; i++){
			System.out.printf("%d ", getPentagonalNumber(i));
			if (i % 10 == 0)
				System.out.println();
		}

	}
	public static int getPentagonalNumber(int n){
		return (n * (3 * n - 1)) / 2;
	}
}