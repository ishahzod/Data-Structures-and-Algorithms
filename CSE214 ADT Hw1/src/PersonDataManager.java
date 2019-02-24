/**
 * 
 * @author Shahzod Ismatov
 * SBU ID: 110518374
 * CSE214-R11
 *
 */
import java.io.*;
import java.util.*;

public class PersonDataManager {

	private Person[] people;
	private int num;


	public PersonDataManager(){
		//default constructor
		num = 0;
		people = new Person[0];
	}

	/**
	 * A constructor that determines the initial size of the people array.
	 * @param initialSize
	 * The number that sets the size of the array
	 */
	public PersonDataManager(int initialSize){
		if(initialSize < 0)
			throw new IllegalArgumentException();
		//initialize the size of the people array
		num = 0;
		people = new Person[initialSize];
	}
	
	/**
	 * A static method that reads from the .csv file using Scanner and the File class
	 * parses the string data read by utilizing split by whitespace, and double quotes
	 * stores the data into name, age, sex, height, weight necessary to create a newPerson
	 * calls addPerson method to store the above data into an array while looping through the file
	 * until reaching the end
	 * @param location
	 * The location or directory where the file is located
	 * [Precondition] - None
	 * [Postcondition] - None
	 * @return
	 * PersonDataManager abstract data type constructed from the .csv file
	 * @throws IllegalArgumentException, FileNotFoundException, PersonAlreadyExistsException
	 * Indicating that the file name is invalid , and cannot be found
	 */

	public static PersonDataManager buildFromFile(String location) throws IllegalArgumentException{
		PersonDataManager personDataManager = new PersonDataManager();
		File csv = new File(location);

		String input,name,sex;
		int age;
		double height, weight;

		try {
			Scanner read = new Scanner(csv); //read from the csv file
			//	read.useDelimiter("//s+"); //omits all empty/white spaces between the strings
			System.out.println("Person data loaded successfully!");
			read.nextLine();   //skips header line

			while(read.hasNext()){
				input = read.nextLine();
				String [] data = input.split("\\s*,\\s*");//split by whitespace followed by comma followed by whitespace
				name = data[0];
				sex = data[1];
				age = Integer.parseInt(data[2]);
				height = Double.parseDouble(data[3]);
				weight = Double.parseDouble(data[4]);

				//construct the array with all the people	
				personDataManager.addPerson(new Person(name, sex, age, height,weight));
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (PersonAlreadyExistsException e) {
			e.printStackTrace();
		} 
		return personDataManager;
	}

	
	/**
	 * A method that stores the data of a person (name, age, sex, gender, height, weight) 
	 * in to a single dimensional array of people [], calls checkPeople() to see if i-th person already exists
	 * ensures that the array is large enough to keep on adding people, and sorts the array alphabetically by calling
	 * @param newPerson
	 * The person that is going to be added to the people[] array
	 * [Precondition]  - The person does not already exist in the array
	 * [Postcondition] - The person is added to the list
	 * @return
	 * None.
	 * @throws PersonAlreadyExistsException
	 * Thrown if a person with all the same biological statistics already exists in the array
	 */
	public void addPerson(Person newPerson) throws PersonAlreadyExistsException{
	
		if(checkPeople(newPerson, people) == true){
			throw new PersonAlreadyExistsException("Person is already on the list. No need for a duplicate.");
		}else{
		ensureCapacity(num+1);  //increase the capacity by 1 
		people[num++] = newPerson;
		}
		sort(people);
	}
	
	
	/**
	 * A boolean method that iterates through the people array, and checks if the target
	 * NAME exists in the array.
	 * @param name, people[]
	 * name - the target parameter searched for
	 * people [] - array being iterated through
	 * [Precondition]  - None
	 * [Postcondition] - None
	 * @return
	 * True - if name matches a name at people[i].getName() 
	 * False - otherwise
	 * @throws None
	 */
	//Returns true if a person with the same name already exists on the list
	private boolean checkName(String name, Person[] people2) {
		for(int i=0; i<people.length;i++){
		if(people[i].getName().equals(name))
			return true;
		}
		return false;
	}
	
	/**
	 * A boolean method that iterates through the people array, and checks if <b> ALL biological stats </b>
	 * of the person match an existing entry in the array
	 * @param newPerson, people[]
	 * newPerson - the target person whose biological stats are being compared
	 * people [] - array being iterated through
	 * [Precondition]  - None
	 * [Postcondition] - None
	 * @return
	 * True - if ALL fields match an entry at people[i] array
	 * False - otherwise
	 * @throws None
	 */
	private boolean checkPeople(Person newPerson, Person[] people2) {
		for(int i=0; i<people.length;i++){
		if(people[i].getName().equals(newPerson.getName()) && (people[i].getGender().equals(newPerson.getGender())) 
				&& (people[i].getAge() == newPerson.getAge()) && (people[i].getHeight() == newPerson.getHeight()) && (people[i].getWeight() == newPerson.getWeight()))
			return true;
		}
		return false;
	}
	
	/**
	 * A  method that iterates through the people[] array
	 * and implements Bubble sort based on alphabetical names in ascending order.
	 * Sets the people[] array as the sorted array at the end
	 * @param people[]
	 * people [] - array being iterated through
	 * [Precondition]  - None
	 * [Postcondition] - people array becomes sorted
	 * @return None
	 * @throws None
	 */
	//Implements Bubble sort = with Big-O of O(n^2)
	public void sort(Person [] people){
		for(int i = 0; i < people.length; i++){
			for(int j = i+1; j < people.length; j++){
				if(people[i].getName().compareTo(people[j].getName()) > 0){
					//Swaps the elements
					Person temp = people[i];
					people[i] = people[j];
					people[j] = temp;
				}
			}
		}
		this.people = people; //people array now becomes the sorted array
	}
	

	/**
	 * A method that checks if the size of the people array is less than num
	 *  and creates a bigger array with that size. Copies the elements from the 
	 *  people array to the bigger array, and sets the people array as the big array.
	 * @param num
	 * num - the size of the bigger array
	 * [Precondition]  - checks if people array is saturated 
	 * [Postcondition] - people array now becomes the bigger array
	 * @return none
	 * @throws None
	 */
	public void ensureCapacity(int num){
		Person newPeople[]; //bigger array
		if(people.length < num){
			newPeople = new Person[num]; //create a new array an increased size by 1
			for(int i=0;i<people.length; i++){  //transfer all the elements to new array
				newPeople[i] = people[i];
			}
			this.people = newPeople;  //the bigger array now becomes the people array
		}
	}
	
	/**
	 * Retrieves and prints the data of the person object from 
	 * the data structure chosen.
	 * @param 
	 * name - Name of the Person object to be printed
	 * [Precondition]  - The person with the given name exists
	 * [Postcondition] - None
	 * @return None
	 * @throws PersonDoesNotExistsException: Thrown if a person with
	 * the given name does not exist.
	 */
	public void getPerson(String name) throws PersonDoesNotExistsException{
		for(int i = 0; i<people.length; i++){
			if(people[i].getName().equals(name))
				System.out.format("%s is a %d year old %s who is %.0f feet and %.0f inches tall and weighs %.0f pounds. \n",
						people[i].getName().replaceAll("\"", ""), people[i].getAge(), identify(people[i].getGender()), people[i].getHeight()/12, people[i].getHeight()%12, people[i].getWeight());
			else if(checkName(name, people)== false) //reach the end of the array, with no match
					throw new PersonDoesNotExistsException(name.replaceAll("\"", "") + " does not exist in the list!");
		}
	}
	
	/**
	 * Removes the Person from the data structure chose. Once the person 
	 * is removed, move all the people after that location in the array to
	 * one space left.
	 * @param 
	 * name - Name of the Person object to be printed
	 * [Precondition]  - The person with the given name exists
	 * [Postcondition] - None
	 * @return None
	 * @throws PersonDoesNotExistsException: Thrown if a person with
	 * the given name does not exist.
	 */
	public void removePerson(String name) throws PersonDoesNotExistsException{
		for(int i = 0; i<num;i++){
			if(people[i].getName().equals(name) && people[i] != null){
				people[i] = null;
				break;
			}else if(checkName(name, people) == false){ //throw an exception if no name matched and we reached end of the array
				throw new PersonDoesNotExistsException(name.replaceAll("\"", "") + " does not exist in the list!");
			}
		}
		trim(people); //remove the null values from the array
	}
	
	/**
	 * A  method that checks the sex/gender string and
	 * returns male if m, and female if f.
	 * @param sex
	 * name - biological sex of the person 
	 * [Precondition]  - None
	 * [Postcondition] - None
	 * @return
	 * Male - if "M" 
	 * Female - otherwise
	 * @throws None
	 */
	public String identify(String sex){
		String MorF;
		if(sex.charAt(1) == 'M'){// note that the format is "M", so M is at i=1
			MorF = "male";
		}else{
			MorF = "female";
		}
		return MorF;
	}


	/**
	 * A  method that iterates through the people array and removes
	 * any null elements, by copying the contents of the array
	 * to a new, trimmed array.
	 * @param people[]
	 * people [] - array being iterated through and searched for null values
	 * [Precondition]  - None
	 * [Postcondition] - people[] array now becomes the trimmed array
	 * @return None
	 * @throws None
	 */
	public void trim(Person [] people){
		int j = 0;
		for(int i=0; i<people.length;i++){
			if(people[i] != null){
				people[j++] = people[i];
			}
			Person [] trimPeople = new Person[j];
			//System.arraycopy(people, 0, trimPeople, 0, j);
			for(int k = 0; k<trimPeople.length;k++){
				if(k<j){
					trimPeople[k] = people[k]; // copies the contents of people to trimPeople
				}
			}
			this.people = trimPeople;  //people array now becomes trimPeople without any null values
		}
	}
	
	/**
	 * A  method that uses the FileWriter classes to
	 * write to a .csv file 
	 * @param location
	 * location - the directory of the file to be stored to
	 * [Precondition]  - None
	 * [Postcondition] - contents of people[] array saved to a new file
	 * @return None
	 * @throws None
	 */
	public void saveToFile(String fileName) throws IOException{
		String COMMA =",";
		//String QUOTES ="\"";
		String NEW_LINE ="\n";
		String HEADER ="Name,\"Sex\",\"Age\",\"Height(in)\",\"Weight(lbs)\"";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		try{
			bw.append(HEADER);
			for(int i=0; i<people.length;i++){
				bw.append(NEW_LINE);
				bw.append(people[i].getName());
				bw.append(COMMA);
			    //bw.append(QUOTES);
				bw.append("\"" + people[i].getGender() + "\"");
				//bw.append(QUOTES);
				bw.append(COMMA);
				bw.append(String.valueOf(people[i].getAge()));
				bw.append(COMMA);
				bw.append(String.valueOf(people[i].getHeight()));
				bw.append(COMMA);
				bw.append(String.valueOf(people[i].getWeight()));
			}
			bw.flush();
			bw.close();
			System.out.println("...Done!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//prints the PersonDataManager in tabular form
	public void printTable(){
		System.out.format("%10s %5s %s %s %2s %2s %10s %6s %s"
				+ "\n================================================================\n"
				, "Name", "|", "Age", "|","Sex", "|", "Height", "|", "Weight");	
		for(num=0; num<people.length;num++){
			System.out.println(people[num]);
		}
	}
}

