import java.util.*;

public class goFish {

	public static void main(String[] args) {
		Player player1 = new Player("Fish Fergeson");
		Computer computer1 = new Computer("Deep Fish");

		Scanner scan = new Scanner(System.in);
		Deck deck = new Deck();
		deck.shuffle();
		player1.hand.dealHand(deck);
		computer1.hand.dealHand(deck);
		String user_choice = " ";
		boolean cardInHand = false;
		while (deck.getSize() > 0) {
			while (player1.hand.getSize() > 0 && computer1.hand.getSize() > 0) {
				System.out.println("This is your current hand: \n");
				player1.hand.printHand();
				System.out.println("\n\nSelect a number correstponding to a card's value to"
						+ "\n see if the computer has a matching pair.");
				user_choice = scan.nextLine();
				player1.hand.testSelfCard(user_choice);
				if (player1.hand.testSelf) {
					computer1.hand.requestCard(user_choice);
					while (cardInHand = true) {
						System.out.println("Excellent! You take card with value " + user_choice + " in to your hand.");
						player1.hand.removeCard(player1.hand.selfCardIndex);
						player1.hand.removeCard(computer1.hand.otherCardIndex);
					}
					System.out.println("Exited while loop");
				}

			}
		}
	}
}
