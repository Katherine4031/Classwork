package chatbot8;

public class KatherineSchool implements Chatbot{
	
	private boolean inSchoolLoop;
	private String schoolResponse;
	
	public void talk(){
		
		inSchoolLoop = true;
		while(inSchoolLoop){
			
			//static call on promptInput method from KatherineMain class
			schoolResponse = KatherineMain.promptInput();
			if(schoolResponse.indexOf("quit") >= 0){
				inSchoolLoop = false;
				KatherineMain.promptForever();
			}
			
		KatherineMain.print("That's my favorite part about school");
			
		}
		
	}
	
	public boolean isTriggered(String userInput){
		
		//String[] triggers = {"school", "class", "teacher"};
		//idea : create a for loop to iterate through your array of triggers
		
		if(KatherineMain.findKeyWord(userInput, "school", 0) >= 0){
			return true;
		}
		if(KatherineMain.findKeyWord(userInput, "class", 0) >= 0){
			return true;
		}
		return false;
		
	}

}
