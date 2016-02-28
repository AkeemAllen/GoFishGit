public class TestSpace {

	public static void main(String[] args) {

		Deck deck1 = new Deck();

		deck1.printDeck();
		Player user = new Player();
		Computer computer = new Computer();
		System.out.println(user);
		System.out.println(computer);
		deck1.dealCard(user);
		deck1.printDeck();

		deck1.shuffle();
		deck1.printDeck();
	}
}
