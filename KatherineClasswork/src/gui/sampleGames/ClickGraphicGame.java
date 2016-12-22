package gui.sampleGames;

import gui.practice.GUIApplication;

public class ClickGraphicGame extends GUIApplication {
	
	public static void main(String[] args){
		ClickGraphicGame game = new ClickGraphicGame();
		Thread app = new Thread(game);
		app.start();
	}

	@Override
	public void initScreen() {
		ClickableGraphicScreen cgs = new ClickableGraphicScreen(getWidth(), getHeight());
		setScreen(cgs);
	}

}
