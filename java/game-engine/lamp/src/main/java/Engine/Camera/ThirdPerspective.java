package Engine.Camera;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class ThirdPerspective extends Camera {

	public ThirdPerspective(Vector3f offset) {
		instantiateVariables(offset);
	}
	
	@Override
	protected void updateViewMatrix() {
        // Calculate rotated offset
        Matrix4f rot = new Matrix4f()
            .identity()
            .rotateY(rotation.y)
            .rotateX(rotation.x);

        Vector3f rotatedOffset = new Vector3f(offset);
        rot.transformDirection(rotatedOffset);

        // Camera position = target + rotated offset
        position.set(targetPosition).add(rotatedOffset);

        // Look at the target
        viewMatrix.identity().lookAt(position, targetPosition, new Vector3f(0, 1, 0));
    }
	
	protected void instantiateVariables(Vector3f offset) {
        this.offset = new Vector3f(offset);
        this.targetPosition = new Vector3f();
        this.position = new Vector3f();
        this.rotation = new Vector2f();
        this.viewMatrix = new Matrix4f();
    }
}
