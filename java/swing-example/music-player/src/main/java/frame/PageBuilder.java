package frame;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;

import functions.objects.Fonts;
import functions.objects.Functions;
import functions.objects.SystemObjects;

public class PageBuilder extends JFrame implements SystemObjects, Fonts, Functions {

	private static final long serialVersionUID = 1L;
	private ImageIcon systemIcon;

	public PageBuilder() {
		setTitle("Music Player");
		setSize(800, 600);
		setFont(jetmono);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSystemIcon();
		buildMenuBar();
		buildFunctions();
	}

	private void buildFunctions() {
		essential.createMusicControls();
		add(controlPanel, BorderLayout.SOUTH);
	}

	private void buildMenuBar() {
		menuBar.setBorderPainted(false);
		menuBar.setOpaque(false);

		JMenu media = new JMenu("Media");
		JMenu webMenu = new JMenu("Web");
		JMenu audioMenu = new JMenu("Audio");
		JMenu playbackMenu = new JMenu("Playback");

		addMenuItems(media, "Open File", "Open Multiple Files", "Open Folder");
		addMenuItems(webMenu, "Stream");
		addMenuItems(playbackMenu, "Play", "Pause", "Stop", "Prev", "Next");
		addMenuItems(audioMenu, "Audio Device");

		menuBar.add(media);
		media.addSeparator();
		addMenuItems(media, "Quit");
		
		menuBar.add(playbackMenu);
		menuBar.add(webMenu);
		
		menuBar.add(audioMenu);
		audioMenu.addSeparator();
		addMenuItems(audioMenu, "Increase Volume", "Decrease Volume", "Mute");
		

		addMenuActions(media, "Open File", () -> funct.openFile());
		addMenuActions(media, "Open Multiple Files", () -> funct.openMultipleFiles());
		addMenuActions(media, "Open Folder", () -> funct.openFolder());
		addMenuActions(media, "Quit", () -> System.exit(0));

		
		addMenuActions(audioMenu, "Increase Volume", () -> musics.increaseVolume());
		addMenuActions(audioMenu, "Decrease Volume", () -> musics.decreaseVolume());
		addMenuActions(audioMenu, "Mute", () -> musics.muteVolume());

		addMenuActions(playbackMenu, "Play", () -> musics.play());
		addMenuActions(playbackMenu, "Pause", () -> musics.pause());
		addMenuActions(playbackMenu, "Stop", () -> musics.stop());
		addMenuActions(playbackMenu, "Prev", () -> musics.previousMusic());
		addMenuActions(playbackMenu, "Next", () -> musics.nextMusic());

		disableMenuItem(webMenu, "Stream");
		disableMenuItem(webMenu, "Audio Device");

		setJMenuBar(menuBar);
	}

	private void addMenuItems(JMenu menu, String... items) {
		for (String item : items) {
			menu.add(new JMenuItem(item));
		}
	}

	private void addMenuActions(JMenu menu, String itemName, Runnable action) {
		for (int i = 0; i < menu.getItemCount(); i++) {
			JMenuItem item = menu.getItem(i);
			if (item != null && item.getText().equals(itemName)) {
				item.addActionListener(e -> action.run());
			}
		}
	}

	private void disableMenuItem(JMenu menu, String itemName) {
		for (int i = 0; i < menu.getItemCount(); i++) {
			JMenuItem item = menu.getItem(i);
			if (item != null && item.getText().equals(itemName)) {
				item.setEnabled(false);
			}
		}
	}

	public static void selectTheme() {
		try {
			UIManager.put("defaultFont", jetmono);
			UIManager.setLookAndFeel(new FlatDarculaLaf());
		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}
	}
	
	public void setSystemIcon() {
		try {
			systemIcon = new ImageIcon(getClass().getResource("/icons/musica.png"));
		} catch (Exception e) {
			System.err.println("Icon not found, using default system icon.");
		}

		if (systemIcon != null && systemIcon.getImage() != null) {
			setIconImage(systemIcon.getImage());
		}
	}

    public Icon getSystemIcon() {
        if (systemIcon == null) {
            setSystemIcon(); 
        }
        return systemIcon != null ? systemIcon : new ImageIcon();
    }
	
}