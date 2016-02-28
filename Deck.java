
public class Deck {
	
	private Card[] deck;

	//Constructor to create a standard 52 card deck
	public Deck() 
	{
		this.deck = new Card[52];
		int count = 0;
		
		//Fills the deck with cards
		for(int suit = 0; suit<=3; suit++) 
		{
			for(int value = 0; value <13; value++) 
			{
				this.deck[count] = new Card(value, suit);
				System.out.println();
				count++;
			}
		}	
	}
	protected void shuffle()
	//Selects a random index in the deck and swaps it with index i
	{
		for (int i = 0; i < 52; i++)
		{
			int rand = (int) (Math.random() * 52 +1);
			Card temp = deck[rand];
			deck[rand] = deck[i];
			deck[i] = temp;
		}
		
	}
	
	//Prints the deck to test that it has been shuffled adequately with no copies
	protected void printDeck()
	{
		for (int i = 0; i < 52; i++) 
		{
			System.out.println(this.deck[i].valueToString() + " " + this.deck[i].suitToString());
		}
	}	
}
