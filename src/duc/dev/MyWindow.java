package duc.dev;
import javax.swing.JFrame;

import duc.dev.components.MyRect;

public class MyWindow extends JFrame {
	private final int WIDTH = 600;
	private final int HEIGHT = 500;
	int valueSorts[] = {1, 6, 9, 7, 6, 5};
	
	public MyWindow() {
		// TODO Auto-generated constructor stub
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		initGUI();
	}
	
	private void initGUI() {			
		MyPanel myPanel = new MyPanel(valueSorts);
		add(myPanel);
		myPanel.test();
	}
}
