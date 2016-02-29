import java.util.*;

public class Hand {
	public ArrayList<Card> Hand;
	public ArrayList<Card> Discard;

	public Hand() {
		Hand = new ArrayList<Card>();
		Discard = new ArrayList<Card>();
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

	public void removeCard(cardIndex) {
		Discard.add(Hand.get(cardIndex));
		this.Hand.remove(cardObject);
	}

	protected void printHand() {
		for (int i = 0; i < Hand.size(); i++) {
			System.out.println(this.Hand.get(i).valueToString() + " of " + this.Hand.get(i).suitToString());
		}
	}

	public int testSelfCard(String testedCard) {
		boolean testSelf = false;
		for (int i = 0; i < Hand.size(); i++) {
			if (testedCard == Hand.get(i).valueToString()) {
				testSelf = true;
				int selfCardIndex = Hand.indexOf(Hand.get(i));
				return selfCardIndex;
			}
		}
	}

	public int requestCard(String testedCard) {
		boolean cardInHand = false;
		for (int i = 0; i < Hand.size(); i++) {
			if (testedCard == Hand.get(i).valueToString()) {
				cardInHand = true;
				int cardIndex = Hand.indexOf(Hand.get(i));
				return cardIndex;

			}
		}
	}

}
