package security.signature;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;

public class JavaSignature {

	public static void main(String[] args) {
		
	}
	
	public void initializeSignature() {
		Signature signature = Signature.getInstance("SHA256WithDSA");
		
		SecureRandom secureRandom = new SecureRandom();
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
		KeyPair keyPair = KeyPairGenerator.generateKeyPair();
		
		signature.initSign(keyPair.getPrivate(), secureRandom);
		
	}
	
	public void createSignature() {
		Signature signature = Signature.getInstance("SHA256WithDSA");
		
		byte[] data = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
		signature.update(data);

		byte[] digitalSignature = signature.sign();
		
	}
	
	public void verifySignature() {
		Signature signature = Signature.getInstance("SHA256WithDSA");
		KeyPair keyPair = KeyPairGenerator.generateKeyPair();
		
		signature.initVerify(keyPair.getPublic());
		
	}

	public void verifyDigitalSignature() {
		Signature signature2 = Signature.getInstance("SHA256WithDSA");
		byte[] data2 = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
		signature2.update(data2);

		boolean verified = signature2.verify(digitalSignature);
	}
	
}
