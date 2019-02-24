import java.util.Scanner;
public class BestStudent {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of students:");
		int n = in.nextInt(); 
		double scores[] = new double[n]; 
		String names[] = new String[n];
		String highName = names[0];
		int i = 0;
		double max = scores[0];
		for(; i<n; i++){
			System.out.println("Student " + (i+1) + " of " + n);
			System.out.print("Enter student's name:");
			names[i] = in.next();
			System.out.print("Enter student's score:");
			scores[i] = in.nextDouble();
			
			if(scores[i] > max){
				max = scores[i];
				highName = names[i];
			}
		}
		System.out.println("The highest score was " + max + " and " + highName + " got it");
	}

}
