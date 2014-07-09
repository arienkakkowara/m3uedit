package Frame.Mygui;

import java.awt.Color;

import javax.swing.JFrame;

public class ClearFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public ClearFrame(){
		super();
		
		initalize();
		
		setBackground(new Color(200, 255, 255, 79));
	}
	
	public ClearFrame(int red, int green, int blue) {
		super();
		
		initalize();
		
		red = fixNum(red);
		green = fixNum(green);
		blue = fixNum(blue);
		
		setBackground(new Color(red, green, blue, 79));
	}
	
	private int isOutOfFF(int num) {
		if(num < 0)
			return -1;
		else if(255 < num)
			return 1;
		else
			return 0;
			
	}
	
	private int fixNum(int num) {
		switch(isOutOfFF(num)) {
		case -1:
			return 0;
		case 1:
			return 255;
		default:
			return num;
		}
	}
	
	private void initalize() {
		// けす
		this.setUndecorated(true);

		// まんなか
		this.setLocationRelativeTo(null);
	}
 }
