
public class Car {
	private static double currentSpeed;  
	private boolean startCar;
	private GPS myGPS;
	
	//Constructors 
	public Car(){
		//default 
	}
	
	public void startCar(boolean startCar){
		this.startCar = startCar;
	}
	
	public void setCurrentSpeed(double currentSpeed){
		Car.currentSpeed = currentSpeed;
	}
	
	public void setGPS(GPS myGPS){
		this.myGPS = myGPS;
	}
	
	//Accessors
	
	public boolean getCarStart(){ 
		return startCar; 
	}
	
	public double getCurrentSpeed(){
		return currentSpeed;
	}
	
	public GPS getGPS(){
		return myGPS;
	}
	
	
}
