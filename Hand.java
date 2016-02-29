import java.util.*;

public class Hand {
	public ArrayList<Card> Hand;

	public Hand() {
		Hand = new ArrayList<Card>();
	}

	public void drawCard(Deck deckObject) {
		Card tempCard = deckObject.getTopCard();
		this.Hand.add(tempCard);
		deckObject.removeTopCard();
	}

	public void dealHand(Deck deckObject) {
		for (int i = 0; i < 7; i++) {
			Card tempCard = deckObject.getTopCard();
			this.Hand.add(tempCard);
			deckObject.removeTopCard();
		}
	}

	public int getSize() {
		return this.Hand.size();
	}

	public void takeCard(Hand playerHand, Card cardObject) {
		this.Hand.add(cardObject);
		playerHand.removeCard(cardObject);
	}

	public void removeCard(Card cardObject) {
		this.Hand.remove(cardObject);
	}

	protected void printHand() {
		for (int i = 0; i < Hand.size(); i++) {
			System.out.println(this.Hand.get(i).valueToString() + " of " + this.Hand.get(i).suitToString());
		}
	}
}
