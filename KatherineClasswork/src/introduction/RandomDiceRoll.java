package introduction;

public class RandomDiceRoll {

	public static void main(String[] args) {
		
		int[] results = new int[6]; 
		
		//declare variable, logic test, increment
		int totalRolls = 10000;
		for(int index = 0; index < 10000; index++){
			
			int result = rollUnfairDie();
			System.out.println("Roll # " + (index + 1) + ": " + result); //need parenthesis so index + 1 does not concat
			results[result - 1] ++;
			
		}
		
		//print the results
		for(int i = 0; i < 6; i++){
			
			double percentage = ((int) (1000*(double)results[i]/totalRolls))/10.0;
			System.out.println((i + 1) + " appeared " + percentage + " %.");
			
		}

	}
	
	//return 1,2,3,4,5,6 with equal probability
	public static int rollFairDie(){
		
		double rand = Math.random(); //returns double (0, 1)
		int roll = (int) (6*rand); //[0, 5]
		roll++; //[1, 6]
		return roll;
		
	}
	
	public static int rollUnfairDie(){
		
		double rand = Math.random();
		int roll = (int) (6*rand); 
		roll++; 
		
		if(roll >= 1 && roll <= 3){
			double num = Math.random();
			int rollAgain = (int) (6*num);
			rollAgain++;
			return rollAgain;
		}
		else{
			return roll;
		}
		
	}

}
