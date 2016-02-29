import java.util.*;

public class Hand {
	public ArrayList<Card> Hand;
	public ArrayList<Card> Discard;
	public int selfCardIndex, otherCardIndex;
	public boolean testSelf = false;
	public boolean cardInHand = false;

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

	public void removeCard(int cardIndex) {
		Discard.add(Hand.get(cardIndex));
		this.Hand.remove(cardIndex);
	}

	protected void printHand() {
		for (int i = 0; i < Hand.size(); i++) {
			System.out.println(this.Hand.get(i).valueToString() + " of " + this.Hand.get(i).suitToString());
		}
	}

	public boolean testSelfCard(String testedCard) {
		for (int i = 0; i < Hand.size(); i++) {
			if (testedCard == Hand.get(i).valueToString()) {
				testSelf = true;
				return testSelf;
			}
		}
		return testSelf;
	}

	public int testCardToRequest(String testedCard) {
		for (int i = 0; i < Hand.size(); i++) {
			if (testedCard == Hand.get(i).valueToString()) {
				testSelf = true;
				int selfCardIndex = Hand.indexOf(Hand.get(i));

			}
		}
		return selfCardIndex;
	}

	public int requestCard(String testedCard) {
		boolean cardInHand = false;
		for (int i = 0; i < Hand.size(); i++) {
			if (testedCard == Hand.get(i).valueToString()) {
				cardInHand = true;
				int otherCardIndex = Hand.indexOf(Hand.get(i));
			} else {
				cardInHand = false;
			}
		}
		return otherCardIndex;
	}
}
