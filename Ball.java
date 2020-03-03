package pong;

import java.awt.Graphics;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ball {
	
	double speed;
	
	double xPos;
	double yPos;
	
	// 0 is left, 1 is right
	int xHeading;
	// 0 is up, 1 is down
	int yHeading;
	
	Random random;
	
	PongPanel pongPanel;
	
	public Ball(PongPanel pongPanel) {
		random = new Random();
		resetHeadings();
		this.xPos = 400;
		this.yPos = 300;
		this.speed = 1;
		this.pongPanel = pongPanel;
	}
	
	public void resetHeadings() {
		this.xHeading = random.nextInt(1);
		this.yHeading = random.nextInt(2);
	}
	
	// Brings the ball back to the center of the screen.
	public void reset(int sideJustScored) {
		this.xPos = 400;
		this.yPos = 300;
		// resetHeadings would be used, but the ball is heading towards the other side.
		this.xHeading = random.nextInt(2);
		this.yHeading = sideJustScored == 1 ? 0 : 1;
	}
	
	public void move() {
		
		// Calculations for bouncing off the top and bottom
		if (this.yPos > 570 | this.yPos < 30) {
			this.yHeading = this.yHeading == 0 ? 1 : 0;
		}
		
		// Calculations for being off the sides
		try {
			if (this.xPos > 1000) {
				this.pongPanel.score1++;
				this.reset(1);
				TimeUnit.SECONDS.sleep(2);
			} else if (this.xPos < 0) {
				this.pongPanel.score2++;
				this.reset(2);
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {}
		
		// Seeing if any paddle collisions have happened
		
		// First, the left side
		if (this.xPos > 80 && this.xPos < 100) {
			 if (this.yPos > this.pongPanel.paddle1.y - 40 && this.yPos < this.pongPanel.paddle1.y + 40) {
				 this.xPos = 111;
				 this.xHeading = 1;
			 }
		} else if (this.xPos > 900 && this.xPos < 920) {
			if (this.yPos > this.pongPanel.paddle2.y - 40 && this.yPos < this.pongPanel.paddle2.y + 40) {
				 this.xPos = 889;
				 this.xHeading = 0;
			}
		}
		
		// Movement
		if (xHeading == 0) {
			this.xPos -= speed;
		} else {
			this.xPos += speed;
		}
		
		if (yHeading == 0) {
			this.yPos -= speed;
		} else {
			this.yPos += speed;
		}
		
		// Increment the speed by a tiny amount
		speed += 0.001;
	}
	
	public void draw(Graphics g) {
		this.move();
		g.fillOval((int)xPos-10, (int)yPos-10, 20, 20);
	}

}
