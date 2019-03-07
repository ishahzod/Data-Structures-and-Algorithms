
public class GPS extends Car {
	private double distance;
	private Location myCurrentLocation;
	private Location myDestination;
	
	public GPS(){
		//default
	}
		
	
	public void setCurrentLocation(Location myCurrentLocation){
		this.myCurrentLocation=(myCurrentLocation);
	}
	
	public void setDestination(Location myDestination){
		this.myDestination = (myDestination);
	}
	
	//Uses the distance formula to calculate distance between location and destination
	
	public double getCalculatedDistance(){
		
		double a = myCurrentLocation.getX() - myDestination.getX();    
		double b = myCurrentLocation.getY() - myDestination.getY();
		distance = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return distance;
	}
	
	//Cast it to an integer type variable as to approximate the travel time
	
	public int getArrivalTime(){
		int time = (int) (distance/getCurrentSpeed());
		return time;
	}
		
}
