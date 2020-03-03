package pong;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PongPanel extends JPanel {
	
	private static final long serialVersionUID = 346758267586L;
	
	Paddle paddle1;
	Paddle paddle2;
	
	Ball ball;
	
	int score1;
	int score2;
	
	public PongPanel() {
		super();
		this.paddle1 = new Paddle(100, 300);
		this.paddle2 = new Paddle(900, 300);
		this.ball = new Ball(this);
		this.score1 = 0;
		this.score2 = 0;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Clears the screen
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 600);
		
		// Draws paddles and ball
		g.setColor(Color.WHITE);
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		
		// Drawing the score on the screen
		g.drawString("Player One Score: " + score1, 100, 50);
		g.drawString("Player Two Score: " + score2, 800, 50);
	}

}
