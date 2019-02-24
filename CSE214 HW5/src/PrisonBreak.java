import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class PrisonerBreak {
	// Using DFS to count
	public static int Count(int x, int y, int[][] arr, boolean[][] a) {
		if (x < 1 || y < 1 || x > a.length - 1 || y > a.length - 1)
			return 0;
		if (x == a.length - 1 && y == a.length - 1)
			return 1;
		if (a[x][y] == true || (arr[x][y] == 1 && (x != 1 || y != 1)))
			return 0;
		
		a[x][y] = true;
		int n1 = Count(x - 1, y, arr, a);
		int n2 = Count(x + 1, y, arr, a);
		int n3 = Count(x, y - 1, arr, a);
		int n4 = Count(x, y + 1, arr, a);
		a[x][y] = false;
		// Sysout("returning value");
		return n1 + n2 + n3 + n4;
	}

	static class Read {
		final private int ConstraintN = 1 << 20;
		private int xPtr, Reader;
		private DataInputStream IN;
		private byte[] buff;

		//reads in the values for the NxN matrix with each value followed by a space char, until line ends
		public int nextInt() throws IOException {
			int res = 0;
			int n = read();
			while (n <= ' ')
				n = read();
			boolean Negative = (n == '-');
			if (Negative)
				n = read();
			do {
				res = res * 10 + n - '0';
			} while ((n = read()) >= '0' && n <= '9');

			if (Negative)
				return -res;
			return res;  //returns result
		}

		private void fillBuffer() throws IOException {
			Reader = IN.read(buff, xPtr = 0, ConstraintN);
			if (Reader == -1)
				buff[0] = -1;
		}
		
		//reads the value of the ptr and fills buffer if it's equal
		
		private byte read() throws IOException {
			if (xPtr == Reader)
				fillBuffer();
			return buff[xPtr++];
		}
	}

	// Driver
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input: ");
		int inputs = in.nextInt();

		for (int x = 0; x < inputs; x++) {
			int N = in.nextInt();
			int[][] myArray = new int[N + 1][N + 1];
			boolean[][] arr = new boolean[N + 1][N + 1];
			for (int y = 1; y <= N; y++)
				for (int z = 1; z <= N; z++) {
					myArray[y][z] = in.nextInt();
				}
			if (myArray[1][1] == 1 && myArray[N][N] == 1)
				System.out.println(0);
			else {
				int count = Count(1, 1, myArray, arr);
				System.out.println("Output: " + count);
			}
		}
	}
}