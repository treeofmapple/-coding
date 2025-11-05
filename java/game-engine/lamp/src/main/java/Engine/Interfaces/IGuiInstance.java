package Engine.Interfaces;

import Engine.Core.Window;
import javafx.scene.Scene;

public interface IGuiInstance {

	void drawGui();
	
	boolean handleGuiInput(Scene scene, Window window);
	
}
