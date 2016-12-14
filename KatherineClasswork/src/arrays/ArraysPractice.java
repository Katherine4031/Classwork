package arrays;

public class ArraysPractice {
	
	/*
	 * ARRAYS:
	 * 		Fixed length
	 * 		Indices start at zero
	 * 		Indexed(ordered)
	 * Common data type (e.g. "Student[]")
	 * 
	 * Arrays of any type must be Object[]
	 * If you want to put different primitive types into an array, you must use the WRAPPER CLASS
	 * */
	
	static boolean[] boos3;

	public static void main(String[] args) {
		
		listPrimes(120);
		
		//how do you time a process?
		long currentTime = System.currentTimeMillis();
		
	//	int[] fiftyNumbers = new int[50];
	//	populate(fiftyNumbers);
	//	print(fiftyNumbers);
	//	randomize(fiftyNumbers);
	//	print(fiftyNumbers);
	//	rollDice(fiftyNumbers);
	//	print(fiftyNumbers);
		//count each die roll and provide a percentage
	//	countResult(fiftyNumbers, 2);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The process took " + (endTime - currentTime) + "ms.");

	}
	
	private static void listPrimes(int limit) {
		int lastToCheck = (int)(Math.sqrt(limit));
		boolean[] numbers = new boolean[limit + 1];
		for(int i = 0; i < limit + 1; i++){
			numbers[i] = true;
		}
		//0 and 1 are, by definition, not prime
		numbers[0] = false;
		numbers[1] = false;
		//check all non-"crossed off" numbers (start with 2)
		for(int prime = 2; prime <= lastToCheck; prime++){
			if(numbers[prime]){
				System.out.println("\n" + prime + " is prime. Crossing off: ");
				for(int i = (int)(Math.pow(prime, 2)); i < limit + 1; i += prime){
					System.out.print(i + ", ");
					numbers[i] = false;
				}
			}
		}
		//print the primes
		System.out.println("\nThe primes are: ");
		for(int index = 0; index < numbers.length; index++){
			if(numbers[index]){
				System.out.print(index + ", ");
			}
		}
	}

	private static void countResult(int[] n, int numberOfDice) {
		
		System.out.println("Count Result Method");
		int[] counter = new int[numberOfDice*6];
		//populate(counter);
		for(int c : n){
			counter[c - 1] = counter[c - 1] + 1;
		}
		for(int i = 0; i < n.length; i++){
			System.out.println((i + 1) + " was rolled " + (100*counter[i]/n.length) +  " percent of the time.");
		}
	}

	private static void rollDice(int[] n) {
		
		System.out.println("Roll Dice Method");
		for(int i = 0; i < n.length; i++){
			
			int rollOne = (int) (Math.random()*6) + 1;
			int rollTwo = (int) (Math.random()*6) + 1;
			n[i] = rollOne + rollTwo;
			
		}
		 
		
	}

	private static void randomize(int[] n) {
		
		System.out.println("Randomize Method");
		for(int i = 0; i < n.length; i++){
			n[i] = (int)(Math.random()*n.length) + 1;
		}
		
	}

	private static void populate(int[] n) {
		
		System.out.println("Populate Method");
		for(int i = 0; i < n.length; i++){
			n[i] = i + 1;
		}
		
	}

	private static void print(int[] n) {
		
		for(int i = 0; i < n.length; i++){
			System.out.println(n[i]);
		}
		
	}

	public static void demonstratePassByValue(){
		
		String[] someStrings = new String[1000];
		standardPopulate(someStrings);
		String s = someStrings[999];
		makeSpecial(s);
		someStrings[999] = getASpecialString();
		print(someStrings);
		
	}
	
	private static String getASpecialString() {
		String s = "THIS STRING IS SPECIAL";
		return s;
	}

	private static void makeSpecial(String s) {
		s = "THIS STRING IS SPECIAL";
	}

	private static void print(String[] s) {
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i]);
		}
		
	}

	private static void standardPopulate(String[] s) {
		for(int i = 0; i < s.length; i++){
			s[i] = "String #" + (i + 1);
		}
	}

	
	
	public static void initializingArraysExample(){
		
		//two different ways to instatiate an array
		boolean[] boos1 = new boolean[3]; //automatically all false until set to true
		//this can ONLY be done at the declaration because it sets size AND content:
		//boolean[] boos2 = {false, false, false};
		
		//this does not work:
		//boos3 = {false, true, true};
		
		//this is all that will work:
		boos3 = new boolean[3];
		
		//two ways of iterating through an array:
		/*
		 * Standard FOR Loop:
		 * 		The index is inporatant to keep track of
		 * 		You need to customize the order
		 */
		for(int i = 0; i < boos1.length; i++){
			System.out.println(boos1[i]);
		}
		/*
		 * "FOR - EACH" LOOP:
		 * 		The index is not important
		 * 		You don't need to customize
		 * 		Automatically assigns a "handle"
		 *		Faster
		 */
		for(boolean b: boos1){
			System.out.println(b);
		}
		
		//OBJECT ARRAYS
		String[] someStrings1 = new String[3]; //will give you null
		//You can do this to instantiate the elements
		someStrings1[0] = "a";
		someStrings1[1] = "b";
		someStrings1[2] = "c";
		//...but it is repetitive
		//String[] someStrings2 = {"a", "b", "c"};
		
		//let's try a loop to instantiate:
		for(int i = 0; i < someStrings1.length; i++){
			someStrings1[i] = "a new string";
		}
		//a loop to print it
		for(String s: someStrings1){
			System.out.println(s);
		}
		
		//Primitive Type[] : are "already" in the system, start at ZERO; cannot mix types
		//Object[] : unless initialized, start as NULL; different types of objects in a array of common superclass
		
	}

}
