
public class CreditCard {
		private String creditCardNumber;
		private String cardHolderName;
		private String bank;
		private int limit;
		private double balance;
		public double price;
		public double amount;
		private final double lateFee = 100;
		
		
		//Constructors
		
		public CreditCard(String creditCardNumber, String cardHolderName, 
				String bank, int limit, double balance){
			this.creditCardNumber = creditCardNumber;
			this.cardHolderName = cardHolderName;
			this.bank = bank;
			this.limit = limit;
			this.balance = balance;	
		}
		
		//Accessors
		
		public String getCreditCardNumber(){ return creditCardNumber; }
		public String getCardHolderName(){ return cardHolderName;}
		public String getBank(){ return bank; }
		public int getLimit(){ return limit; }
		public double getBalance(){ return balance; }
		public boolean chargeIt(double price) {            
			if (price <= getBalance() + getLimit())     //The price charged must be less than the card's limit
				return true;
			else
				return false;
		}
		public double payment(double amount, int Date){
			if(amount>0 && Date <= 15)					//amount deposited cannot be negative
				balance = getBalance() + amount;
			else if(amount > 0 && Date > 15)
				balance = getBalance() + (amount - lateFee);   //late fee applies
			return balance;
		}

		public String toString(){
			return "CreditCard [creditCardNumber=" + creditCardNumber
					+ ", cardHolderName=" + cardHolderName + ", bank=" + bank
					+", limit=" + limit + ", balance=" + balance + "]";
		}
}

