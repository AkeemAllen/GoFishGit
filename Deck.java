
public class Deck {

	private int count = 0;
	private Card[] deck;

	// Constructor to create a standard 52 card deck
	public Deck() {
		this.deck = new Card[52];
		// Fills the deck with cards
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 0; value < 13; value++) {
				this.deck[count] = new Card(value, suit);
				System.out.println();
				count++;
			}
		}
	}

	protected void shuffle()
	// Selects a random index in the deck and swaps it with index i
	{
		for (int i = 0; i < 52; i++) {
			int rand = (int) (Math.random() * 51 + 1);
			Card temp = deck[rand];
			deck[rand] = deck[i];
			deck[i] = temp;
		}

	}

	protected void printDeck()
	// Prints the deck, excluding "blank" cards, filler cards that fill the end
	// of the deck until it's empty.
	{
		for (int i = 0; i < 52; i++) {
			if (this.deck[i].getValue() == 13) {
				break;
			} else
				System.out.println(this.deck[i].valueToString() + " " + this.deck[i].suitToString());
		}
	}

	protected void dealCard(Player player)
	// returns the top card and shifts each card's index towards 0, replacing
	// the end card(s) with a blank one
	{

		System.out.println("Dealing hand to player, " + player);
		returnTopCard();
		for (int i = 1; i < count; i++) {
			this.deck[i - 1] = this.deck[i];
		}
		this.deck[count - 1] = new Card(13, 4);
		count--;
	}

	private Card returnTopCard()
	// returns the value of the top card
	{
		Card topCard = deck[0];
		return topCard;
	}
}
