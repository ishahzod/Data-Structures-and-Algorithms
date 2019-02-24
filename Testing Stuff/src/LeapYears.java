import java.util.*;

public class LeapYears {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the starting year:");
		int Syear = in.nextInt();
		System.out.print("Enter the ending year:");
		int Eyear = in.nextInt();
		
		int count = 0; 
		
		for(int i = Syear; i<=Eyear; i++){
			if(i%4 == 0){
				System.out.print(i + " ");
				count++;
				if(count%10 == 0)
					System.out.println();
			}
		}
		System.out.println("\nThere were " + count + " leap years from " + Syear + " to " + Eyear);
	}
}
