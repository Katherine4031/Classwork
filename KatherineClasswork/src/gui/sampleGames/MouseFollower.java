package gui.sampleGames;

import gui.components.*;
import gui.interfaces.*;

public class MouseFollower extends GUIApplication {
	
	private CoordinateScreen coordScreen;
	public static MyScreen myScreen;
	public static MouseFollower game;
	
	public static void main(String[] args){
		GUIApplication game = new MouseFollower();
		Thread app = new Thread(game);
		app.start();
	}

	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		coordScreen = new CoordinateScreen(getWidth(), getHeight());
		setScreen(coordScreen);
	}

}
