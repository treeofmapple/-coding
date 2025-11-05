package Engine.Interfaces;

import Engine.Config.GameConfiguration;

public interface IEngineConfig {

	IEngineConfig configuration = new GameConfiguration();
	
	float getFovValue();
	void setFovSize(float fovValue);
	
}
