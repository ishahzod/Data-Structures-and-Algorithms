//Bonus Question for Extra Credit

import java.io.*;
import java.util.Scanner;

public class Tree234Driver {
	public static void main(String args[]) throws IOException{

		Scanner in = new Scanner(System.in);
		Tree234 Tree = new Tree234();
		while (true){
			int choice = in.nextInt();
			int k = 0;
			switch (choice){
			case 1:
				k = in.nextInt();
				Tree.insert(k);
				break;

			case 2:
				break;

			case 3:
				k = in.nextInt();
				int found = Tree.find(k);
				if (found != -1)
					System.out.println("successfull");
				else
					System.out.println("failed");
				break;
			case 4:
				Tree.displayTree(4);
				break;
			case 5:
				Tree.displayTree(5);
				break;
			case 6:
				Tree.displayTree(6);
				break;
			default:
				System.out.println("Entry is invalid\n");
			} 
		}
	}


	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();

		return s;
	}
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}