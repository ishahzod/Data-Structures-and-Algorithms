/**
 * 
 * @author Shahzod Ismatov
 * SBU ID: 110518374
 * CSE214-R11
 *
 */
import java.io.*;
import java.util.*;

public class PersonManager {
	
	/**
	 * Allows the user to interact with the PersonDataManager database by
	 * listing the people, adding to the list, removing, and retrieving from
	 * the list.
	 * 
	 * The main method presents the user with a menu, and utilizes a 
	 * switch statement to go through the user's choice
	 * @param 
	 * args[] - generic parameter for the main method
	 * [Precondition]  - None
	 * [Postcondition] - None
	 * @return None
	 * @throws None
	 */
	public static void main(String[] args){
		PersonDataManager personDataManager = new PersonDataManager();
		Scanner usr = new Scanner(System.in);
		System.out.println("Starting...");
		while(true){
			System.out.println("\nMenu:\n"
					+ "\t(I) - Import from File\n"
					+ "\t(A) - Add Person\n"
					+ "\t(R) - Remove Person\n"
					+ "\t(G) - Get Information on Person\n"
					+ "\t(P) - Print Table\n"
					+ "\t(S) - Save to File\n"
					+ "\t(Q) - Quit\n");
			System.out.print("Please select an option: ");
			char choice = Character.toUpperCase(usr.next().charAt(0));

			switch(choice){
			case 'I':
				System.out.print("Please enter a location: ");
				String location = usr.next();
				System.out.println("Loading... ");
				personDataManager = PersonDataManager.buildFromFile(location);
				System.out.println("This method's Big(O) Notation was O(N" + '\u00B2' + ")");
				break;

			case 'G':
				System.out.print("Please enter the name of the person: ");
				String nameG = usr.next();
				if(isAlphabetic(nameG))
					nameG = "\"" + nameG + "\"";
				else{ 
					System.out.println("Invalid name. Please try again.");
					break;
				}
				try {
					personDataManager.getPerson(nameG);
					System.out.println("This method's Big(O) Notation was O(N)");
				} catch (PersonDoesNotExistsException e) {
					System.out.println(e.getMessage());
				}
				break;


			case'A':
				System.out.print("Please enter the name of the person: ");
				String nameA = usr.next();
				if(isAlphabetic(nameA))
					nameA = "\"" + nameA + "\"";
				else{ 
					System.out.println("Invalid name. Please try again.");
					break;
				}
				
				////////////////       AGE      /////////////////	
				int age = 0; 
				System.out.print("Please enter the age: ");
				if(usr.hasNextInt()){
					age = usr.nextInt();
					if(age<0){
						try {
							throw new ThisCannotBeNegativeException("You entered a negative value for age. Please try again.");
						} catch (ThisCannotBeNegativeException e1) {
							System.out.println(e1.getMessage());
							break;
						}
					}
				}else{
					System.out.println("Invalid age. Please enter an integer value.");
					usr.next();
					break;
				}

				
				////////////////        SEX     /////////////////	
				System.out.print("Please enter the sex (M or F): ");
				String sex = usr.next();
				if(Character.toUpperCase(sex.charAt(0)) == 'M' || Character.toUpperCase(sex.charAt(0)) == 'F'){
					sex = "\"" + Character.toUpperCase(sex.charAt(0)) + "\"";
				}else{
					System.out.println("Invalid sex. Please try again.");
					break;
				}
				
				///////////////  HEIGHT //////////////////////////
				double height = 0;
				System.out.print("Please enter the height(in inches): ");
				if(usr.hasNextDouble()){
					height = usr.nextDouble();
					if(height<0){
						try {
							throw new ThisCannotBeNegativeException("You entered a negative value for height. Please try again.");
						} catch (ThisCannotBeNegativeException e1) {
							System.out.println(e1.getMessage());
							break;
						}
					}
				}else{
					System.out.println("Invalid height. Please enter a double value type.");
					usr.next();
					break;
				}
				
				//////////////////       WEIGHT        ////////////////////
				double weight = 0;
				System.out.print("Please enter the weight(in lbs): ");
				if(usr.hasNextDouble()){
					weight = usr.nextDouble();
					if(weight<0){
						try {
							throw new ThisCannotBeNegativeException("You entered a negative value for weight. Please try again.");
						} catch (ThisCannotBeNegativeException e1) {
							System.out.println(e1.getMessage());
							break;
						}
					}
				}else{
					System.out.println("Invalid weight. Please enter a double value type.");
					usr.next();
					break;
				}

				Person newPerson = new Person(nameA, sex, age, height, weight);
				try {
					personDataManager.addPerson(newPerson);
					System.out.println(nameA + " has been added to the list!");
					System.out.println("This method's Big(O) Notation was O(N" + "\u00B3"+ ")");
					//personDataManager.printTable();
				} catch (PersonAlreadyExistsException e) {
					System.out.println(e.getMessage());;
				} break;


			case 'R':
				System.out.print("Please enter the name of the person: ");
				String nameR = usr.next();
				if(isAlphabetic(nameR))
					nameR = "\"" + nameR+ "\"";
				else{ 
					System.out.println("Invalid name. Please try again.");
					break;
				}
				try {
					personDataManager.removePerson(nameR);
					System.out.println(nameR + " has been removed!");
					System.out.println("This method's Big(O) Notation was O(N" + "\u00B3"+ ")");
				} catch (PersonDoesNotExistsException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 'S':
				System.out.print("Please select a name for the file: ");
				String fileName = usr.next();
					try {
						personDataManager.saveToFile(fileName);
						System.out.println("A file named " + fileName + " has been created!");
						System.out.println("This method's Big(O) Notation was O(N)");
						
					} catch (IOException e) {
						System.out.println(e.getMessage());
						System.out.println("Invalid file name. Try again.");
					}
				break;

			case 'P':
				personDataManager.printTable();
				System.out.println("This method's Big(O) Notation was O(N)");
				break;

			case 'Q': 
				System.out.println("Sorry to see you go!");
				System.exit(0);

			default:
				System.out.println("Incorrect input. Please select from the options listed.");
			}
		}
	}
	/**
	 * A method that determines if a String contains only alphabetic characters
	 * @param name
	 * The string that is going to be checked
	 * @return
	 * True if all characters in the string are alphabetic
	 * False if the string contains others (e.g. $,!,&) 
	 * Indicates that y is equal to zero.
	 */
	//returns true if the string contains only letters, NOT  $, !, etc
	private static boolean isAlphabetic(String name) {
		return name.matches("[a-zA-Z]+");
	}
}
