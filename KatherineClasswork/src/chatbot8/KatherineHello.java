package chatbot8;

public class KatherineHello implements Chatbot{
	
	private String helloResponse;
	private boolean inHelloLoop;
	
	private String[] calmResponses = {"We already said hello.", "Let's move the conversation along.",
									 "You said hello already, Did you forget?"};
	private String[] angryResponses = {"Okay, seriously stop saying hi.", "What is wrong with you and saying hello?"};
	
	private int helloCount;
	
	public KatherineHello(){
		helloCount = 0;
	}
	
	public void talk(){
		
		inHelloLoop = true;
		while(inHelloLoop){
			helloCount++;
			printResponse(); //helper method
			helloResponse = KatherineMain.promptInput();
			//negate use !
			if(!isTriggered(helloResponse)){
				inHelloLoop = false;
				KatherineMain.promptForever();
			}
			
		}
		
	}
	
	private void printResponse(){
		
		if(helloCount > 4){
			
			int responseSelection = (int) (Math.random()*angryResponses.length);
			KatherineMain.print(angryResponses[responseSelection]);
			
		}
		else{
			
			int responseSelection = (int) (Math.random()*calmResponses.length);
			KatherineMain.print(calmResponses[responseSelection]);
			
		}
		
	}
	
	public boolean isTriggered(String userInput){
		
		if(KatherineMain.findKeyWord(userInput, "hello", 0) >= 0){
			return true;
		}
		return false;
		
	}

}
