package Engine.Config;

import Engine.Interfaces.IEngineConfig;
import Engine.Interfaces.IMouseConfiguration;

public class GameConfiguration implements IMouseConfiguration, IEngineConfig {

    private boolean invertRotation = false;
    private boolean invertMouseClick = false;
    private float fovValue = 60;
	
	@Override
	public boolean isInvertRotation() {
		return invertRotation;
	}

	@Override
	public void setInvertRotation(boolean invertRotation) {
		this.invertRotation = invertRotation;
	}

	@Override
	public boolean isInvertMouseClick() {
		return invertMouseClick;
	}

	@Override
	public void setInvertMouseClick(boolean invertMouseClick) {
		this.invertMouseClick = invertMouseClick;
	}

	@Override
	public float getFovValue() {
		return fovValue;
	}

	@Override
	public void setFovSize(float fovValue) {
		this.fovValue = fovValue;
	}
	
}
