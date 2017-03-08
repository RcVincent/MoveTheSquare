package edu.ycp.cs320.movethesquare.model;

public class Game {
	public static final double MOVE_DIST = 2.0; // x/y distance square moves each tick 
	private double width, height, diameter;
	private Square square;
	private double squareDx, circleDx;
	private double squareDy, circleDy;
	private Circle circle;
	public Game() {
		
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public Square getSquare() {
		return square;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setSquareDx(double squareDx) {
		this.squareDx = 1.25 * squareDx;
	}
	
	public double getSquareDx() {
		return squareDx;
	}
	
	public void setSquareDy(double squareDy) {
		this.squareDy = 1.25 * squareDy;
	}
	
	public double getSquareDy() {
		return squareDy;
	}

	
	/*** Beginning of circle methods ***/
	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getCircleDx() {
		return circleDx;
	}

	public void setCircleDx(double circleDx) {
		this.circleDx = 1.25 * circleDx;
	}

	public double getCircleDy() {
		return circleDy;
	}

	public void setCircleDy(double circleDy) {
		this.circleDy = 1.25 * circleDy;
	}
	
	
	
}
