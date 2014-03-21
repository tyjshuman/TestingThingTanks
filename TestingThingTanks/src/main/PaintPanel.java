package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	/**
	 * The model of this MVC example (it stores the points)
	 */
	private Tank model;
	private Obstacle obs1;

	/**
	 * Store the model that holds the points to be drawn.
	 * 
	 * @param model
	 */
	public PaintPanel(Tank model) {
		this.model = model;
		obs1 = new TL(100, 100);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.drawPolygon(model.getBody());
		g.drawPolygon(obs1.getBody());
	}
}
