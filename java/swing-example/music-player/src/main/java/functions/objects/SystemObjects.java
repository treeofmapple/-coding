package functions.objects;

import java.awt.FlowLayout;

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JWindow;

public interface SystemObjects {

    JPanel systemBar = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JPanel controlPanel = new JPanel(new FlowLayout());
    JWindow borderlessWindow = new JWindow();
    JFileChooser fileChooser = new JFileChooser();
    JList<String> itemList = new JList<>();
    JProgressBar progressBar = new JProgressBar();
    JSlider volumeSlider = new JSlider(0, 100, 50);
    
}
