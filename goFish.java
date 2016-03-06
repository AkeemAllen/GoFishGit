import java.util.*;
import java.util.concurrent.TimeUnit;

public class goFish {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello, you may have heard of my chess playing computer cousin, Deep Blue...\n\n"
				+ "Well my name is Deep Fish, and welcome to go fish!\n"
				+ "Listen carefully so you catch on to the rules:\n\n\n"
				+ "We will each be dealt seven random cards at the start of the game.\n"
				+ "We will each discard any doubles drawn. Your hand will be displayed to you,\n"
				+ "and you will ask me if I have a card of the same value in my own hand.\n"
				+ "If I do, I will give it to you and you will put both cards in your discard pile\n"
				+ ", and you can ask again. Once you ask for a value of a card that I do not have,\n"
				+ "you will 'go fish' and draw a card from the deck. If you draw a card equal to a value\n"
				+ "of a card already in your hand, you will discard them, but will not be able to ask\n"
				+ "again until after my turn ends. Once your turn ends, I will get my turn and follow\n"
				+ "the same rules. The game ends once the deck is empty, and one of us has ran out of cards.\n"
				+ "The one with the most cards in their discard when the game ends wins.");
		System.out.println("What is your name, human?");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in); // create new scanner object
		String playerName = scan.nextLine();
		Player player1 = new Player(playerName); // create new player object
		Computer computer1 = new Computer("Deep Fish"); // create new computer
														// object

		Deck deck = new Deck(); // create new deck
		deck.shuffle(); // shuffle the deck
		player1.hand.dealHand(deck); // deal a hand of seven cards to player
		computer1.hand.dealHand(deck); // deal a hand of seven cards to computer
		String user_choice = " "; // initialize the player's choice
		int computer_choice = 0;
		String computerString_choice = " ";
		// Loop until the deck is empty
		while (deck.getSize() > 0) {
			// loop until one player is out of cards
			do {
				System.out.println("This is your current hand: \n");
				player1.hand.printHand(); // Display the hand to the player
				System.out
						.println("\n\nType in a word corresponding to the appropriate value you wish to ask for: \n\n");
				// get the string value of the user's choice
				user_choice = scan.nextLine();
				// test to ensure the card is in the player's hand
				player1.hand.testSelfCard(user_choice);
				// test to see if the card is in the computer's hand (returned on line 52)
				computer1.hand.testCardToRequest(user_choice);
				// If the card is in the player's hand
				if (player1.hand.testSelf) {
					// Test to see if the value of the card is in computer's hand If the card in hand returns true
					if (computer1.hand.cardInHand) {
						// While the card in hand remains true (loops again if the user picks another correct card)
						while (computer1.hand.cardInHand) {
							System.out.println(
									"\n\nExcellent! You take card with value " + user_choice + " in to your hand and discard the pair.");
							// find the index of the card in player's hand that they requested.
							player1.hand.indexOfOwnCardRequested(user_choice);
							// removes that card and add to player's discard pile
							player1.hand.removeCardToTargetDiscard(player1.hand.cardIndex, player1);
							// If the hand is empty, draw
							if (player1.hand.handIsEmpty()) {
								if (!deck.deckIsEmpty()) {
									player1.hand.drawCard(deck);
								} else {
									//the game ends if the deck is empty and a player is out of cards
									System.out.println("Game over!");
									computer1.hand.determineWinner(computer1, player1);
									System.exit(0);
								}

							}
							// find the index of the card in computer's hand that was requested.
							computer1.hand.requestCard(user_choice);
							// remove the card from the computer and discard in player pile
							computer1.hand.removeCardToTargetDiscard(computer1.hand.cardIndex, player1);
							// If the hand is empty, draw
							if (computer1.hand.handIsEmpty()) {
								if (!deck.deckIsEmpty()) {
									computer1.hand.drawCard(deck);
								} else {
									//game ends
									System.out.println("Game over!");
									computer1.hand.determineWinner(computer1, player1);
									System.exit(0);
								}

							}
							System.out.println("This is your current hand: \n");
							// Display the player's hand again
							player1.hand.printHand();
							System.out.println(
									"\n\nType in a word corresponding to the appropriate value you wish to ask for: \n\n");
							user_choice = scan.nextLine();
							// Test to see if the card is in the player's hand
							player1.hand.testSelfCard(user_choice);
							if (player1.hand.testSelf) {
								computer1.hand.testCardToRequest(user_choice);
								if (!computer1.hand.cardInHand) {
									System.out.println("Sorry, the card value " + user_choice
											+ " is not in the hand of " + computer1.getName());
									System.out.println("Go Fish!\n\n\n");
									//slow the game down a little so it's readable
									TimeUnit.SECONDS.sleep(2);
								}
							} else {
								// if the card isn't in the player hand or they try to type in a wrong value
								System.out.println("That card isn't in your hand!");
								System.out.println("Go Fish!\n\n\n");
								TimeUnit.SECONDS.sleep(2);
							}
						}

					} else {
						System.out.println("Sorry, the card value " + user_choice + " is not in the hand of "
								+ computer1.getName());
						System.out.println("Go Fish!\n\n\n");
						TimeUnit.SECONDS.sleep(2);
					}
				} else {
					System.out.println("That card isn't in your hand!");
					System.out.println("Go Fish!\n\n\n");
					TimeUnit.SECONDS.sleep(2);
				}
				player1.hand.drawCard(deck);
				System.out.println("Your hand: ");
				player1.hand.printHand();
				System.out.println("\n\n");
				TimeUnit.SECONDS.sleep(1);
				// randomly pick a number from the computer's hand.
				computer_choice = computer1.hand.randomCardIndex();
				// Convert the computer's choice (random index) to a string of
				// the card's value
				computerString_choice = computer1.hand.stringOfIndexOfCardToRequest(computer_choice);
				// Check to see if the card is in the player's hand
				player1.hand.testCardToRequest(computerString_choice);
				// if it isn't, display a message
				if (!player1.hand.cardInHand) {
					System.out
							.println("Deep Fish requested " + computerString_choice + " from your hand, but fails!");
					TimeUnit.SECONDS.sleep(1);
				}
				// If it is, loop until the computer guesses a wrong card
				while (player1.hand.cardInHand) {
					System.out.println("Deep Fish requests " + computerString_choice + " from your hand!\n");
					// remove the player's card and adds to computer's discard
					player1.hand.indexOfOwnCardRequested(computerString_choice);
					player1.hand.removeCardToTargetDiscard(player1.hand.cardIndex, computer1);
					// If the hand is empty, draw
					if (player1.hand.handIsEmpty()) {
						if (!deck.deckIsEmpty()) {
							player1.hand.drawCard(deck);
						} else {
							System.out.println("Game over!");
							computer1.hand.determineWinner(computer1, player1);
							System.exit(0);
						}
					}
					// remove the computer's card and add to computer's discard
					computer1.hand.removeCardToTargetDiscard(computer_choice, computer1);
					// If the hand is empty, draw
					if (computer1.hand.handIsEmpty()) {
						if (!deck.deckIsEmpty()) {
							computer1.hand.drawCard(deck);
						} else {
							System.out.println("Game over!");
							computer1.hand.determineWinner(computer1, player1);
							System.exit(0);
						}
					} else if (!player1.hand.handIsEmpty()) {
						System.out.println("Deep Fish gets to request again!");
						TimeUnit.SECONDS.sleep(2);
						if (computer1.hand.handIsEmpty()) {
							computer1.hand.drawCard(deck);
						} else {
							computer_choice = computer1.hand.randomCardIndex();
							computerString_choice = computer1.hand.stringOfIndexOfCardToRequest(computer_choice);
							player1.hand.testCardToRequest(computerString_choice);
							if (!player1.hand.cardInHand) {
								System.out.println("Deep Fish requested " + computerString_choice
										+ " from your hand, but fails!");
								TimeUnit.SECONDS.sleep(2);
							}
						}
					}

				}

				computer1.hand.drawCard(deck);
			} while (!player1.hand.handIsEmpty() && !computer1.hand.handIsEmpty());
		}

	}

}
