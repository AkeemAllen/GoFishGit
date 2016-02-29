import java.util.*;

public class Hand {
	public ArrayList<Card> Hand; 
	
	public	Hand(){
		Hand = new ArrayList<Card>(); 
	}
	public void drawCard(Deck deckObject){
		Card tempCard = deckObject.getTopCard();
		Hand.add(tempCard);
		deckObject.removeTopCard();
	}
	public void dealHand(Deck deckObject){
		for (int i = 0; i < 7; i++){
			Card tempCard = deckObject.getTopCard();
			Hand.add(tempCard);
			deckObject.removeTopCard();
		}
	}
	protected void printHand()
	{
		for (int i = 0; i < Hand.size(); i++) 
		{
			System.out.println(this.Hand.get(i).valueToString() + " of " + this.Hand.get(i).suitToString());
		}
	}
}
