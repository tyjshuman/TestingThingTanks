package main;

import java.awt.Polygon;

public class Tank {

	final double length = 100;
	final double width = 60;

	final double cornerHeading = Math.atan(((double) width / 2)
			/ ((double) length / 2));

	final double pi = Math.PI;

	double heading;
	double x;
	double y;
	double[] FL;
	double[] FR;
	double[] RL;
	double[] RR;

	Polygon body;

	double diagonal;

	public Tank(double heading, double x, double y) {
		this.heading = heading;
		this.x = x;
		this.y = y;

		diagonal = dist(x, y, x - width / 2, y - length / 2);

	}

	private static double dist(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}

	public int[] getFL() {
		double xout = 0;
		double yout = 0;

		xout = x + Math.cos(heading + cornerHeading) * diagonal;
		yout = y + Math.sin(heading + cornerHeading) * diagonal;

		return new int[] { (int) xout, (int) yout };
	}

	public int[] getFR() {
		double xout = 0;
		double yout = 0;

		xout = x + Math.cos(heading - cornerHeading) * diagonal;
		yout = y + Math.sin(heading - cornerHeading) * diagonal;

		return new int[] { (int) xout, (int) yout };
	}

	public int[] getBL() {
		double xout = 0;
		double yout = 0;

		xout = x + Math.cos(heading + pi - cornerHeading) * diagonal;
		yout = y + Math.sin(heading + pi - cornerHeading) * diagonal;

		return new int[] { (int) xout, (int) yout };
	}

	public int[] getBR() {
		double xout = 0;
		double yout = 0;

		xout = x + Math.cos(heading + pi + cornerHeading) * diagonal;
		yout = y + Math.sin(heading + pi + cornerHeading) * diagonal;

		return new int[] { (int) xout, (int) yout };
	}

	public double getHeading() {
		return heading % pi / 2;
	}

	public double getActual(double d) {
		return d % 2 * pi;
	}

	private static double fixHeading(double d) {
		return (d % Math.PI / 2);
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	public void turnRight() {
		heading += pi / 50;
	}
	
	public void turnLeft() {
		heading -= pi / 50;
	}

	public Polygon getBody() {
		int xPoints[] = { getFL()[0], getFR()[0], getBR()[0], getBL()[0] };
		int yPoints[] = { getFL()[1], getFR()[1], getBR()[1], getBL()[1] };

		body = new Polygon(xPoints, yPoints, 4);

		return body;
	}
}
