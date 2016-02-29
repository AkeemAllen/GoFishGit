import java.util.*;
public class Deck {
	
	public ArrayList<Card> deck;

	//Constructor to create a standard 52 card deck
	public Deck() 
	{
		this.deck = new ArrayList<Card>();
		
		//Fills the deck with cards
		for(int suit = 0; suit<4; suit++) 
		{
			for(int value = 0; value <13; value++) 
			{
				this.deck.add(new Card(value, suit));
				System.out.println();

			}
		}	
	}
	protected void shuffle()
	//Selects a random index in the deck and swaps it with index i
	{
		for (int i = 0; i < 52; i++)
		{
			int rand = (int) (Math.random() * 52);
			Card temp = this.deck.get(rand);
			this.deck.set(rand, this.deck.get(i));// = this.deck.get(i);
			this.deck.set(i, temp);
		}
		
	}
	
	//Prints the deck to test that it has been shuffled adequately with no copies
	protected void printDeck()
	{
		for (int i = 0; i < 52; i++) 
		{
			System.out.println(this.deck.get(i).valueToString() + " of " + this.deck.get(i).suitToString());
		}
	}	
}
