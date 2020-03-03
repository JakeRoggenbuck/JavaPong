package pong;

import java.awt.Graphics;

public class Paddle {
	
	// Its position
	int x;
	int y;
	
	public Paddle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Paddle is 20 wide, 80 high
	public void draw(Graphics g) {
		g.fillRect(this.x - 10, this.y - 40, 20, 80);
	}
	
	// Up is minus because Java coordinates
	
	public void up() {
		this.y -= 20;
	}
	
	public void down() {
		this.y += 20;
	}

}
