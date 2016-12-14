package introduction;

public class Senior extends Student {

	String favoriteAnimal;
	
	public Senior(String name, String animal) {
		super(name); //constructs a student first
		this.favoriteAnimal = animal;
	}
	
	public void talk(){
		
		super.talk();
		System.out.println("...and I am a senior!");
		System.out.println("...who also loves " + favoriteAnimal + " >w<");
		
	}

}
