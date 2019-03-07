public class CardTest {

	public static void main(String[] args) {

		String[] cardsForPlayer1 = { "S4", "D8", "C4", "D3", "D5", "DJ", "S3", "D4", "DA", "SJ", "D7", "H10", "D6" };

		Card[] cards = new Card[13];

		for (int i = 0; i < cardsForPlayer1.length; i++){
			Card mCard = new Card(cardsForPlayer1[i]);
			cards[i] = mCard;
		}
		
		//Sets the id for first player
		int id = 1;

		Player player = new Player(id);

		//Draws cards for player1
		player.setCards(cards);
		System.out.println("Drawn Cards: ");
		player.printCards();
		System.out.println();
		
		//Sorts the cards for player1
		player.cardSort();
		System.out.println("Sorted Cards: ");
		player.printCards();

	}

}