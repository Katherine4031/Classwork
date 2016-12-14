package caveExplorer;

public class GameStartEvent implements Playable {
	
	private static final String[] SEQUENCE_1 = {"Hi, I can see that you're not from around here. "
											  + "Do you like puzzles? "};
	private static final String[] SEQUENCE_2 = {"You are going to have so much fun playing my 2-D games. "
											  + "Here, take this map. "};

	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Come on. Tell me you like puzzles.");
		while(CaveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			CaveExplorer.print("C'mon! You know you like puzzles, Say yes!");
		}
		readSequence(SEQUENCE_2);
		CaveExplorer.inventory.setHasMap(true);
	}
	
	public static void readSequence(String[] seq){
		for(String s: seq){
			CaveExplorer.print(s);
			CaveExplorer.print("- - - Press Enter - - -");
			CaveExplorer.in.nextLine();
		}
	}

}
