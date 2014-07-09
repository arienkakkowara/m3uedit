package Frame;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;

public class MyDropTarget extends DropTargetAdapter {
	MainFrame main;

	public MyDropTarget(MainFrame main) {
		this.main = main;
	}
	
	@Override
	public void drop(DropTargetDropEvent e) {
		
		try {
			Transferable t = e.getTransferable();
			if (t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
				e.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
				@SuppressWarnings("unchecked")
				java.util.List<File> fileList = (java.util.List<File>) (t.getTransferData(DataFlavor.javaFileListFlavor));
				
				main.dropOnLabel(fileList);
			}
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}
}

