package Engine.Interfaces;

import Engine.Core.Window;
import Engine.Render.Render;
import javafx.scene.Scene;

public interface IAppLogic {

	void cleanup();
	
	void init(Window windows, Scene scene, Render render);
	
	void input(Window windows, Scene scene, long diffTimeMillis, boolean inputConsumed);
	
	void update(Window windows, Scene scene, long diffTimeMillis);
	
}

