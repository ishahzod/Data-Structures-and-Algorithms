//Shahzodjon Ismatov 110518374

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem2 {

	public static void main(String args[]) {
		// final String FILENAME = "C:\\Users\\ishah\\workspace\\CSE214 HW3\\src\\in2.txt";

		System.out.println("Input: ");
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();                           // number of rows
		int N = Integer.parseInt(in.nextLine().trim()); // number of fans

		String[] seats = in.nextLine().split(" ");   //a string of available seats
		P2_PriorityQ pSeats = new P2_PriorityQ(M);   //prioritiezed seats
		
		for (String s : seats) {
			pSeats.enqueue(Integer.parseInt(s));
		}

		
		int sum = 0;
		while (N > 0) {  //if num of fans > 0, available seats become prioritized 
			int nSeats = pSeats.dequeue();
			sum += nSeats;
			pSeats.enqueue(nSeats - 1);
			N--;
		}

		// Final Output
		System.out.println("Output: \n" + sum);
	}

}