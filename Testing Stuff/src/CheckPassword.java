import java.util.Scanner;
public class CheckPassword {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a password:");
		String p = in.nextLine();
		
		boolean b = isValid(p);
		if(b){
			System.out.println("Valid Password");
		}
		else
			System.out.println("Invalid Password");

	}
	
	public static boolean isValid(String p){
		int digits = 0; 
		//boolean hasDigits = false;
		boolean special = false;
		for(int i=0; i<p.length(); i++){
			if(Character.isDigit(p.charAt(i)))
				digits++;
			if(!Character.isLetterOrDigit(p.charAt(i)))
					special = true;
		}
		if(digits >= 2 && !special && p.length()>=8){
			return true;
		}
		return false; 
	}
}
