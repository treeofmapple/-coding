package base;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import frame.LockInstance;
import frame.PageBuilder;

public class MusicPlayer {
	public static void main(String[] args) {
		PageBuilder.selectTheme();
		PageBuilder musicSystem = new PageBuilder();
		if (!LockInstance.isAlreadyRunning()) {
			SwingUtilities.invokeLater(() -> {
				musicSystem.setVisible(true);
			});
		} else {
			JOptionPane.showMessageDialog(null, "Application is already running", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}
}
