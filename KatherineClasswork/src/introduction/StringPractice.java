package introduction;

import java.util.Scanner;

public class StringPractice {
	
	static Scanner input;
	static String user;

	public static void main(String[] args) {
		
		//demonstrateStringMethods();
		createFields();
		promptName();
		promptInput();

	}
	
	public static void promptName(){
		print("Enter your name \n" );
		user = input.nextLine();
		print("Glad to meet you, " + user + ". For the rest of time I will call you " + user + "."
				+ " You may call me Computer. We should become friends. \n");
	}
	
	public static void promptForever(){
		
		while(true){
			promptInput();
		}
		
	}
	
	public static void promptInput(){
		
		print("Please type something, " + user + ". \n");
		String userInput = input.nextLine();
		print("Congratulations! You typed : " + userInput);
		
	}
	
	public static void createFields(){
		input = new Scanner(System.in);
		user = "";
	}
	
	public static void demonstrateStringMethods(){
		
		String text1 = new String("Hello, World");
		String text2 = "Hello, World"; //same as above
		
		if(text1.equals(text2)){
			System.out.println("These strings are equal");
		}
		
		String word1 = "Aardvark";
		String word2 = "Zyzzyva";
		if(word1.compareTo(word2) < 0){
			print("word1 comes before word2");
		}
		
	}

	public static void print(String s){
		
		String printString = s;
		int cutOff = 45;
		if(printString.length() > cutOff){
			
			for(int i = 0; i*cutOff < s.length(); i++){
				//apend '=+'
				printString += getCut(s, cutOff, i+1);
			}
			
		}
		
		System.out.print(printString);
		
	}
	
	private static String getCut(String s, int cutoff, int cut){
		
		int cutIndex = cut * cutoff;
		if(cutIndex > s.length())cutIndex = s.length();
		String currentCut = s.substring(0, cutIndex);
		
		int indexOfLastSpace = currentCut.length() - 1;
		//start at last index, go backwards
		for(int i = currentCut.length() - 1; i >= 0; i--){
			
			String letter = currentCut.substring(i, i + 1);
			if(letter.equals("")){
				indexOfLastSpace = i;
				break;
			}
			
			//shorten the cut to end on a space
			currentCut = currentCut.substring(0, indexOfLastSpace);
			
		}
		
		return currentCut;
		
	}
	
}
