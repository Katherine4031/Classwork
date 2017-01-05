package gui.practice.simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.ClickableScreen;

public class SimonScreenKatherine extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private ButtonInterfaceKatherine[] button;
	private ProgressInterfaceKatherine progress;
	private ArrayList<MoveInterfaceKatherine> sequence;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenKatherine(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceKatherine>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceKatherine randomMove() {
		Button b;
		int rndIdx = (int)(Math.random()*button.length);
		while(rndIdx == lastSelectedButton){
			rndIdx = (int)(Math.random()*button.length);
		}
		return getMove(b);
	}

	private ProgressInterfaceKatherine getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 5;
		Color[] colors = {Color.blue, Color.red, Color.yellow, Color.green, Color.black};
		for(int i = 0; i < numberOfButtons; i++){
			ButtonInterfaceKatherine b = getAButton();
			//circle
			b.setColor(colors[i]);
			b.setX(0);
			b.setY(0);
		}
	}

	private ButtonInterfaceKatherine getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
