public class TestSpace {

	public static void main(String[] args) {

		Deck deck = new Deck();
		deck.shuffle();
		deck.printDeck();
		Player player1 = new Player("Alpha");
		player1.getHand().drawCard(deck);
		System.out.println("\n\n\nPrinting delt deck: \n");
		deck.printDeck();
		System.out.println("\n\n\nPrint delt hand: \n");
		player1.getHand().printHand();

	
	for (int i = 0; i < deck.getSize(); i++) {

		System.out.println(i);
	}



	}
}
