package Engine.Camera;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class FreeCam extends Camera {

	public FreeCam() {
		direction = new Vector3f();
		right = new Vector3f();
		up = new Vector3f();
		position = new Vector3f();
		rotation = new Vector2f();
		viewMatrix = new Matrix4f();
	}
	
	public void moveBackwards(float inc) {
		viewMatrix.positiveZ(direction).negate().mul(inc);
		position.sub(direction);
		updateViewMatrix();
	}

	public void moveDown(float inc) {
		viewMatrix.positiveY(up).mul(inc);
		position.sub(up);
		updateViewMatrix();
	}
	
	public void moveForward(float inc) {
		viewMatrix.positiveZ(direction).negate().mul(inc);
		position.add(direction);
		updateViewMatrix();
	}
	
	public void moveLeft(float inc) {
		viewMatrix.positiveX(right).mul(inc);
		position.sub(right);
		updateViewMatrix();
	}
	
	public void moveRight(float inc) {
		viewMatrix.positiveX(right).mul(inc);
		position.add(right);
		updateViewMatrix();
	}
	
	public void moveUp(float inc) {
		viewMatrix.positiveY(direction).mul(inc);
		position.add(up);
		updateViewMatrix();
	}
	
	public void setPostion(float x, float y, float z) {
		position.set(x, y, z);
		updateViewMatrix();
	}
	
	public void setRotation(float x, float y) {
		rotation.set(x, y);
		updateViewMatrix();
	}
	
	public void addRotation(float x, float y) {
		rotation.add(x, y);
		updateViewMatrix();
	}
	
	@Override
	protected void updateViewMatrix() {
		viewMatrix.identity()
			.rotateX(rotation.x)
			.rotateY(rotation.y)
			.translate(-position.x, -position.y, -position.z);
	}
	
}
