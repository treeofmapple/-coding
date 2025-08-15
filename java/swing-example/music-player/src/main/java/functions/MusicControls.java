package functions;

import javax.swing.JButton;

import functions.objects.SystemObjects;
import music.Music;

public class MusicControls extends Music implements SystemObjects {

	private JButton playPauseButton, nextButton, prevButton, stopButton;
	private boolean isPlaying = false;

	public void createMusicControls() {
		prevButton = new JButton("⏮ Prev");
		playPauseButton = new JButton("▶ Play");
		nextButton = new JButton("Next ⏭");
		stopButton = new JButton("Stop");

		controlPanel.add(prevButton);
		controlPanel.add(playPauseButton);
		controlPanel.add(nextButton);
		controlPanel.add(stopButton);
		controlPanel.add(volumeSlider);

		prevButton.addActionListener(e -> previousMusic());
		playPauseButton.addActionListener(e -> togglePlayPause());
		nextButton.addActionListener(e -> nextMusic());
		stopButton.addActionListener(e -> stop());
		// volumeSlider.addActionListener(e -> volumeSlider());

	}

	private void togglePlayPause() {
		if (isPlaying) {
			playPauseButton.setText("⏸ Pause");
			play();
		} else {
			playPauseButton.setText("▶ Play");
			pause();
		}
		isPlaying = !isPlaying;
	}

}
