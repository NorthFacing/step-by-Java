package com.bob.encrypt.RSA;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.UUID;

public class RSA2String {

	public static final String algorithm = "RSA";

	public static void main(String[] args) throws Exception {
		// generate public and private keys
		KeyPair keyPair = buildKeyPair();
		PublicKey pubKey = keyPair.getPublic();
		PrivateKey priKey = keyPair.getPrivate();

		// encrypt the message
		byte[] encrypted = encrypt(priKey, "This is a secret message");
		System.out.println(Base64.getEncoder().encodeToString(encrypted));  // <<encrypted message>>

		// decrypt the message
		byte[] secret = decrypt(pubKey, encrypted);
		System.out.println(new String(secret));     // This is a secret message

		// =========================== D & N & E ===========================

		RSAPublicKey rsaPubKey = (RSAPublicKey) pubKey;
		String pubModulus = rsaPubKey.getModulus().toString(16).toUpperCase();
		String pubExponent = rsaPubKey.getPublicExponent().toString(16).toUpperCase();

		RSAPrivateKey rsaPrivKey = (RSAPrivateKey) priKey;
		String primodulus = rsaPrivKey.getModulus().toString(16).toUpperCase();
		String priExponent = rsaPrivKey.getPrivateExponent().toString(16).toUpperCase();

		System.out.println("pubModulus:  " + pubModulus);
		System.out.println("pubExponent: " + pubExponent);
		System.out.println("primodulus:  " + primodulus);
		System.out.println("priExponent: " + priExponent);

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		KeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(pubModulus, 16), new BigInteger(pubExponent, 16));
		PublicKey publicKey = keyFactory.generatePublic(pubKeySpec);

		KeySpec priKeySpec = new RSAPrivateKeySpec(new BigInteger(primodulus, 16), new BigInteger(priExponent, 16));
		PrivateKey privateKey = keyFactory.generatePrivate(priKeySpec);

		// encrypt the message
		encrypted = encrypt(privateKey, "This is a secret message");
		System.out.println(Base64.getEncoder().encodeToString(encrypted));  // <<encrypted message>>

		// decrypt the message
		secret = decrypt(publicKey, encrypted);
		System.out.println(new String(secret));     // This is a secret message

	}

	public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
		final int keySize = 2048;
		SecureRandom secureRandom = new SecureRandom(UUID.randomUUID().toString().getBytes());
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm); // 可选值有哪些？
//		 keyPairGenerator.initialize(keySize); // 不使用 secureRandom 的方法
		keyPairGenerator.initialize(keySize, secureRandom);
		return keyPairGenerator.genKeyPair();
	}

	public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(message.getBytes());
	}

	public static byte[] decrypt(PublicKey publicKey, byte[] encrypted) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		return cipher.doFinal(encrypted);
	}

}