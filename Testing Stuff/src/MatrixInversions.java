
public class MatrixInversions {

	public static void main(String[] args) {
		int[][] m = { {1,2,3},
				{4,5,6},
				{7,8,9}};
		System.out.println("The original matrix: ");
		printMatrix(m);

		int[][] m2 = majorDiagonalInversion(m);
		System.out.println("Major diagonal inversion: ");
		printMatrix(m2);

		int[][] m3 = minorDiagonalInversion(m);
		System.out.println("Minor diagonal inversion: ");
		printMatrix(m3);
	}

	public static int[][] majorDiagonalInversion(int[][] m){
		int[][] m2 = new int[m[0].length][m.length];
		int temp;
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m[i].length; j++){
				m2[j][i] = m[i][j];
			}
		return m2;
	}
	public static int[][] minorDiagonalInversion(int[][] m){
		int[][] m2 = new int[m[0].length][m.length];
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m[i].length; j++){
				m2[m.length-j-1][m.length-i-1] = m[i][j];
			}
		return m2;
	}
	public static void printMatrix(int[][] m){
		for(int[] row:m){
			for(int e:row)
				System.out.print(e + " ");
			System.out.println("\n");
		}
	}
}