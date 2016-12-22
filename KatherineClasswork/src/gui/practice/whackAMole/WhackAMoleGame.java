package gui.practice.whackAMole;

import gui.practice.GUIApplication;

public class WhackAMoleGame extends GUIApplication {

	public WhackAMoleGame() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		WhackAMoleScreen whams = new WhackAMoleScreen(getWidth(), getHeight());
		setScreen(whams);
	}

	public static void main(String[] args) {
		WhackAMoleGame game = new WhackAMoleGame();
		Thread app = new Thread(game);
		app.start();
	}

}
