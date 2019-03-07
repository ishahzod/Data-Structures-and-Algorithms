//Shahzodjon Ismatov (110518374)
import java.util.*;

public class TargetSumPair{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		// Prompts user input
		System.out.println("Input: ");
		int N = in.nextInt();
		int targ = in.nextInt();
		
		//Creates an Array of size N 
		int[] myArray = new int[N];
		
		// scan and sort the array
		for (int a = 0; a < N; a++) {
			myArray[a] = in.nextInt();
		}
		Arrays.sort(myArray);
		
		//Prints the pair that sum to Target 
		
		int[] pair = getPairs(myArray, targ);
		System.out.println("\nPair : [ " + pair[0] + " , " + pair[1] + " ]");
		
	}

	public static int[] getPairs(int[] myArray, int targ){

		int pair[] = new int[2];
	
		//Default values if no pair sum to Target
		pair[0] = -1;
		pair[1] = -1;

		//Set a as the first element
		int a = 0;

		//Set b as the last element 
		int b = myArray.length - 1;

		// loop until a is less than b
		while (a < b){
			if (myArray[a] + myArray[b] == targ){
				pair[0] = a;
				pair[1] = b;
				return pair;
			}
			else if (myArray[a] + myArray[b] > targ)
				b--;
			else
				a++;
		}
		// if pair not found
		return pair;
	}
}