package music;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import functions.MenuBarFunctions;
import functions.objects.SystemObjects;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Music extends MenuBarFunctions implements SystemObjects {

    private FileInputStream fileInputStream;
    private AdvancedPlayer player;
    private Bitstream bitstream;
    private boolean isPaused = false;
    private boolean isStopped = false;
    private int totalFrames = 0;
    private int currentFrame = 0;
    
	protected void actualMusicTime() {
		progressBar.setEnabled(false);
	}

	/*
	 * private File nextMusicList() { File actualMusic = getMusicFile(); List<File>
	 * nextMusic = getMusicFileList(); }
	 */

    private int countFrames(File filePath) throws IOException, BitstreamException {
        fileInputStream = new FileInputStream(filePath.getAbsolutePath());
        bitstream = new Bitstream(fileInputStream);
        int frames = 0;
        while (bitstream.readFrame() != null) {
            frames++;
        }
        fileInputStream.close();
        return frames;
    }

    public synchronized void play() {
        if (player != null) {
            stop(); // Stop any existing playback before starting a new one
        }

        isPaused = false;
        isStopped = false;

        new Thread(() -> {
            try {
                fileInputStream = new FileInputStream(filePath);
                bitstream = new Bitstream(fileInputStream);
                totalFrames = countFrames();
                fileInputStream.close();
                fileInputStream = new FileInputStream(filePath);
                player = new AdvancedPlayer(fileInputStream);
                player.play(currentFrame, totalFrames);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public synchronized void pause() {
        if (player != null) {
            isPaused = true;
            player.close();
            currentFrame += 1000; // Adjust frame count for better resume accuracy
            System.out.println("Paused at frame: " + currentFrame);
        }
    }

    public synchronized void resume() {
        if (isPaused) {
            play(); // Restart playback from the paused position
            System.out.println("Resumed...");
        }
    }

    public synchronized void stop() {
        if (player != null) {
            isStopped = true;
            player.close();
            currentFrame = 0;
            System.out.println("Playback stopped.");
        }
    }

	public void previousMusic() {

	}

	public void nextMusic() {

	}

	public void increaseVolume() {

	}

	public void decreaseVolume() {

	}

	public void muteVolume() {

	}

	public void volumeSlider() {

	}
	
	private void validation(File filePath) {
		if (filePath == null || !filePath.exists()) {
			System.err.println("Erro: Arquivo de música não encontrado.");
			return;
		}

		String fileName = filePath.getName().toLowerCase();
		if (!fileName.endsWith(".mp3")) {
			System.err.println("Erro: Formato de arquivo não suportado.");
			return;
		}
	}

}
