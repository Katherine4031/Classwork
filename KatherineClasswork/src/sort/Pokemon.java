package sort;

public class Pokemon {
	
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public Pokemon(String n, int l){
		hp = 100;
		this.name = n;
		this.level = l;
		this.poisoned = false;
	}
	
	public void iChooseYou(){
		System.out.println(name + ", " + name + "!");
	}
	
	public void attack(Pokemon target, Attack attack){
		if(Math.random() < .9){
			attack.attack(target);
			System.out.println("The attack hit");
		}
		else{
			System.out.println("The attack missed");
		}
	}
	
	public int getHP(){
		return hp;
	}
	
	public String getName(){
		return name;
	}
	
	public int setHP(int newHP){
		return newHP;
	}
	
	public void setPoisoned(boolean b){
		poisoned = true;
	}
	
	public void lapse(){
		if(poisoned){
			hp = hp - 15; //hp -= 15
		}
	}

}
