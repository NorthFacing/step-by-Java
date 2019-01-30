package com.bob.encrypt.RSA.joyoung;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

public class RSA {
  public static void main(String[] args) {

    try {
      //公钥私钥生成
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      SecureRandom secureRandom = new SecureRandom(new Date().toString().getBytes());
      keyPairGen.initialize(512, secureRandom);
      KeyPair keyPair = keyPairGen.generateKeyPair();
      RSAPublicKey rasPublicKey = (RSAPublicKey) keyPair.getPublic();
      RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

      String N = rasPublicKey.getModulus().toString(16).toUpperCase();
      String D = rsaPrivateKey.getPrivateExponent().toString(16).toUpperCase();

      System.out.println(N);
      System.out.println(D);

      String E = "10001";

      RSAPrivateKey privateKey = RSAUtil.getPrivateKey(N, E);
      RSAPublicKey publicKey = RSAUtil.getPublicKey(N, D);

      System.out.println("N:" + N.length() + ":" + N);
      System.out.println("D:" + D.length() + ":" + D);
      System.out.println("E:" + E);

      String test = "xxteakey";

      String encode = RSAUtil.encryptByPublicKey(test, publicKey);
      System.out.println("公钥加密：" + encode);
      String decode = RSAUtil.decryptByPrivateKey(encode, privateKey);
      System.out.println("私钥解密：" + decode);

    } catch (Exception e) {
      System.out.println(e);
    }

  }
}
