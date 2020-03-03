package pong;

import java.util.concurrent.TimeUnit;

public class Pong {
	
	PongFrame frame;
	PongPanel panel;
	
	public Pong() {
		panel = new PongPanel();
		frame = new PongFrame(panel);
	}
	
	public void runGame() {
		while (true) {
			this.panel.repaint();
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {}
		}
	}
	
	public static void main(String[] args) {
		Pong pong = new Pong();
		pong.runGame();
	}

}
