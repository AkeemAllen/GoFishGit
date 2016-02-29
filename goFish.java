import java.util.*;

public class goFish {

	public static void main(String[] args) {
		Player player1 = new Player("Fish Fergeson"); // create new player
														// object
		Computer computer1 = new Computer("Deep Fish"); // create new computer
														// object

		Scanner scan = new Scanner(System.in); // create new scanner object
		Deck deck = new Deck(); // create new deck
		deck.shuffle(); // shuffle the deck
		player1.hand.dealHand(deck); // deal a hand of seven cards to player
		computer1.hand.dealHand(deck); // deal a hand of seven cards to computer
		String user_choice = " "; // initialize the player's choice
		// Loop until the deck is empty
		while (deck.getSize() > 0) {
			// loop until one player is out of cards
			while (player1.hand.getSize() > 0 && computer1.hand.getSize() > 0) {
				System.out.println("This is your current hand: \n");
				player1.hand.printHand(); // Display the hand to the player
				System.out.println("\n\nSelect a number correstponding to a card's value to"
						+ "\n see if the computer has a matching pair.");
				System.out.println("\n\n printing computer's cards... : ");
				// Display the hand of the computer (for "testing")
				computer1.hand.printHand();
				// get the string value of the user's choice
				user_choice = scan.nextLine();
				// test to ensure the card is in the player's hand
				player1.hand.testSelfCard(user_choice);
				// If the card is in the player's hand
				if (player1.hand.testSelf) {
					// Test to see if the value of the card is in computer's
					// hand
					computer1.hand.testCardToRequest(user_choice);
					// If the card in hand returns true
					if (computer1.hand.cardInHand) {
						// While the card in hand remains true (loops again if
						// the user picks another correct card)
						while (computer1.hand.cardInHand = true) {
							System.out.println(
									"Excellent! You take card with value " + user_choice + " in to your hand.");
							// find the index of the card in player's hand that
							// they requested.
							player1.hand.indexOfOwnCardRequested(user_choice);
							// removes that card and add to player's discard
							// pile
							player1.hand.removeCard(player1.hand.cardIndex);
							// find the index of the card in computer's hand
							// that was requested.
							computer1.hand.requestCard(user_choice);
							// remove the card from the computer and discard in
							// player pile
							player1.hand.removeCard(computer1.hand.cardIndex);
							System.out.println("This is your current hand: \n");
							// Display the player's hand again
							player1.hand.printHand();
							System.out.println("\n\nSelect a number correstponding to a card's value to"
									+ "\n see if the computer has a matching pair.");
							user_choice = scan.nextLine();
							// Test to see if the card is in the player's hand
							player1.hand.testSelfCard(user_choice);
							if (player1.hand.testSelf) {
								computer1.hand.testCardToRequest(user_choice);
								if (computer1.hand.cardInHand) {
									player1.hand.indexOfOwnCardRequested(user_choice);
									player1.hand.removeCard(player1.hand.cardIndex);
									computer1.hand.requestCard(user_choice);
									computer1.hand.removeCard(computer1.hand.cardIndex);
								}
							} else {
								System.out.println("That card isn't in your hand!");
							}

						}

					}
				} else {
					System.out.println("That card isn't in your hand!");
				}

				System.out.println("\n\nGo Fish!");
				player1.hand.drawCard(deck);
				// randomly pick a number from the computer's hand.
			}
		}
	}
}
