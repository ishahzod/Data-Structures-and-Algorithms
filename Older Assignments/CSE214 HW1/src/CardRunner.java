import java.util.Arrays;

import GameOfCards.Card;

public class CardRunner {

    public static void main(String[] args) {
        String[] cardsForPlayer1 = {"S4", "D8", "C4", "D3", "D5", "DJ", 
        		"S3", "D4", "DA", "SJ", "D7", "H10", "D6"};

        int[] x = {7, 7, 657, 7, 75, 75, 5, 43, 3, 322, 36, 7, 8, 9, 0, 1, 2, 2, 23};

        Player player = new Player(1); // Makes new Player instantiation and sets id to 1.

        for(int i = 0; i < cardsForPlayer1.length; i++) {
            player.cards[i] = new Card(cardsForPlayer1[i]); // makes each index of the Card array equal to the reference of mCard.
            System.out.print(player.cards[i].finalRank + " ");
        } // End for loop
        System.out.println();

            /*
            player.sortCards(x);
            for(int i : x){
                System.out.println(i);
            }
            */

        //player.setCards(player.cards);
        Arrays.sort(player.cards);


        player.printCards(); // works.

        System.out.println();
            // should print: S4 D8 C4 D3 D5 DJ S3 D4 DA SJ D7 H10 D6

            /*
             * Sort and show output
             */

        //player.sortCards(player.cards);


        player.printCards();
            // should print: SJ S4 S3 H10 DA DJ D8 D7 D6 D5 D4 D3 C4

    }

}

