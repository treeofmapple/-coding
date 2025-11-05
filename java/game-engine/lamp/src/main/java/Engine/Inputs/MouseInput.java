 package Engine.Inputs;

import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_1;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_2;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.glfwSetCursorEnterCallback;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;

import org.joml.Vector2f;

import Engine.Interfaces.IMouseConfiguration;

public class MouseInput extends IMouseInput {

	public MouseInput(long windowHandle) {
		checkStatus(windowHandle);
	}
	
	private void checkStatus(long windowHandle) {
		setPreviousPos(new Vector2f(-1, -1));
		setCurrentPos(new Vector2f());
		setDisplVec(new Vector2f());
		setLeftButtonPressed(false);
		setRightButtonPressed(false);
		setInWindow(false);
		
		glfwSetCursorPosCallback(windowHandle, (handle, xpos, ypos) -> {
			getCurrentPos().x = (float) xpos;
			getCurrentPos().y = (float) ypos;
		});
		
		glfwSetCursorEnterCallback(windowHandle, (handle, entered) -> setInWindow(entered));
		if(!IMouseConfiguration.configuration.isInvertMouseClick()) {
			normalClick(windowHandle);
		} else {
			invertClick(windowHandle);
		}
		
	}

	public void input() {
		getDisplVec().x = 0;
		getDisplVec().y = 0;
		if(getPreviousPos().x > 0 && getPreviousPos().y > 0 && isInWindow()) {
			double deltax = getCurrentPos().x - getPreviousPos().x;
			double deltay = getCurrentPos().y - getPreviousPos().y;
			boolean rotateX = deltax != 0;
			boolean rotateY = deltay != 0;
			
			if(!IMouseConfiguration.configuration.isInvertRotation()) {
				mouseRotation(rotateX, rotateY, deltax, deltay);
			} else {
				mouseRotation(rotateX, rotateY, -deltax, -deltay);
			}
		}
		
		getPreviousPos().x = getCurrentPos().x;
		getPreviousPos().y = getCurrentPos().y;
	}
	
	private void normalClick(long windowHandle) {
		glfwSetMouseButtonCallback(windowHandle, (handle, button, action, mode) -> {
			setLeftButtonPressed(button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS);
			setRightButtonPressed(button == GLFW_MOUSE_BUTTON_2 && action == GLFW_PRESS);
		});
	}

	private void invertClick(long windowHandle) {
		glfwSetMouseButtonCallback(windowHandle, (handle, button, action, mode) -> {
			setLeftButtonPressed(button == GLFW_MOUSE_BUTTON_2 && action == GLFW_PRESS);
			setRightButtonPressed(button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS);
		});
	}
	
	private void mouseRotation(boolean rotateX, boolean rotateY, double deltax, double deltay) {
		if(rotateX) {
			getDisplVec().y = (float) deltax;
		}
		if(rotateY) {
			getDisplVec().x = (float) deltay;
		}
	
	}
	
}
 