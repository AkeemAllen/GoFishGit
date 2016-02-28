public class Card {

	private static final int SPADE = 0;
	private static final int DIAMOND = 1;
	private static final int HEART = 2;
	private static final int CLUB = 3;

	private static final int ACE = 1;
	private static final int JACK = 11;
	private static final int QUEEN = 12;
	private static final int KING = 13;

	private int suit;
	private int value;
	

	//Creates a card
	public Card(int theValue, int theSuit) 
	{
		this.value = theValue;
		this.suit = theSuit;
	}

	public int getSuit() 
	{
		return suit;
	}

	public int getValue() 
	{
		return value;
	}

	public String suitToString() 
	{
		switch (suit) 
		{
			case 0: return "SPADE";
			case 1: return "DIAMOND";
			case 2: return "HEART";
			default: return "CLUB";
		}
	}

	public String valueToString() 
	{
		switch (value) 
		{
			case 1: return "Ace";
			case 2: return "Two";
			case 3: return "Three";
			case 4: return "Four";
			case 5: return "Five";
			case 6: return "Six";
			case 7: return "Seven";
			case 8: return "Eight";
			case 9: return "Nine";
			case 10: return "Ten";
			case 11: return "Jack";
			case 12: return "Queen";
			default: return "King";
		}
	}

	public String toString() 
	{
		return suit + " " + value;
	}




} 