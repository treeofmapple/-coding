package updateknowledge.security.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Chipher {

	private static String ALGO = "AES"; 
	
	public static void main(String[] args) {
		
		sampleRun();
		
		Cipher cipher = getCipher();
		SecretKey secretKey = getSecretKey();
		
		byte[] cipherText = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] plainText = ("abcdefghijklmnopqrstuvwxyz").getBytes("UTF-8");
			cipherText = cipher.doFinal(plainText);
		} catch (UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			e.printStackTrace();
		}
		
		if(cipherText != null) {
			String key = Base64.getEncoder().encodeToString(cipherText);
			System.out.println("Encrypted Text: " + 	key);
		}
		
	}
	
	public static Cipher getCipher() {
		try {
			return Cipher.getInstance(ALGO);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public static SecretKey getSecretKey() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGO);
			keyGenerator.init(128);
			return keyGenerator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static KeyPair getKeyPair() {
		
		
		
		return null;
	}

	public static void sampleRun() {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}		
		
		byte[] keyBytes = new byte[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		String algorithm = "AES";
		
		SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	
	/*
	
	public void createCypher() {
		
		Key key = new Key();
		byte[] plainText = "abcdefghijklmnopqrstuvwxz".getBytes("UTF-8");
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		byte[] cipherText = cipher.doFinal(plainText);
		
		cipher.init(Cipher.DECRYPT_MODE);
		
	}
	
	
	public void cypherData() {
		
		Cipher cipher = Cipher.getInstance("AES");
		Key key = 
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] data1 = "abcdefghijklmnopqrstuvwxyz".getBytes("UTF-8");
		byte[] data2 = "zyxwvutsrqponmlkjihgfedcba".getBytes("UTF-8");

		byte[] cipherText1 = cipher.update(data1);
		byte[] cipherText2 = cipher.doFinal(data2);

		byte[] data3 = "01234567890123456789012345".getBytes("UTF-8");
		byte[] cipherText3 = cipher.doFinal(data3);
		
		
		byte [] data = new byte[1024];
		
		System.out.println(first(data, cipher));
		System.out.println(second(data, cipher));
		System.out.println(third(data, cipher));
	}
	
	private String first(byte[] data, Cipher cipher) {
		int offset = 10;
		int length = 24;
		return (String) = byte[] cipherText = cipher.doFinal(data, offset, length);
	}
	
	private String second(byte[] data, Cipher cipher) {
		int offset = 10;
		int length = 24;
		byte[] dest = new byte[1024];
		return (String) cipher.doFinal(data, offset, length, dest);
	}
	
	private String third(byte[] data, Cipher cipher) {
		int offset = 10;
		int length = 24;
		byte[] dest = new byte[1024];
		int destOffset = 12;
		return (String) cipher.doFinal(data, offset, length, dest, destOffset);		
	}
	
	
	*/
	
}
