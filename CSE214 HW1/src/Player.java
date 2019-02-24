public class Player {
	
	Card cards[];

	private int id;

	// Constructor to set the id
	public Player(int id) {
		super();
		this.id = id;
	}

	// Accessor and Mutator
	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	
	public Card[] getCards() {
		return cards;
	}

	
	// Method to sort the cards in order
	public void cardSort() {
		for (int j = 1; j < cards.length; j++) {
			String s = cards[j].getCard();
			int n = j - 1;
			while (((n > -1) && (cards[n].getCard().compareTo(s)) < 0)) {
				cards[n + 1].setCard(cards[n].getCard());
				n--;
			}
			cards[n + 1].setCard(s);

		}

	}
	
	// Method to print cards
	public void printCards() {
		for (int i = 0; i < cards.length; i++) {
			System.out.print(cards[i].getCard() + " ");
		}
		System.out.println(" ");
	}

}