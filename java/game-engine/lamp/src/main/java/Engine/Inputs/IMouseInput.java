package Engine.Inputs;

import org.joml.Vector2f;

import lombok.Getter;
import lombok.Setter;

public abstract class IMouseInput {

	@Getter
	@Setter
	private Vector2f currentPos;
	@Getter
	@Setter
	private Vector2f displVec;
	@Getter
	@Setter
	private Vector2f previousPos;
	@Getter
	@Setter
	private boolean inWindow;
	@Setter
	private boolean leftButtonPressed;
	@Setter
	private boolean rightButtonPressed;

    public boolean isLeftButtonPressed() {
        return leftButtonPressed;
    }

    public boolean isRightButtonPressed() {
        return rightButtonPressed;
    }
}
