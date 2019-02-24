//Problem1

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CleanUpFriendList {

	private static class Friend implements Comparable<Friend> {
		private String name;
		private int numMF; 

		public Friend(String name, int numMF) {
			this.numMF = numMF;
			this.name = name;
		}

		//compares the mutual friends of the given to the other
		@Override
		public int compareTo(Friend other) {
			return numMF - other.numMF;
		}

		public String toString() {
			return name;
		}
	}

	// using insertion sort by the number of mutual friends
	public static void inSortByMF(Friend[] f) {
		for (int i = 1; i < f.length; i++)
			for (int j = i; j > 0; j--)
				if (f[j].compareTo(f[j - 1]) < 0) {
					Friend temp = f[j - 1];
					f[j - 1] = f[j];
					f[j] = temp;
				}
	}

	// using insertion sort by name
	public static void inSortByName(Friend[] f) {
		for (int i = 1; i < f.length; i++)
			for (int j = i; j > 0; j--)
				if (f[j].name.compareTo(f[j - 1].name) < 0) {
					Friend temp = f[j - 1];
					f[j - 1] = f[j];
					f[j] = temp;
				}
	}

	public static void printFriends(Friend[] f) {
		String rSt = "";
		for (int i = 0; i < f.length; i++)
			rSt += f[i] + " ";
		System.out.println(rSt.substring(0, rSt.length() - 1));
	}

	public static void main(String[] args) {
		//Grader: Please specify the path to the txt file
		final String fileName = "C:\\Users\\ishah\\workspace\\CSE214 Hw2\\src\\in1.txt";
		final int caseNum;
		File txtfile = new File(fileName);

		try {
			Scanner in = new Scanner(txtfile);
			caseNum = Integer.parseInt(in.nextLine());
			for (int i = 0; i < caseNum; i++) {
				int N = in.nextInt(); // num of newly added friends
				int K = Integer.parseInt(in.nextLine().trim()); // num of
																// friends to
																// keep
				String[] Fnames = in.nextLine().split(" ");
				String[] numMFs = in.nextLine().split(" ");
				if (Fnames.length != numMFs.length)
					throw new IllegalArgumentException("number of names does not match the number of mutual friends.");

				// finding min and max
				Friend[] friendList = new Friend[Fnames.length]; // for ease of
																// handling
				int minMF = Integer.parseInt(numMFs[0]); // default
																		// first
																		// friend
				int maxMF = minMF; // default first friend
				for (int j = 0; j < Fnames.length; j++) {
					Friend f = new Friend(Fnames[j], Integer.parseInt(numMFs[j]));
					if (f.numMF < minMF) {
						minMF = f.numMF;
					} else if (f.numMF > maxMF) {
						maxMF = f.numMF;
					}
					friendList[j] = f;
				}

				MyLinkedList<Friend> ANSWER = new MyLinkedList<Friend>();

				// calculate friendlist
				inSortByMF(friendList); // must insert in order
				int BuckCalc = (int) Math.round((maxMF - minMF + 1) / (double) K); // default
																			// buckets
																			// cap
				for (int mf = minMF; mf < maxMF; mf += BuckCalc) {
					int buckets_min = mf;
					int buckets_max = mf + BuckCalc - 1;
					if (mf == minMF + (K - 1) * BuckCalc) // if last buckets
						buckets_max = maxMF; // this accounts for both
											// expanding/shrinking last buckets

					LinkedQueue<Friend> buckets = new LinkedQueue<Friend>();
					for (Friend f : friendList) {
						if (f.numMF >= buckets_min && f.numMF <= buckets_max)
							buckets.enqueue(f);
					}

					// runs the simulation
					if (buckets.isEmpty())
						break;
					int cycleAmt = K % (buckets.cap() + 1);  
					
					while (buckets.cap() > 1) {
						for (int z = 1; z < cycleAmt; z++) {
							buckets.enqueue(buckets.dequeue());
						}
						buckets.dequeue(); //removes a mutual friend
					}
					ANSWER.addLast(buckets.dequeue()); // friend to keep
				}

				// sort and print
				Friend[] sortPrint = new Friend[ANSWER.cap()];
				for (int x = 0; x < sortPrint.length; x++) {
					sortPrint[x] = ANSWER.removeFirst();
				}
				inSortByName(sortPrint);
				printFriends(sortPrint);

			}
		}

		catch (FileNotFoundException e) {
			System.out.println("Unable to find: " + fileName);
		}
	}
}
