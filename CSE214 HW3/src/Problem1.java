//Shahzodjon Ismatov 110518374
import java.util.*;

public class Problem1 {

	public static void main(String args[]) {

		System.out.println("Input: ");
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine()); // first number in string
													// parsed into int # of
													// nodes
		String[] nodeValues = in.nextLine().split(" ");

		/* initializes a Btree IF the number of nodes 1 <= N <= 105 */
		if (N <= 105 && N >= 1) {
			P1_BTree binT = new P1_BTree(N);

			for (String n : nodeValues) {
				binT.add(Integer.parseInt(n));
			}
			String[] inorder = binT.inorder().split(" ");
			int[] inorderT = new int[N];
			for (int i = 0; i < N; i++) {
				inorderT[i] = Integer.parseInt(inorder[i]);
			}

			// Using selection sort for inorder traversal with complexity O(n^2)
			int key, swapNum = 0;
			for (int i = 1; i < inorderT.length - 1; i++) {
				key = inorderT[i];
				int j = i - 1;

				while (j >= 0  && inorderT[j] > key) {
					inorderT[j + 1] = inorderT[j];
					j = j - 1;
				}
				inorderT[j + 1] = key;
				swapNum++;
			}

			// Swap #
			System.out.println("Output: \n" + swapNum);

		} else {
			System.out.println("The number of nodes are not in range:  1 <= N <= 105. \nPlease try again.");
			main(null);
		}
	}
}