import java.util.*;
public class NavigationTest {
	public static void main(String []args){
		
		//Location myCurrentLocation = new Location(354, 538);
		Location myDestination = new Location(108, 25);
		
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter current location");
		Location myCurrentLocation = new Location(sc.nextInt(), sc.nextInt());
		
		Car myCar = new Car();
		
		/* Initializing GPS object and setting current and destination locations */
		
		GPS myGPS = new GPS();
		
		myGPS.setCurrentLocation(myCurrentLocation);
		myGPS.setDestination(myDestination);
		myCar.setGPS(myGPS);
		
		myCar.setCurrentSpeed(35.0);
		
		System.out.println("Distance: " + ((GPS)myCar.getGPS()).getCalculatedDistance() + " miles");
		System.out.println("Arrival: Approximately " + ((GPS)myCar.getGPS()).getArrivalTime() + " hours");
		
	}

}
