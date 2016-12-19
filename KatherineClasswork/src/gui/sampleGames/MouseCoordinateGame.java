package gui.sampleGames;

import gui.interfaces.GUIApplication;

public class MouseCoordinateGame extends GUIApplication{
	
	public static MouseCoordinateGame game;
	public static MyScreen myScreen;
	
	public MouseCoordinateGame(int x, int y){
		
	}
	
	public static void main(String[] args){
		game = new MouseCoordinateGame(500, 500);
		Thread app = new Thread(game);
		app.start();
	}

	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		
	}

}
