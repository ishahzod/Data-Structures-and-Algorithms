import java.util.*;
public class SortedNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the three numbers: ");
		double num1 = in.nextDouble();
		double num2 = in.nextDouble();
		double num3 = in.nextDouble();
		
		displaySortedNumbers(num1, num2, num3);
	}
	public static void displaySortedNumbers(double num1, double num2, double num3){
		if(num1>num2){
			double temp = num1;
			num1 = num2;         //assigns the value of num1 to num2
			num2 = temp;         //num2 is now the smallest number 
		}
		if(num2>num3){           //comparing num2 to num3 
			double temp = num2;
			num2 = num3;         //if num2>num3, then assigns value of num2 to num3    
			num3 = temp;         //num3 is now the smallest number
		}
		if(num1>num2){
			double temp = num1;
			num1 = num2;
			num2 = temp;						
		}
		System.out.println(num1 + " " + num2 + " " + num3);
	}
}
