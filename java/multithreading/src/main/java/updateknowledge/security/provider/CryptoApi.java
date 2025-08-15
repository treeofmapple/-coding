package updateknowledge.security.provider;

import java.security.Security;

public class CryptoApi {

	public static void main(String[] args) {
		Security.addProvider(new BouncyCastleProvider());
	}
	
}
