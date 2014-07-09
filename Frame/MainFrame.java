package Frame;

import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseEvent;
import java.io.File;

import Frame.Mygui.*;
import Frame.ReadWrite.*;

public class MainFrame extends ClearFrame {
	
	/* 定数 */
	private static final long serialVersionUID = 1L;
	private static final LineBorder BUTTONMODE = new LineBorder(new java.awt.Color(31,31,227,79), 2);
	private static final LineBorder BUTTONMODE2 = new LineBorder(new java.awt.Color(227,31,31,79), 2);
	private static final Font TITLE = new Font("Arial", Font.BOLD, 20);
	private static final int LIST = 1;
	private static final int MUSIC = -1;
	private static final int BOTH = 0;

	/* クラス変数 */

	// guiparts
	
	private JPanel jContentPane = null;
	private JPanel jInfoPane = null;
	private JTextArea jTextAreaPath = null;
	private ClearFrame info = null;
	private Label title = null;
	private Label start = null;
	private Label exit = null;
	private Label ok = null;
	private Label explain = null;
	private Label result = null;

	// basicvalue
	
	private boolean click;
	private int mode;

	
	public MainFrame() {
		super();
		initialize();
		click = true;
		mode = LIST;
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Sample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		new DropTarget(this.getLabelTitle(), new MyDropTarget(this));
		
		info = new ClearFrame();
		info.setSize(300, 200);
		info.setContentPane(getJInfoPane());
		info.setVisible(false);
	}
	
	/**
	 * This method initializes jTextAreaPath
	 * 
	 * @return javax.swing.JLabel
	 */
	private Label getLabelExplain() {
		if (explain == null) {
			explain = new Label(100, 80, 200, 22, "Android's name");
			explain.setLeft();
			explain.addMouseListener(new java.awt.event.MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
		}
		return explain;
	}

	/**
	 * This method initializes jTextAreaPath
	 * 
	 * @return javax.swing.JLabel
	 */
	private JTextArea getJTextAreaPath() {
		if (jTextAreaPath == null) {
			jTextAreaPath = new JTextArea();
			jTextAreaPath.setBounds(90, 100, 120, 21);
			jTextAreaPath.setOpaque(false);
			jTextAreaPath.setBorder(BUTTONMODE2);
		}
		return jTextAreaPath;
	}
	
	/**
	 * This method initializes jButton_End
	 * 
	 * @return javax.swing.JLabel
	 */
	private Label getLabelExit() {
		if (exit == null) {
			exit = new Label(100, 125, 100, 22, "EXIT", BUTTONMODE);
			exit.addMouseListener(new java.awt.event.MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(isMainClickable()) {
						System.exit(0);
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
		}
		return exit;
	}

	private Label getLabelStart() {
		if (start == null) {
			start = new Label(100, 55, 100, 22, "START", BUTTONMODE);
			start.addMouseListener(new java.awt.event.MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(isMainClickable()) {
						info.setVisible(true);

						Lock();
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
		}
		
		return start;
	}
	
	private Label getLabelTitle() {
		if (title == null) {
			title = new Label(70, 20, 160, 21, "Test Window", TITLE);
		}
		
		return title;
	}
	
	private Label getLabelOk() {
		if (ok == null) {
			ok = new Label(100, 125, 100, 22, "OK", BUTTONMODE);
			ok.addMouseListener(new java.awt.event.MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					info.setVisible(false);
					unLock();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
		}
		return ok;
	}
	
	private Label getLabelResult() {
		if (result == null) {
			result = new Label(30, 25, 240, 22, "hoge");
			result.addMouseListener(new java.awt.event.MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
		}
		return result;
	}
	/**
	 * コンテントパネルのゲッター。nulliならnitalizeするよ
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getLabelTitle(), null);
			jContentPane.add(getLabelExit(), null);
			jContentPane.add(getLabelStart(), null);
			jContentPane.add(getLabelExplain(), null);
			jContentPane.add(getJTextAreaPath(), null);
		}
		return jContentPane;
	}
	
	/**
	 * ダイアログもどきのゲッター。nullならinitalizeするよ
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJInfoPane() {
		if (jInfoPane == null) {
			jInfoPane = new JPanel();
			jInfoPane.setLayout(null);
			jInfoPane.add(getLabelOk(), null);
			jInfoPane.add(getLabelResult(), null);
		}
		return jInfoPane;
	}
	
	private void Lock() {
		//start.setEnabled(false);
		//exit.setEnabled(false);
		click = false;
	}
	
	private void unLock() {
		//start.setEnabled(true);
		//exit.setEnabled(true);
		click = true;
	}
	
	public boolean isMainClickable(){
		return click;
	}
	
	/**
	 * ダイアログもどきを表示するよ
	 * メインフレームには黙ってもらうよ
	 */
	public void showInfo() {
		info.setVisible(true);
		Lock();
	}
	
	/**
	 * ダイアログもどきを隠すよ
	 * メインフレームには出てきてもらうよ
	 */
	public void hideInfo() {
		info.setVisible(false);
		unLock();
	}
	
	/**
	 * ファイルがドラッグ＆ドロップされた時の挙動だよ
	 * 
	 * @param java.util.List<java.io.File>
	 */
	public void dropOnLabel(java.util.List<File> filelist) {
		/*
		StringBuilder destpath, trim, newname;
		int pos;
		for(File f : filelist) {
			trim = new StringBuilder(f.getName());
			newname = new StringBuilder(trim).insert(trim.lastIndexOf("."), "2");
			destpath = new StringBuilder(f.getPath());
			pos = destpath.toString().lastIndexOf(trim.toString());
			destpath.delete(pos, pos + trim.length());
			destpath.insert(pos, newname);
			ReadWrite.copyTransfer(f.getPath(), destpath.toString());
			getLabelResult().setText(f.getPath());
		}
		*/
		
		for(File f : filelist) {
			if(f.toString().endsWith("m3u8"))
				ReadWrite.ListTransfer(f, getJTextAreaPath().getText());
		}
		showInfo();
		
	}
	
	/**
	 * mainメソッド。一応テストするよ
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

 }