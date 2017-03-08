package edu.ycp.cs320.movethesquare.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import edu.ycp.cs320.movethesquare.controllers.GameController;
import edu.ycp.cs320.movethesquare.model.Circle;
import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameView extends JPanel {
	//private static final Color MIDNIGHT_BLUE = new Color(25, 25, 112);
	private static final Color MY_SOUL = new Color(0, 0, 0);
	private Game model;
	private GameController controller;
	private Timer timer;
	
	public GameView(Game model) {
		this.model = model;
		setPreferredSize(new Dimension((int) model.getWidth(), (int)model.getHeight()));
		setBackground(MY_SOUL);

		this.timer = new Timer(1000 / 30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleTimerTick();
			}
		});
	}
	
	public void setController(GameController controller) {
		this.controller = controller;
	}
	
	public void startAnimation() {
		timer.start();
	}

	protected void handleTimerTick() {
		if (controller == null) {
			return;
		}
		Square square = model.getSquare();
		Circle circle = model.getCircle();
		
		Point mouseLoc = getMousePosition();
		if (mouseLoc != null) {
			controller.computeSquareMoveDirection(model, square, mouseLoc.getX(), mouseLoc.getY());
			controller.computeCircleMoveDirection(model, circle, mouseLoc.getX(), mouseLoc.getY());
		}
		controller.moveSquare(model, square);
		controller.moveCircle(model, circle);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		
		g.setColor(Color.ORANGE);

		Square square = model.getSquare();
		
		g.fillRect((int) square.getX(), (int) square.getY(), (int) square.getWidth(), (int) square.getHeight());
		
		g.setColor(Color.CYAN);
		
		Circle circle = model.getCircle();
		g.fillOval((int) circle.getX(), (int) circle.getY(), (int) circle.getDiameter(), (int) circle.getHeight());
		
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Game model = new Game();
				model.setWidth(640.0);
				model.setHeight(480.0);
				
				Square square = new Square();
				square.setX(200.0);
				square.setY(120.0);
				square.setWidth(30.0);
				square.setHeight(30.0);
				model.setSquare(square);
				
				Circle circle = new Circle();
				circle.setX(400);
				circle.setY(320);
				circle.setDiameter(30);
				circle.setHeight(30);
				model.setCircle(circle);
				
				
				GameController controller = new GameController();
				
				GameView view = new GameView(model);
				view.setController(controller);
				
				JFrame frame = new JFrame("Move the Square!");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(view);
				frame.pack();
				frame.setVisible(true);
				
				view.startAnimation();
			}
		});
	}
}
