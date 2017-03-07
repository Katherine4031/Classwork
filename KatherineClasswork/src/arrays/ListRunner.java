package arrays;

import java.util.ArrayList;

public class ListRunner {
	
	static ArrayList<Item> shoppingList;

	public static void main(String[] args) {
		String[] justDescriptions = getDescriptions();
		initList(justDescriptions);
		doSomeShopping();
		printPurchasedItems();
	}

	private static void printPurchasedItems() {
		for(int i = 0; i < shoppingList.size(); i++){
			if(shoppingList.get(i).isPurchased()){
				System.out.println(shoppingList.get(i).getDescription());
				shoppingList.remove(i);
				i--;
			}
		}
	}

	private static void doSomeShopping() {
		shoppingList.get(0).setPurchased(true);
		shoppingList.get(3).setPurchased(true);
	}

	private static void initList(String[] justDescriptions) {
		shoppingList = new ArrayList<Item>(); //1pt
		for(String s: justDescriptions){ //.5pt
			Item temp = new Item(s); //1pt
			shoppingList.add(temp); //.5pt adding
		}
		
		//also acceptable:
		//for(int i = 0; i < justDescriptions.length; i++){
		//	shoppingList.add(new Item(justDescriptions[i])); //.5pt adding, 1pt creating Item
		//}
	}

	private static String[] getDescriptions() {
		String[] test = {"coffee", "video games", "potato chips", "a life"};
		return test;
	}

}
