
public class Location extends Car{
	private int x;		//current coordinates
	private int y;
	
	// Setters and getters
	
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	//Addon from Tripathi's Class
	public Object clone(){
		Location answer; try{
			answer = (Location)super.clone();
		} catch (CloneNotSupportedException e){
			throw new RuntimeException("Clone not supported !!!");
		}
		return answer;
	}
	
}
