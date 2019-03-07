
public class Problem1B {

	public static void main(String[] args) {
		int arr[] = new int[] { 11, 15, 6, 8, 9, 10 };   			  //1
 		//boolean output;									 			 //1
 		int x = 37;													//1

		// displays the input array
		System.out.print("Input: arr[] = { "); 						//1   }
		for (int i = 0; i < arr.length; i++) { 						//n-1  }  This part was not considered when determining the Big-O Complexity
			System.out.print(arr[i] + " ");  						//1   }
		}
		System.out.print("}, " + "x=" + x + "\n"); //1

		// loops through the array and checks if three elements add up to the value x
		for (int i = 0; i < arr.length; i++) { 						//n-1
			for (int j = 0; j < i; j++) {	  						//n-1
				for (int k = 0; k < j; k++) { 						//n-1
					if ((arr[i] + arr[j]+arr[k]) == x) { 			//1
						//output = true;
						System.out.println("Output: " + arr[i] + " + " + arr[j] + " + " + arr[k] + " = "      //1
						+(arr[i] + arr[j] + arr[k]) + " , " + " True");     
						System.exit(0);
					}
				}
			}
		}
		System.out.println("Output: False");
	}
}

//Disregarding the for loop that displays the input
/*T(n) = 1+1+1+1*(n-1+1)+1*(n-1)*(n-1)*(n-1+1+1) = O(n^3)  would be the worst case scenario since 
 * there are 3 nested for loops*/
