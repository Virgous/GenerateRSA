package org.mfn.virgous;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Generate {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

// Generate the key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // You can adjust the key size
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

// Get the private key in PKCS#8 format
        PrivateKey privateKey = keyPair.getPrivate();
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
        String pkcs8PrivateKeyBase64 = Base64.getEncoder().encodeToString(pkcs8EncodedKeySpec.getEncoded());
        System.out.println("PKCS#8 Private Key:");
        System.out.println(pkcs8PrivateKeyBase64);

// Get the public key in X.509 format

        PublicKey publicKey = keyPair.getPublic();
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
        String x509PublicKeyBase64 = Base64.getEncoder().encodeToString(x509EncodedKeySpec.getEncoded());
        System.out.println("X.509 Public Key:");
        System.out.println(x509PublicKeyBase64);

    }
}
