
public class CreditCardDriver {

	public static void main(String[] args) {
		CreditCard C = new CreditCard("1234567", "Shakira", "Chase", 5000, 600);
		
	
		
		System.out.println(C.toString());
		
		//Testing the new methods 
		System.out.println("Transaction: " + C.chargeIt(5601));      //Transaction fails, 5601 > 5600
		System.out.println("New Balance: " + C.payment(50, 16));     //paymet(amount, date) 
	    															 //Late fee = 100, 600+50 - 100 = 550
		
	}
}
