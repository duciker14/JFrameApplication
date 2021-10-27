package duc.dev.components;

import java.awt.Color;
import java.awt.Graphics2D;

public class MyRect {
	private final int WIDTH = 50;
	private final int HEIGHT = 50;
	
	public int x;
	public int y;
	
	public int value;
	public MyRect(int x, int y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	public void draw(Graphics2D g2) {
		g2.setBackground(Color.GREEN);
		g2.fillRect(x, y, WIDTH, HEIGHT);
	}
}
