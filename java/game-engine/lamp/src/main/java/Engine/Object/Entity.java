package Engine.Object;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import lombok.Getter;
import lombok.Setter;

public abstract class Entity {

	@Getter
	protected String id;
	
	@Getter
	protected String modelId;
	
	@Getter
	protected Matrix4f modelMatrix;
	
	@Getter
	protected Vector3f position;
	
	@Getter
	protected Quaternionf rotation;
	
	@Getter
	@Setter
	protected float scale;
	
	protected abstract void setPosition(float x, float y, float z);
	protected abstract void setRotation(float x, float y, float z, float angle);
	protected abstract void updateModelMatrix();
}
