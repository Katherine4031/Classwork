package introduction;

public class OOPExample {
	
	public static void main(String[] args) {
		
		Student jillian = new Senior("Jillian", "Dogs");
		jillian.talk();
		
		Student joseph = new Junior("Joseph", "99");
		joseph.talk();
		
		Student jordan = new Freshman("Jordan");
		jordan.talk();
		
	}

}
