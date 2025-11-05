package Engine.Core.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;

public class Utils {

	private Utils() {
		// prevents instantiation
	}
	
	// Read text content from file
	public static String readFile(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException ex) {
            throw new RuntimeException("Failed to read file: [" + filePath + "]" , ex);
        }
	}
	
	// Create File object from directory + filename
	public static File readFile(String directory, String fileName) {
		File file = new File(directory, fileName);
		if(!file.exists()) {
			throw new RuntimeException("File not found: [" + file.getAbsolutePath() + "]");
		}
		return file;
	}
	
	// Save text content to file (overwrites)
	public static void saveFile(String filePath, String content) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());
            Files.writeString(path, content);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to write file: [" + filePath + "]", ex);
        }
	}
	
	// Save binary data to file (overwrites)
	public static void saveFile(String filePath, byte[] content) {
		try {
			Path path = Paths.get(filePath);
			Files.createDirectories(path.getParent());
			Files.write(path, content);
		} catch (IOException ex) {
			throw new RuntimeException("Failed to write file: [" + filePath + "]", ex);
		}
	}
	
	// Menu context read file // TWEAKS
	public static File readFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open file");
		
	    int result = fileChooser.showOpenDialog(null);

	    if (result == JFileChooser.APPROVE_OPTION) {
	    	File selectedFile = fileChooser.getSelectedFile();
	        return selectedFile;
	    }

	    throw new RuntimeException("No file was selected.");
	} 
	
	// Menu context save file	// TWEAKS
	public static void saveFile(File storeFile) {
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setDialogTitle("Save file");

	    int result = fileChooser.showSaveDialog(null);

	    if (result == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();

	        try {
	            Path path = selectedFile.toPath();
	            Files.createDirectories(path.getParent());
	            Files.writeString(path, storeFile.getAbsolutePath());
	        } catch (IOException ex) {
	            throw new RuntimeException("Failed to save file: [" + selectedFile.getAbsolutePath() + "]", ex);
	        }
	    } else {
	        throw new RuntimeException("File save was cancelled.");
	    }
	}
	
}
