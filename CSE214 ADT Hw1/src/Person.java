/**
 * 
 * @author Shahzod Ismatov
 * SBU ID: 110518374
 * CSE214-R11
 *
 */

/*
Contains biological stats of each person in the .csv file
name, age, gender, height, and weight and 
toString() method to print all in tabular form
*/

public class Person {
	//declaring variables
	private String name, gender;
	private int age;
	private double height, weight;
	
	public Person(){
		//default constructor
	}
	
	//constructor for the csv file
	public Person(String name, String gender, int age, double height, double weight){
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	/*Setters / Mutators*/
	public void setName(String name){
		this.name = name;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setHeight(double height){
		this.height = height;
	}
	
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	/* Getters / Accessors */
	public String getName(){
		return name;
	}
	
	public String getGender(){
		return gender;
	}
	
	public int getAge(){
		return age;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getWeight(){
		return weight;
	}
	
	//returns string of data members in tabular form
	public String toString(){
/*		String d2s = Double.toString(this.getHeight());                        //cast the height double to a string
		String feet = d2s.substring(0, d2s.indexOf("."));                      //before the decimal point
		String inches = d2s.substring(d2s.lastIndexOf(".") + 1, d2s.length()); //after the decimal point
*/		String data = String.format("%10s %5s %d %2s %s %2s %.0f feet %.0f inches %s %.0f pounds", 
				this.getName(), "|", this.getAge(), "|", this.getGender(), "|", Math.floor(this.getHeight()/12), (this.getHeight())%12, "|", this.getWeight());
		return data;
		
	}
	

}
