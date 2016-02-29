public class TestSpace {

	public static void main(String[] args) {
	
	Deck deck = new Deck();
	deck.shuffle();
	deck.printDeck();

	
	for (int i = 0; i < deck.getSize(); i++) {

		System.out.println(i);
	}



	}
}