package new_security;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Chyper {

	/* Cipher Modes
	 * 
	 * ECB - Electronic Codebook
	 * CBC - Cipher Block Chaining
	 * CFB - Cipher Feedback
	 * OFB - Output Feedback
	 * CTR - Counter
	 * 
	 * */
	
	static SecretKey aesKey = null;
	
    public static void main(String[] args) {
    	Cipher data = generateCypher();
    	
    	generateSecretKey();
    	
    	var decs = dataToEncrypt("Everest", aesKey, data);
    	String strems = dataToDecrypt(decs, aesKey, data);

    	System.out.println(strems);
    
    }
    
    private static Map<String, byte[]> dataToEncrypt(String text, SecretKey encryptKey, Cipher data) {
    	try {
    		Map<String, byte[]> mapper = new HashMap<>();
			data.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] iv = data.getIV();
			byte[] cipherText = data.doFinal(text.getBytes(StandardCharsets.UTF_8));
	        mapper.put("iv", iv);
	        mapper.put("ciphertext", cipherText);
			
			return mapper;
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			return null;
		}
    }
    
    private static String dataToDecrypt(Map<String, byte[]> encryptedMap, SecretKey encryptKey, Cipher data) {
    	try {
            byte[] iv = encryptedMap.get("iv");
            byte[] cipherText = encryptedMap.get("ciphertext");
			data.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(iv));
			return new String(data.doFinal(cipherText), StandardCharsets.UTF_8);
    	} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
			return null;
		}
    	
    }
    
    private static SecretKey generateSecretKey() {
    	KeyGenerator aesGen;
		try {
			aesGen = KeyGenerator.getInstance("AES");
			aesKey = aesGen.generateKey();
			return aesKey; 
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
    }
    
    private static Cipher generateCypher() {
    	try {
    		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); 
			return cipher;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			return null;
		}
    }
    
    @SuppressWarnings("unused")
    private void keyGenerationAlgorithmsTest() throws NoSuchAlgorithmException {
    	KeyGenerator aesGen = KeyGenerator.getInstance("AES");
    	aesGen.init(256);
    	SecretKey aesKey = aesGen.generateKey();
    	
    	KeyPairGenerator rsaGen = KeyPairGenerator.getInstance("RSA");
    	rsaGen.initialize(2048);
    	KeyPair rsaPair = rsaGen.generateKeyPair();
    	
    	KeyPairGenerator ecGen = KeyPairGenerator.getInstance("EC");
    	ecGen.initialize(256);
    	KeyPair ecPair = ecGen.generateKeyPair();
    	
    	KeyPairGenerator ed255Gen = KeyPairGenerator.getInstance("Ed25519");
    	KeyPair ed255Pair = ed255Gen.generateKeyPair();
    	
    	KeyGenerator hmacGen = KeyGenerator.getInstance("HmacSHA256");
    	SecretKey hmacSecret = hmacGen.generateKey();    	
    }

}
