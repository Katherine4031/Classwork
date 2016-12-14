package introduction;

public class Junior extends Student {
	
	String score;

	public Junior(String name, String average) {
		super(name);
		this.score = average;
	}

	public void talk(){
		
		super.talk();
		System.out.println("...and I think Software is fun!");
		System.out.println("...mostly because I have a " + score + " average :D");
		
	}
	
}
