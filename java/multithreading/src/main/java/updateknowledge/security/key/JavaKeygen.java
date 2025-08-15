package updateknowledge.security.key;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class JavaKeygen {

	public static void main(String[] args) {
		
		KeyGenerator keygen = createKeygen();
		initializeKeygen(keygen);
		SecretKey secretKey = keygen.generateKey();
		
		String key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println(key);
	}
	
	public static KeyGenerator createKeygen() {
		KeyGenerator keyGenerator = null;
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return keyGenerator;
	}
	
	public static void initializeKeygen(KeyGenerator keyGenerator) {
		SecureRandom secureRandom = new SecureRandom();
		int keyBitSize = 256;

		keyGenerator.init(keyBitSize, secureRandom);
		
	}
}
