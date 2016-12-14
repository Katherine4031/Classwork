package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Button extends TextLabel {
	
	private Color color;
	private Action action;

	public Button(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text);
		
		this.color = color;
		this.action = action;
	}
	
	public void update(Graphics2D g) {
		g = clear(); //clears image and gets new graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		//draw all visible components
		if(getText() != null){
			g.drawRoundRect(25, 25, 150, 100, 25, 25);
			g.fillRoundRect(25, 25, 150, 100, 25, 25);
			
		}
	}
	
}