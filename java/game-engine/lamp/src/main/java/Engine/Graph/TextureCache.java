package Engine.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TextureCache {

	private static final String DEFAULT_TEXTURE = "resources/models/defautl/default_texture.png";
	
	private Map<String, Texture> textureMap;
	private Map<String, Integer> referenceCounts = new HashMap<>();
	
	public TextureCache() {
		textureMap = new ConcurrentHashMap<>();
		textureMap.put(DEFAULT_TEXTURE, new Texture(DEFAULT_TEXTURE));
	}
	
	public void cleanup() {
		textureMap.values().forEach(Texture::cleanup);
	}
	
	public Texture createTexture(String texturePath) {
		texturePath = texturePath == null ? DEFAULT_TEXTURE : texturePath;
		referenceCounts.put(texturePath, referenceCounts.getOrDefault(texturePath, 0) + 1);
		return textureMap.computeIfAbsent(texturePath, Texture::new);
	}
	
	public Texture getTexture(String texturePath) {
		Texture texture = null;
		if(texturePath != null) {
			texture = textureMap.get(texturePath);
		}
		if(texture == null) {
			texture = textureMap.get(DEFAULT_TEXTURE);
		}
		return texture;
	}

	public void releaseTexture(String texturePath) {
	    if (texturePath == null || texturePath.equals(DEFAULT_TEXTURE)) return;
	    int count = referenceCounts.getOrDefault(texturePath, 0);
	    if (count <= 1) {
	        textureMap.get(texturePath).cleanup();
	        textureMap.remove(texturePath);
	        referenceCounts.remove(texturePath);
	    } else {
	        referenceCounts.put(texturePath, count - 1);
	    }
	}
	
	public void reloadTexture(String texturePath) {
		if(textureMap.containsKey(texturePath) && !texturePath.equals(DEFAULT_TEXTURE)) {
	        textureMap.get(texturePath).cleanup();
	        textureMap.put(texturePath, new Texture(texturePath));
	    }
	}
	
	public void removeTexture(String texturePath) {
		if(textureMap.containsKey(texturePath) && !texturePath.equals(DEFAULT_TEXTURE)) {
			textureMap.get(texturePath).cleanup();
			textureMap.remove(texturePath);
		}
	}
	
}
