package arrays;

public class Item {
	
	private String description;
	private boolean purchased;

	public Item(String description) {
		this.description = description;
		purchased = false;
	}
	
	public void setPurchased(boolean b){
		this.purchased = b;
	}
	
	public String getDescription(){
		return description;
	}

	public boolean isPurchased() {
		return purchased;
	}

}
