public class Hand
// ----------------------------------------------------------------------------
// A virtual representation of a hand object in a card game.
// ----------------------------------------------------------------------------
{
	private Card[] Hand;

	public Hand()
	// Default constructor.
	{
		Hand = new Card[52];
		/*
		 * Creates an an array using the Card class. This program has no
		 * restraints on memory use, so there is no need to calculate the worse
		 * possible scenario for the size of a hand in this game
		 */
	}

	void addCard()
	// Adds a card to the player's hand. I don't feel like we're far enough in
	// development to see how we want to build this method.
	{

	}

	void printHand()
	// A getter method for the hand class. Prints out each element in the
	// hand array.
	{
		for (int i = 0; i < 51; i++) {
			System.out.println(Hand[i]);
		}
	}

	void setHand(Card theCard, int Index)
	/*
	 * Mutator method for the hand array. Used for testing. Not implemented in
	 * main program. Could possibly be used for code reuse for another card
	 * game?
	 */
	{
		Hand[Index] = theCard;
	}
}
