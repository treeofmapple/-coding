package base;

import javax.swing.SwingUtilities;

import frame.BuildingPage;

public class NotepadClone {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			BuildingPage.selectTheme();
			BuildingPage notepad = new BuildingPage();
			notepad.setVisible(true);
		});
	}
}
