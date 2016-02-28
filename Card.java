public class Card {

	private int suit;
	private int value;

	//Creates a card
	public Card(int value, int suit) 
	{
		this.value = value;
		this.suit = suit;
	}
//fixed
	public int getSuit() 
	{
		return this.suit;
	}

	public int getValue() 
	{
		return this.value;
	}

	public String suitToString() 
	{
		switch (this.suit) 
		{
			case 0: return "SPADES";
			case 1: return "DIAMONDS";
			case 2: return "HEARTS";
			default: return "CLUBS";
		}
	}

	public String valueToString() 
	{
		switch (this.value) 
		{
			case 0: return "Ace";
			case 1: return "Two";
			case 2: return "Three";
			case 3: return "Four";
			case 4: return "Five";
			case 5: return "Six";
			case 6: return "Seven";
			case 7: return "Eight";
			case 8: return "Nine";
			case 9: return "Ten";
			case 10: return "Jack";
			case 11: return "Queen";
			default: return "King";
		}
	}

	public String toString() 
	{
		return this.value + " of " + this.suit;
	}




} 