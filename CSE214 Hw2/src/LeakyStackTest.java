//Problem3
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeakyStackTest {

	private static final String fileName = "in3.txt";

	public static void main(String args[]) {

		// scanner that reads from the file initialized to null
		Scanner in = null;

		try {
			//Grader: Please specify the correct path for the in3 txt file
			in = new Scanner(new File("C:\\Users\\ishah\\workspace\\CSE214 Hw2\\src\\in3.txt"));

			while (in.hasNextLine()) {

				//Parses the first line into integer to determine the test case number
				int n = Integer.parseInt(in.nextLine().trim());

				// Read n test cases from the file
				for (int i = 0; i < n; i++) {

					// cap of the leaky stack
					int capacity = Integer.parseInt(in.nextLine().trim());

					// Creates LeakyStack object
					LeakyStack stack = new LeakyStack<>(capacity);

					// Read data for the leaky stack
					String[] data = in.nextLine().split(" ");

					// Adds data to the stack
					for (String e : data) {
						stack.push(e);
					} 
					// Prints out the stack 
					System.out.println(stack);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + "cannot be found.");
		} 
		finally {

			if (in != null)

				in.close();

		}

	}

}