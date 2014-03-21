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

	/**
	 * Store the model that holds the points to be drawn.
	 * 
	 * @param model
	 */
	public PaintPanel(Tank model) {
		this.model = model;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.drawLine(model.getX(), model.getY(), model.getFL()[0],
				model.getFL()[1]);

		g.setColor(Color.red);
		g.drawLine(model.getX(), model.getY(), model.getFR()[0],
				model.getFR()[1]);
		g.setColor(Color.green);
		g.drawLine(model.getX(), model.getY(), model.getBL()[0],
				model.getBL()[1]);
		g.setColor(Color.black);
		g.drawLine(model.getX(), model.getY(), model.getBR()[0],
				model.getBR()[1]);

		g.drawPolygon(model.getBody());

	}
}
