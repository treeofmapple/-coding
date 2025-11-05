package Engine.Graph;

import imgui.ImDrawData;

import org.lwjgl.opengl.GL30;

import lombok.Getter;

public class GuiMesh {

	@Getter
	private int indicesVBO;
	
	@Getter
	private int vaoId;
	
	@Getter
	private int verticesVBO;
	
	public GuiMesh() {
		loadMesh();
	}
	
	public void cleanup() {
		GL30.glDeleteBuffers(indicesVBO);
		GL30.glDeleteBuffers(verticesVBO);
		GL30.glDeleteVertexArrays(vaoId);
	}
	
	private void loadMesh() {
		vaoId = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vaoId);
		
		// Single VBO
		
		verticesVBO = GL30.glGenBuffers();
		GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, verticesVBO);
		GL30.glEnableVertexAttribArray(0);
		GL30.glVertexAttribPointer(0, 2, GL30.GL_FLOAT, false, ImDrawData.sizeOfImDrawVert(), 0);
		
		indicesVBO = GL30.glGenBuffers();
		
		GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, 0);
		GL30.glBindVertexArray(0);
		
	}
}
