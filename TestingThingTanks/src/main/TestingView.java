package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * . The view is responsible for displaying the information. The view includes
 * the list of colors and a panel for painting with the mouse. The panel is
 * implemented as a separate class so that the painting is relatively
 * flicker-free.
 * 
 * @author Tom Bylander
 */
public class TestingView extends JFrame {
	/**
	 * the model of this MVC example
	 */
	private Tank model;

	/**
	 * the JPanel where the user can paint
	 */
	private PaintPanel mousePanel;

	public TestingView(Tank model) {

		this.model = model;

		/* CENTER: Add a panel that the user can draw on. */
		mousePanel = new PaintPanel(model);
		mousePanel.setBackground(Color.BLACK);
		add(mousePanel, BorderLayout.CENTER);

	} // end constructor

	/**
	 * Register the controller as the listener to the JList and the MousePanel.
	 * 
	 * @param listener
	 */
	public void registerListener(TestingController listener) {
		mousePanel.addMouseMotionListener(listener);
		this.addKeyListener(listener);
	}

	public void paint(Graphics g) {
		super.paint(g);
		mousePanel.repaint();
	} // end method paint
}
