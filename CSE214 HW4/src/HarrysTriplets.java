//Shahzodjon Ismatov (110518374)
import java.util.*;

public class HarrysTriplets {
	static int myArray[];

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		//Prompt user input
		System.out.println("Enter N and M: ");

		int N = in.nextInt();
		int sum = in.nextInt();

		myArray = new int[N];

		System.out.println("Enter values of array: ");

		//Store elements into array
		for (int i = 0; i < N; i++) {
			myArray[i] = in.nextInt();
		}
		
		//Print the triplets 
		System.out.println(TripletCount(myArray.length, sum));
	}

	static int TripletCount(int N, int sum) {
		int tCount = 0;

		// Iterates and counts the triplets with myArray[i]
		for (int i = 0; i < N - 2; i++) {
			// Set pointers in the beginning and at the end of the array
			int a = i + 1;
			int b = N - 1;
			int c = 1; //counts

			while (a <= b) {
				// if a==b, increment value of a and repeat
				if (a == b) {
					c++;
					if (c >= (N - i - 1))
						break;
					b = N - 1;
					a = i + c;
				}
				if (((myArray[i] + myArray[a] + myArray[b]) % sum) == 0) {
					System.out.println(i +"," + a + "," + b);
					tCount += 1;
				}
				b--;
			}
		}
		return tCount;
	}
}