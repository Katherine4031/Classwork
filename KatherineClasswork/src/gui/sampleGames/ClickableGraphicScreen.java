package gui.sampleGames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.ClickableGraphic;
import gui.components.Visible;
import gui.practice.Screen;

public class ClickableGraphicScreen extends Screen implements MouseListener{
	
	private ClickableGraphic cat;

	public ClickableGraphicScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		cat = new ClickableGraphic(20, 20, 0.2, "resources/sampleImages/ba80d850bc89de31d0dc61a8f6bdb334.jpg");
		cat.setAction(new Action(){

			@Override
			public void act() {
				cat.setX(cat.getX() + 10);
			}
			
		});
		
		viewObjects.add(cat);
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		if(cat.isHovered(m.getX(), m.getY())){
			cat.act();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public MouseListener getMouseListener(){
		return this;
	}

}
