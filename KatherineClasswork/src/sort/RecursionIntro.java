package sort;

public class RecursionIntro {
	
	private static int product = 1;

	public static void main(String[] args) {
		System.out.println("Using a FOR loop: ");
		for(int i = 0; i < 5; i++){
			System.out.println("Hello world! x" + i);
		}
		
		System.out.println("WITHOUT using a FOR loop: ");
		forLoop(5, new Action(){
			private int value = 0;
			
			public void act(){
				System.out.println("Hello world! x" + value);
				value++;
			}
		});
		
		factorial(5);
		
		hanoiSolution(3, "A", "B", "C");
		
		int n = 10;
		System.out.println("The " + n + "th Fibonacci is " + fibonacci(n));
	}

	private static void forLoop(int i, Action action) {
		if(i <= 0){
			//base case
			return;
		}
		else{
			//standard action
			action.act();
			//recursive call
			forLoop(i - 1, action);
		}
	}
	
	public static int factorial(int x){
		
		//for loop method
//		for(int i = x; i > 0; i--){
//			product = product * i;
//		}
//		System.out.println(product);
		//return product;
		
		
		//recursion method
		if(x <= 1){
			System.out.println(product);
			return product;
		}
		else{
			product = product * x;
			factorial(x - 1);
		}
		return 1;
	}
	
	private static int count = 1;
	
	public static void print(String s){
		System.out.println("Move #" + count + ":" + s);
	}
	
	public static void hanoiSolution(int numberOfDiscs, String startPeg, String midPeg, String endPeg){
		if(numberOfDiscs <= 1){
			System.out.println("Move " + startPeg + " to " + endPeg);
		}
		else{
			System.out.println("In order to move " + numberOfDiscs + " over to peg " + endPeg + " we must move "
					         + (numberOfDiscs - 1) + " over to peg " + midPeg + " first.");
			hanoiSolution(numberOfDiscs - 1, startPeg, endPeg, midPeg);
			hanoiSolution(1, startPeg, midPeg, endPeg);
			hanoiSolution(numberOfDiscs - 1, midPeg, startPeg, endPeg);
		}
	}
	
	private static int fibonacci(int n) {
		if(n <= 1){
			return 1;
		}
		else{
			int previous = fibonacci(n - 1);
			System.out.println("Before we find fibonacci " + n + " we need to find fibonacci " + (n - 1) 
					         + ", which is " + previous);
			int beforePrevious = fibonacci(n - 2);
			return previous + beforePrevious;
		}
	}
	
}
