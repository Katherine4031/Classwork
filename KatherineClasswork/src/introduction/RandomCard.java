package introduction;

public class RandomCard {

	public static void main(String[] args) {
		
		String[] cardType = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] cardSuit = {"Diamonds", "Clubs", "Hearts", "Spades"};
		
		System.out.println("The " + cardType[getRandType()] + " of " + cardSuit[getRandSuit()]);

	}
	
	public static int getRandType(){
		
		double rand = Math.random();
		int typeIndex = (int) (13*rand);
		return typeIndex;
		
	}
	
	public static int getRandSuit(){
		
		double rand =  Math.random();
		int suitIndex = (int) (4*rand);
		return suitIndex;
		
	}

}
