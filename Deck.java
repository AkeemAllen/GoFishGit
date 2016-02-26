
public class Deck {
	
	private Card[] deck;

	//Constructor to create a standard 52 card deck
	public Deck() 
	{
		deck = new Card[52];
		int count = 0;
		
		//Fills the deck with cards
		for(int suit = 0; suit<=3; suit++) 
		{
			for(int value = 1; value <= 13; value++) 
			{
				deck[count] = new Card(value, suit);
				count++;
			}
		}	
	}
	protected void shuffle()
	//Selects and random index in the deck and swaps it with index i
	{
		for (int i = 0; i < 52; i++)
		{
			int rand = (int) (Math.random() * 52 +1);
			Card temp = deck[rand];
			deck[rand] = deck[i];
			deck[i] = temp;
		}
		
	}
	protected void printDeck()
	//Prints the deck to test that it has been shuffled adequately with no copies
	{
		for (int i = 0; i < 52; i++){
			System.out.println(deck[i]);
		}
	}	
}
