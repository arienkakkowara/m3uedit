package Frame;

import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Rectangle;

import Frame.ReadWrite.*;
import Frame.Mygui.*;


public class Frame extends ClearFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	
	private ClearFrame JFrameResult = null;
	
	private JLabel jLabelTitle = null;
	
	private JTextArea jTextAreaPath = null;

	private JButton jButtonEnd = null;
	private JButton jButtonStart = null;

	/**
	 * This method initializes jLabelTitle	
	 * 	
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLabelTitle(){
		if (jLabelTitle == null) {
			jLabelTitle = new JLabel();
			jLabelTitle.setBounds(90, 10, 106, 21);
			jLabelTitle.setText("M3U Converter");
			
		}
		return jLabelTitle;
	}

	/**
	 * This method initializes jTextAreaPath	
	 * 	
	 * @return javax.swing.JLabel
	 */
	private JTextArea getJTextAreaPath(){
		if (jTextAreaPath == null) {
			jTextAreaPath = new JTextArea();
			jTextAreaPath.setBounds(90, 10, 106, 21);
			
		}
		return jTextAreaPath;
	}
	
	/**
	 * This method initializes jButton_End	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEnd() {
		if (jButtonEnd == null) {
			jButtonEnd = new JButton();
			jButtonEnd.setBounds(new Rectangle(90, 55, 106, 21));
			jButtonEnd.setText("EXIT");
			jButtonEnd.setBackground(new java.awt.Color(0,0,0,0));
			jButtonEnd.setContentAreaFilled(true);
			jButtonEnd.setBorderPainted(false);
			jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return jButtonEnd;
	}

	/**
	 * This method initializes jButtonStart	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonStart() {
		if (jButtonStart == null) {
			jButtonStart = new JButton();
			jButtonStart.setBounds(new Rectangle(90, 85, 106, 21));
			jButtonStart.setText("START");
			jButtonStart.setContentAreaFilled(false);
			jButtonStart.setBorderPainted(false);
			jButtonStart.setBackground(new java.awt.Color(0,0,0,0));
			jButtonStart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return jButtonStart;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frame thisClass = new Frame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public Frame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Sample");
		
		// けす
		this.setUndecorated(true);
		
		// まんなか
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJLabelTitle(), null);
			jContentPane.add(getJButtonEnd(), null);
			jContentPane.add(getJButtonStart(), null);
		}
		return jContentPane;
	}
}