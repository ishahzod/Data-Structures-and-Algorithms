import java.io.*;
import java.util.*;

public class GraphsEC {
	public static int[] distance;
	public static int[] parents;    // parent of each distance
	public static int[][] adjMatrix;

	// initializes the static variables for the algorithm
	public static void getVars(int N) {
		adjMatrix = new int[N][N];
		distance = new int[N];
		for (int i = 0; i < N; i++) {
			distance[i] = Integer.MAX_VALUE; 
		}
		parents = new int[N];
	}

	// returns the neighboring nodes 
	public static LinkedList<Integer> getFriendNodes(int s) {
		LinkedList<Integer> elements = new LinkedList<Integer>();
		for (int k = 0; k < adjMatrix[0].length; k++) {
			if (adjMatrix[s][k] > 0)
				elements.add(k);
		}
		return elements;
	}
	// returns the min index of unvisited nodes
	public static int getUnseen(HashSet<Integer> visited) {
		int index = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] < min && !visited.contains(i)) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}


	// Djikstra's Algorithm
	public static void DjikstrasAlgorithm(int src) throws InterruptedException {
		HashSet<Integer> seen = new HashSet<Integer>();
		distance[src] = 0;
		for (int i = 1; i < distance.length; i++) {
			int next = getUnseen(seen);
			seen.add(next);
			LinkedList<Integer> friendNodes = getFriendNodes(next);
			ListIterator<Integer> numTraversed = friendNodes.listIterator(0);
			while (numTraversed.hasNext()) {
				int index = numTraversed.next();
				if (!seen.contains(index)) {
					int oldDist = distance[index];
					int newDist = distance[next] + adjMatrix[next][index];
					if (newDist < oldDist) {
						// swaps the distances in the new/old array and replaces the parent
						distance[index] = newDist;
						parents[index] = next;
					}
				}
			}
		}
		return;
	}

	public static void main(String args []) throws InterruptedException {
		final String FILENAME = "C:\\Users\\ishah\\workspace\\CSE214 ExtraCredit\\src\\in1.txt";
		File file = new File(FILENAME);
		System.out.println("Output: ");
		try {
			Scanner in = new Scanner(file);
			int T = Integer.parseInt(in.nextLine()); // number of test cases
			for (int i = 0; i < T; i++) {
				int V = Integer.parseInt(in.nextLine()); // number of vertices
				int S = in.nextInt();					 // source index
				int D = Integer.parseInt(in.nextLine().trim());

				getVars(V);
				for (int a = 0; a < V; a++) {
					String[] unparsed = in.nextLine().split(" ");
					// convert the strings to int variables
					for (int b = 0; b < unparsed.length; b++) {
						adjMatrix[a][b] = Integer.parseInt(unparsed[b]);
					}
				}

				//calls the algorithm
				DjikstrasAlgorithm(S);
				System.out.println(distance[D]); // prints the shortest distance to destination

				//gets the shortest path 
				LinkedList<Integer> Route = new LinkedList<Integer>();
				Route.add(D);
				int currentIndex = D;
				int ParentIndex = parents[currentIndex];
				while (ParentIndex != S) {
					Route.addFirst(ParentIndex);
					currentIndex = ParentIndex;
					ParentIndex = parents[currentIndex];
				}

				// prints the final path
				ListIterator<Integer> finalRoute = Route.listIterator();
				String str = S + " -> ";
				while (finalRoute.hasNext()) {
					str += finalRoute.next() + " -> ";
				}
				System.out.println(str.substring(0, str.length() - 4));
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + FILENAME);
		}
	}
}