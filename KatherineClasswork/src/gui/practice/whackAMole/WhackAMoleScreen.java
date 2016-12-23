package gui.practice.whackAMole;

import java.util.ArrayList;
import java.util.List;

import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.ClickableScreen;

public class WhackAMoleScreen extends ClickableScreen implements Runnable {
	
	 private ArrayList<MoleInterface> moles;
	 private PlayerInterface player;
	 private TextLabel label;
	 private TextLabel timeLabel;
	 private double timeLeft;

	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		timeLeft = 60.0;
		Thread play = new Thread(this);
		play.start();
	}
	
	@Override
	public void initAllObjects(List<Visible> visible) {
		// TODO Auto-generated method stub
		moles = new ArrayList<MoleInterface>();
		player = getAPlayer();
		label = new TextLabel(getWidth()/2 - 60,getHeight()/2 - 30,760,40,"Ready...");
		timeLabel = new TextLabel(getWidth()/2 - 60,40,760,40,"");
		
		addObject(label);
		addObject(player);
		addObject(timeLabel);
	}

	/**
	*to implement later, after Character Team implements Player interface
	*return null is a placeholder 
	*because early in the game design process, 
	*the player isn't designed yet
	*/
	private PlayerInterface getAPlayer() {
		return new Player(20, 20);
	}

	/**
	*to implement later, after Character Team implements Mole interface
	*return null is a placeholder 
	*because early in the game design process, 
	*the enemies aren't designed yet
	*/
	private MoleInterface getAMole() {
		return new Mole((int)(getWidth() * Math.random() - 100), (int)(getHeight() * Math.random());
	}
	
	private void changeText(String s){
		try{
			Thread.sleep(1000);
			label.setText(s);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		changeText("Set...");
		changeText("Go!");
		changeText("");
		
		timeLabel.setText("" + timeLeft);
		while(timeLeft > 0){
			//frame updates every 100ms
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			timeLeft -= 0.1;
			timeLabel.setText("" + (int)(timeLeft * 10)/10.0);
		}
		disappearMole();
		addNewMoles();
	}

	private void addNewMoles() {
		//probability of mole appearing 
		//depends on time left
		double probability = 0.2 + 0.1*(30.0 - timeLeft);
		if(Math.random() < probability){
			MoleInterface mole = getAMole();
			//between 0.5 and 2.5 seconds
			mole.setAppearanceTime((int)(500 + Math.random()*2000));
			mole.setAction(new Action(){
				public void act(){
					player.increaseScore(1);
					//remove mole from viewObjects
					remove(mole);
					//remove mole from database
					moles.remove(mole);
				}
			});
			//add mole to visible
			addObject(mole);
			//add mole to mole list
			moles.add(mole);
		}
	}

	private void disappearMole() {
		//each mole has a "clock"
				//when the clock counts  down to zero
				//it disappears
				for(int i = 0; i < moles.size(); i++){
					MoleInterface m = moles.get(i);
					m.setAppearanceTime(m.getAppearanceTime() - 100);
					if(m.getAppearanceTime() <= 0){
						//remove from viewObjects
						remove(m);
						//remove it from our mole database
						moles.remove(i);
						i--;
					}
				}
	}

	

}