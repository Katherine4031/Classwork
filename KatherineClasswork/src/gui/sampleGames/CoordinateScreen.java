package gui.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import gui.components.*;
import gui.interfaces.*;

public class CoordinateScreen extends Screen implements MouseMotionListener{
	
	private TextLabel label;
	private TextArea paragraph;
	private Button button;

	public CoordinateScreen(int width, int height) {
		super(width, height);
		label = new TextLabel(40, 50, width - 80, 40, "");
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		label = new TextLabel(40, 45, 760, 40, "");
		paragraph = new TextArea(40, 85, 550, 500, "This is a whole paragraph. Notice how as the paragraph "
								+ "gets to the edge of the page, a new line is created.");
		button = new Button(40, 200, 80, 40, "Button", new Color(100, 100, 250), new Action(){
			public void act(){
				
			}
		});
		viewObjects.add(label);
		viewObjects.add(paragraph);
		viewObjects.add(button);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent m) {
		label.setText("Mouse at " + m.getX() + ", " + m.getY());
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

}
