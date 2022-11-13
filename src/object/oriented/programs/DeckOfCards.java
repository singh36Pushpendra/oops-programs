package object.oriented.programs;

import java.util.Random;

public class DeckOfCards {

	public static void main(String[] args) {
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		String[][] playersCards = new String[4][9];
		String[] concatSuitAndCard = new String[36];
		
		Random random = new Random();
		int k, randomSuit, randomCard;
		
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < playersCards[i].length; j++) {
				randomSuit = random.nextInt(4);
				randomCard = random.nextInt(13);
				k = 0;
				while (concatSuitAndCard[k] != null) {
					if (concatSuitAndCard[k].equals(suits[randomSuit] + cards[randomCard])) {
						k = 0;
						randomSuit = random.nextInt(4);
						randomCard = random.nextInt(13);
					}
					else
						k++;
				}
				concatSuitAndCard[k] = suits[randomSuit] + cards[randomCard];
				playersCards[i][j] = concatSuitAndCard[k];
			}
		}
		
		for (int i = 0; i < playersCards.length; i++) {
			System.out.println("Player " + (i + 1) + " Cards:  ");
			for (String playerCard : playersCards[i]) 
				System.out.print(playerCard + "  ");
			System.out.println("\n");
		}
	}
}
