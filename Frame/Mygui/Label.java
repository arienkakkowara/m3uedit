package Frame.Mygui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Label extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Label(int x, int y, int width, int height) {
		super();
		setBounds(x, y, width, height);
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setClearBack();
	}
	
	public Label(int x, int y, int width, int height,String text) {
		super();
		setBounds(x, y, width, height);
		setText(text);
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setClearBack();
	}
	
	public Label(int x, int y, int width, int height,String text, LineBorder lb) {
		super();
		setBounds(x, y, width, height);
		setText(text);
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setBorder(lb);
		setClearBack();
	}
	
	public Label(int x, int y, int width, int height,String text, Font f) {
		super();
		setBounds(x, y, width, height);
		setText(text);
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(f);
		setClearBack();
	}
	
	public String getSring() {
		return getText();
	}
	
	public void setString(String text) {
		setText(text);
	}
	
	public void setCenter() {
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
	}
	
	public void setLeft() {
		setHorizontalAlignment(JLabel.LEFT);
	}
	
	public void setClearBack() {
		setBackground(new java.awt.Color(0, 0, 0, 0));
	}
}
