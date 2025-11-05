package Engine.Graph;

import static org.lwjgl.stb.STBImage.stbi_failure_reason;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.opengl.GL30;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import Engine.Core.Utils.SystemLogger;
import lombok.Getter;

public class Texture {

	private int textureId;

	@Getter
	private String texturePath;

	public Texture(int width, int height, ByteBuffer buf) {
		this.texturePath = "";
		generateTexture(width, height, buf);
	}

	public Texture(String texturePath) {
		loadTexture(texturePath);
	}

	public void bind() {
		GL30.glBindTexture(GL30.GL_TEXTURE_2D, textureId);
	}

	public void cleanup() {
		GL30.glDeleteTextures(textureId);
	}

	private void generateTexture(int width, int height, ByteBuffer buf) {
		textureId = GL30.glGenTextures();
		GL30.glBindTexture(GL30.GL_TEXTURE_2D, textureId);
		GL30.glPixelStorei(GL30.GL_UNPACK_ALIGNMENT, 1);
		GL30.glTexParameteri(GL30.GL_TEXTURE_2D, GL30.GL_TEXTURE_MIN_FILTER, GL30.GL_NEAREST);
		GL30.glTexParameteri(GL30.GL_TEXTURE_2D, GL30.GL_TEXTURE_MAG_FILTER, GL30.GL_NEAREST);
		GL30.glTexImage2D(
				GL30.GL_TEXTURE_2D, 
				0, 
				GL30.GL_RGBA, 
				width, 
				height, 
				0, 
				GL30.GL_RGBA, 
				GL30.GL_UNSIGNED_BYTE,
				buf);
		GL30.glGenerateMipmap(GL30.GL_TEXTURE_2D);

	}

	private void loadTexture(String texturePath) {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			this.texturePath = texturePath;
			IntBuffer w = stack.mallocInt(1);
			IntBuffer h = stack.mallocInt(1);
			IntBuffer channels = stack.mallocInt(1);
			
			ByteBuffer buf = STBImage.stbi_load(texturePath, w, h, channels, 4);
			
			if(buf == null) {
				SystemLogger.warn("Image file [" + texturePath + "] not loaded: " + stbi_failure_reason());
				throw new RuntimeException("Image file [" + texturePath + "] not loaded: " + stbi_failure_reason());
			}
			
			int width = w.get();
			int height = h.get();
			
			generateTexture(width, height, buf);
			STBImage.stbi_image_free(buf);
		}
	}
}
