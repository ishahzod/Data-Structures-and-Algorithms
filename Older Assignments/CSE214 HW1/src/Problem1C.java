
//Problem 1c
//This problem did not ask to be implemented. 

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				double sum = 0;
				for (int k = 0; k < n; k++) {
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			}
		}

/* O(n^3) is the complexity since we're using 3 nested for loops
  Space Complexity is O(1) because the sum is a single data value
*/