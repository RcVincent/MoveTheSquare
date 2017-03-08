package edu.ycp.cs320.movethesquare.model;

public class Circle {
	private double x, y;
	double diameter, height;

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

	public void setDiameter(double diameter) {
		this.diameter = 1.5 * diameter;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double diameter) {
		this.height = 1.5 * height;
	}
	
	
}
