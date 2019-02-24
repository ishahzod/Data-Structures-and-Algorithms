import java.util.*;
public class SortCities {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the first city:");
		String c1 = in.nextLine();
		System.out.print("Enter the second city:");
		String c2 = in.nextLine();
		System.out.print("Enter the third city:");
		String c3 = in.nextLine();
		
		sort(c1, c2, c3);
	}
	public static void sort(String c1, String c2, String c3){
		String temp = "";	
		
		if(c1.compareTo(c2) > 0){
			temp = c1;
			c1 = c2;
			c2 = temp;
		}
		if(c2.compareTo(c3) > 0){
			temp = c2;
			c2 = c3;
			c3 = temp;
		}
		if(c1.compareTo(c2) > 0){
			temp = c1;
			c1 = c2;
			c2 =temp;
		}
		System.out.println("The three cities in alphabetical order are " + c1 + " " +  c2 + " " + c3);
	}

}
