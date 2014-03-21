package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;

/**
 * This demonstrates the controller in a model-view-controller pattern. Adapted
 * from Figures 14.23 and 14.34.
 * 
 * @author Tom Bylander
 */
public class TestingController implements MouseMotionListener, KeyListener {
	/**
	 * The model of this MVC example
	 */
	private Tank model;

	/**
	 * The view of this MVC example
	 */
	private TestingView view;

	public TestingController(Tank model, TestingView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Add a point to the model when the user drags the mouse, and repaint the
	 * window. Need more logic to draw solid lines.
	 */
	public void mouseDragged(MouseEvent event) {

	} // end method mouseDragged

	/**
	 * This method doesn't do anything, but it needs to be here to implement
	 * MouseMotionListener.
	 */
	public void mouseMoved(MouseEvent event) {
		// this method intentionally left blank
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == arg0.VK_LEFT)
			model.turnLeft();
		if (arg0.getKeyCode() == arg0.VK_RIGHT)
			model.turnRight();
		if (arg0.getKeyCode() == arg0.VK_UP)
			model.moveForward();
		if (arg0.getKeyCode() == arg0.VK_DOWN)
			model.moveBackward();
		view.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}
