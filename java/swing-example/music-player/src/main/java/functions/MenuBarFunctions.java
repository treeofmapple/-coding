package functions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import functions.objects.SystemObjects;

public class MenuBarFunctions implements SystemObjects {

	static File musicFile = new File("");
	static List<File> musicPlaylist = new ArrayList<>();
	
	public File getMusicFile() {
		return musicFile;
	}
	
	public List<File> getMusicFileList() {
		return musicPlaylist;
	}
	
	public void openFile() {
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			if (selectedFile.getName().endsWith(".mp3") || selectedFile.getName().endsWith(".wav")) {
				musicFile = selectedFile;
			} else {
				JOptionPane.showMessageDialog(null, "Invalid file type. Please select an .mp3 or .wav file.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No file selected.", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void openMultipleFiles() {
		fileChooser.setMultiSelectionEnabled(true);
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File[] files = fileChooser.getSelectedFiles();
			for (File file : files) {
				if (file.getName().endsWith(".mp3") || file.getName().endsWith(".wav")) {
					musicPlaylist.add(file);
				} else {
					JOptionPane.showMessageDialog(null, "No valid music files selected.", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No files selected.", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void openFolder() {
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			File musicFile = fileChooser.getSelectedFile();
			File[] files = musicFile.listFiles((dir, name) -> name.endsWith(".mp3") || name.endsWith(".wav"));

			if (files != null && files.length > 0) {
				for (File file : files) {
					musicPlaylist.add(file);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No music files found in the selected folder.", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
