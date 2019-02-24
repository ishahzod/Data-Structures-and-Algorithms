import java.util.*;
public class AreaHexagon {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the side:");
		double s = in.nextDouble();
		
		double area = (6*s*s)/(4*Math.tan(Math.PI/6));
		
		System.out.printf("The area of the hexagon is %.2f ", area);
		
		//System.out.println(Integer.parseInt("B6"));

	}

}
