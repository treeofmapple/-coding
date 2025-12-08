package new_security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Certificate {

	public void generateCertificate() {
		try {
			InputStream certificateInputStream = new FileInputStream("my-x509-certificate-chain.crt");
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			CertPath certPath = certificateFactory.generateCertPath(certificateInputStream);

			String type = certPath.getType();
			System.out.println(type);

			certificate.verify(expectedPublicKey);
			byte[] encodedCertificate = certificate.getEncoded();
			PublicKey certificatePublicKey = certificate.getPublicKey();
			String certificateType = certificate.getType();

		} catch (CertificateException | FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void generateCertificateX509() {
		try (InputStream certificateInputStream = new FileInputStream("my-x509-certificate-chain.crt")) {
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

			X509Certificate certificate = (X509Certificate) certificateFactory
					.generateCertificate(certificateInputStream);

			System.out.println("Certificate Type = " + certificate.getType());
			PublicKey certificatePublicKey = certificate.getPublicKey();

			System.out.println("Public Key Algorithm = " + certificatePublicKey.getAlgorithm());

			byte[] encodedCertificate = certificate.getEncoded();
			System.out.println("Encoded Certificate Length = " + encodedCertificate.length);

			certificate.verify(issuerPublicKey);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
