package Engine.Camera;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import lombok.Getter;

public abstract class Camera {

	@Getter
	protected Matrix4f viewMatrix;

	@Getter
	protected Vector3f position;
	
	@Getter
	protected Vector3f targetPosition;
	
	@Getter
	protected Vector3f offset;
	
	protected Vector3f direction;
	protected Vector3f right;
	protected Vector2f rotation;
	protected Vector3f up;
	
	protected abstract void updateViewMatrix();
	
}
