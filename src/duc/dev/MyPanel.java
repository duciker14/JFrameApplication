package duc.dev;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import duc.dev.components.MyRect;

public class MyPanel extends JPanel {
	private final int SPACE = 160;
	private MyRect rects[];
	private int originX = 100;
	private int originY = 120;
	public MyPanel(int[] valueSorts) {
		// TODO Auto-generated constructor stub
		rects = new MyRect[valueSorts.length];
		for(int i=0; i < valueSorts.length; i++) {
			rects[i] = new MyRect(originX + SPACE * i, originY, valueSorts[i]);
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.drawString("BLAH", 20, 20);
		for (MyRect myRect : rects) {
			myRect.draw(g2);
		}
	}
	
	public void setMoveRect(long timeDelay) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thread is running");
				while(true) {
					for (MyRect myRect : rects) {
						if(myRect.x > 1000)
							myRect.x = 0;
						myRect.x += 20;
					}
					try {
						Thread.sleep(timeDelay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					repaint();
				}
				
			}
		}).start();
	}

	enum DIRECT {UP, LEFT, RIGHT, DOWN};
	DIRECT direct = DIRECT.UP;
	
	public void setSwapRects(MyRect rect1, MyRect rect2) {

		int rX1 = rect1.x;
		int rX2 = rect2.x;
		
		int rY1 = rect1.y;
		int rY2 = rect2.y;
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thread is running");
				while(true) {
					if(direct == DIRECT.UP) {
						if(rect1.y > 0) {
							rect1.y -= 15;
							rect2.y -= 15;
						}else {
							direct = DIRECT.LEFT;
						}
					}
					if(direct == DIRECT.LEFT) {
						if(rX1 < rX2) {
							if(rect1.x < rX2) {
								rect1.x += 15;
								rect2.x -= 15;
							}else {
								direct = DIRECT.DOWN;
							}
						}else {
							if(rect1.x > rX2) {
								rect1.x -= 15;
								rect2.x += 15;
							}
						}
					}
					
					if(direct == DIRECT.DOWN) {
						System.out.println(rect1.y);
						System.out.println(rY1);
						if(rect1.y < rY1) {
							rect1.y += 15;
							rect2.y += 15;
						}
					}
					
					
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();
				}
				
			}
		}).start();
	}
	
	public void test() {
		setSwapRects(rects[1], rects[5]);
	}
}
