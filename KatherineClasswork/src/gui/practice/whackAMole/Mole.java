package gui.practice.whackAMole;

import gui.components.ClickableGraphic;

public class Mole extends ClickableGraphic implements MoleInterface {
	
	private int appearanceTime;

	public Mole(int x, int y) {
		super(x, y, 0.5, "resources/sampleImages/Mole.png");
	}

	@Override
	public int getAppearanceTime() {
		return appearanceTime;
	}

	@Override
	public void setAppearanceTime(int i) {
		this.appearanceTime = i;
	}

}
