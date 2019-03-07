
//Shahzodjon Ismatov (110518374)

/*NOTE TO GRADER: The Professor's instructions were vague. I planned to do this 
 * with the user inputting the array size and elements, however,
 * the problem did not specify such instructions. 
 */


public class Problem1A {

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		int arr[] = new int[] { 11, 15, 6, 8, 9, 10 };			//1
		//boolean output;											//1	
		int x = 16;												//1

		// displays the input array
		System.out.print("Input: arr[] = { ");					//1  
		for (int i = 0; i < arr.length; i++) {					//n-1
			System.out.print(arr[i] + " ");						//1
		}
		System.out.print("}, " + "x=" + x + "\n");				//1

		// loops through the array and checks if two elements add to the value x
		for (int i = 0; i < arr.length; i++) {					//n-1
			for (int j = 0; j < i; j++) {						//n-1
			if ((arr[i] + arr[j]) == x) {						//1
					//output = true;
					System.out.println("Output: " + arr[i] + " + " + arr[j] + " = " +
					(arr[i] + arr[j]) + " , " + " True");		//1
					System.exit(0);
			}
			}
		}
			System.out.println("Output: False");
	}
}

//Disregarding the for loop that displays the input
/*T(n) = 1+1+1+1+1*(n-1)*(n-1+1+1) = O(n^2)  would be the worst case scenario since 
* there are 2 nested for loops*/

