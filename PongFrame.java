package pong;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class PongFrame extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 578935174373L;
	
	PongPanel pongPanel;
	
	public PongFrame(PongPanel pongPanel) {
		super("Pong");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setPreferredSize(new Dimension(1000, 600));
		super.pack();
		addKeyListener(this);
		this.pongPanel = pongPanel;
		this.add(this.pongPanel);
		super.setVisible(true);
	}
	
	public void keyPressed(KeyEvent keyEvent) {
		int key = keyEvent.getKeyCode();
		
		if (key == KeyEvent.VK_ESCAPE) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (key == KeyEvent.VK_W) {
			this.pongPanel.paddle1.up();
		} else if (key == KeyEvent.VK_S) {
			this.pongPanel.paddle1.down();
		} else if (key == KeyEvent.VK_UP) {
			this.pongPanel.paddle2.up();
		} else if (key == KeyEvent.VK_DOWN) {
			this.pongPanel.paddle2.down();
		}	
	}
	
	public void keyTyped(KeyEvent keyEvent) {}
	
	public void keyReleased(KeyEvent keyEvent) {}

}
