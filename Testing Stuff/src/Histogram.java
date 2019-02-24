/* Write a static method buildHistogram that that accepts an array of integers in the range 0 through
100 (inclusive) as its sole parameter and that returns an array of 10 integers that provides a histogram of
the values in the input parameter array. Specifically, each element of the returned array is a count of how
many values of the input array fall into the ranges 0-9, 10-19, 20-21, …, 90-100, respectively. For
example, suppose the parameter integer array contained the values { 5, 88, 6, 17, 39, 31, 100, 99, 19, 4,
98, 22, 77, 10 }. Then, the returned array would contain the 10 values { 3, 3, 1, 2, 0, 0, 0, 1, 1, 3 }.*/


import java.util.*;

public class Histogram {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an array size: ");
		int n = in.nextInt();
		
		int [] array = new int[n];
		
		int a[] = generateRandom(array);
		
		rotateRight(a, 3);
		
		System.out.print("Generated Array: a[" + n + "] = {");
		for(int i = 0; i<array.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.print("}\n");
		
		int hist[] = histogram(array);
		
		System.out.print("Histogram Array: a[" + hist.length + "] = {");
		for(int i = 0; i<array.length; i++){
			System.out.print(hist[i] + " ");
		}
		System.out.print("}\n");
		
	//	System.out.print("Generated Array: a[" + n + "]: {" + generateRandom(array) + " " + "}\n");
	//	System.out.print("Histogram Array: a[" + n + "]: {" + histogram(array) + " " + "}");
		

	}
	
	public static int[] generateRandom(int [] array){
		for(int i = 0; i<array.length; i++){
			array[i] = (int) (Math.random()*101); 
		}
		return array; 
	}
	//using %10 we extract the indexes in range 0-9, 10-19, etc
	public static int[] histogram(int [] array){
		int [] hist = new int[10];
		for(int i = 0; i<array.length;i++){
			int index = array[i] %10;
			hist[index]++;
		}
		//hist[array[i]%10]++;
		return hist;
	}
	
	public static void rotateRight(int a[], int n){
		for(int i=0; i<n; i++){
			for(int j = a.length-1; j>0; j--){
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1]= temp;
				
			}
		}
		//for(int i = 0; i<a.length; i++)
	//	for(int i = 0; t.println(a[i]);
	}

}
