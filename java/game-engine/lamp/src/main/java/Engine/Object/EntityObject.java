package Engine.Object;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class EntityObject extends Entity {

	public EntityObject(String id, String modelId) {
        this.id = id;
        this.modelId = modelId;
        modelMatrix = new Matrix4f();
        position = new Vector3f();
        rotation = new Quaternionf();
        scale = 1;
	}
	
	@Override
	protected void setPosition(float x, float y, float z) {
		position.set(x, y, z);
	}

	@Override
	protected void setRotation(float x, float y, float z, float angle) {
		rotation.fromAxisAngleRad(x, y, z, angle);
	}

	@Override
	protected void updateModelMatrix() {
        modelMatrix.translationRotateScale(position, rotation, scale);
	}

}
