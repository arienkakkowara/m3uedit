package Frame.Mygui;

import java.awt.Container;
import java.awt.dnd.DropTarget;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import Frame.MyDropTarget;

//メインのウィンドウ
public class DropTest extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;

	public static void main(String[] args) {
		DropTest win = new DropTest();
		win.pack();
		win.setVisible(true);
	}

	public DropTest() {
		super("DropTest:下の領域にファイルをドロップしてください");
		Container con = getContentPane();
		textArea = new JTextArea(10, 50);
		con.add(textArea);
		//new DropTarget(textArea, new MyDropTarget(this));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setFileNames(java.util.List<File> fileList) {
		StringBuilder sb = new StringBuilder();
		for (File file : fileList) {
			sb.append(file.getAbsolutePath()).append("\n");
		}
		textArea.setText(sb.toString());
	}
}