package edu.ycp.cs320.movethesquare.model;

public class Circle {
	private double x, y;
	double diameter;

	public double getX() {
		return x;
	}

	public void setX(double d) {
		this.x = d;
	}

	public double getY() {
		return y;
	}

	public void setY(double d) {
		this.y = d;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = 1.5 * diameter;
	}
	
}
