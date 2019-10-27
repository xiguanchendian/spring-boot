package com.xgcd.springboot.utils;

//import org.apache.commons.codec.binary.Base64;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAEnDeUtils {

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 获取密钥对
     *
     * @return 密钥对
     */
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        return generator.generateKeyPair();
    }

    /**
     * 获取私钥
     *
     * @param privateKey 私钥字符串
     * @return
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.decodeBase64(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 获取公钥
     *
     * @param publicKey 公钥字符串
     * @return
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.decodeBase64(publicKey.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * RSA加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥
     * @return
     */
    public static String encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = data.getBytes().length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data.getBytes(), offset, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data.getBytes(), offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        // 获取加密内容使用base64进行编码,并以UTF-8为标准转化成字符串
        // 加密后的字符串
        return new String(Base64.encodeBase64String(encryptedData));
    }

    /**
     * RSA解密
     *
     * @param data       待解密数据
     * @param privateKey 私钥
     * @return
     */
    public static String decrypt(String data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] dataBytes = Base64.decodeBase64(data);
        int inputLen = dataBytes.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(dataBytes, offset, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        // 解密后的内容
        return new String(decryptedData, "UTF-8");
    }

    /**
     * 签名
     *
     * @param data       待签名数据
     * @param privateKey 私钥
     * @return 签名
     */
    public static String sign(String data, PrivateKey privateKey) throws Exception {
        byte[] keyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey key = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(key);
        signature.update(data.getBytes());
        return new String(Base64.encodeBase64(signature.sign()));
    }

    /**
     * 验签
     *
     * @param srcData   原始字符串
     * @param publicKey 公钥
     * @param sign      签名
     * @return 是否验签通过
     */
    public static boolean verify(String srcData, PublicKey publicKey, String sign) throws Exception {
        byte[] keyBytes = publicKey.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey key = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(key);
        signature.update(srcData.getBytes());
        return signature.verify(Base64.decodeBase64(sign.getBytes()));
    }

    public static void main(String[] args) {
        try {
            // 生成密钥对
            KeyPair keyPair = getKeyPair();
            String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
            String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
            System.out.println("私钥:" + privateKey);
            System.out.println("公钥:" + publicKey);
            // RSA加密
            String data = "待加密的文字内容";
            String encryptData = encrypt(data, getPublicKey(publicKey));
            System.out.println("加密后内容:" + encryptData);
            // RSA解密
            String decryptData = decrypt(encryptData, getPrivateKey(privateKey));
            System.out.println("解密后内容:" + decryptData);

            // RSA签名
            String sign = sign(data, getPrivateKey(privateKey));
            System.out.println("签名:" + sign);
            // RSA验签
            boolean result = verify(data, getPublicKey(publicKey), sign);
            System.out.print("验签结果:" + result);
            
            //私钥:MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIDK28b2plvLUfIvcuqc+P3Z/tlkTwcDLhkdefsDILCXRkW9c5ckqO5+WFWLcT8QSmsM8HP1Ob6Imfv/GsDvKqDU5mDU5ewH4frhTcvCD/2Fa7xwsL/CuRTmoZkg09NRqSTTZ+/VhXXlpg1Ww+PCX3De0wOAlWHCg+cnOY5DTfsXAgMBAAECgYAwGRJI1LY+E8lvs86r1aGbU/07/J0S1lox4PM8Def4axZAV0dCy9sW7jJZCDFrxs6z+eoWtB8zi9pN5PB92xPE4f7mW8/ZbfSXuv/74cZFAuF8nyTEfezAEGJQWM4iacUHcusQ45laoeLbXObN+qhsVUsmcu6KdvfsVPvIVBEIoQJBAMzyvrvq5xJ8FgmkUtsUZ0ltAf7wvqy6fS9jEJJLBBTsPsEE8/+yKdsH9wyqN4zl/rKh7mOhnnlrR/IgvybLtOcCQQCg38RAWTdrAZF2W9zmKlKke1Qx07bLUgziKAGS3sETbZdiaHdzcHjJDSJ04OYhLa/TJMYvBs5DSXnN/rLPIpJRAkB6++PG4lQdPIcA7DGoM5szbY14DcFt5069w+Wq1Ac0Avw5WZ6NvrztKd9vIynIjC+FxDRIZzCwzdbTjiEGx9DbAkAiZ7jRCkOP3wX9Cih0ERkblEStY1n0odefhm7PulQQk5+MrErfpW4vkV+NH4wYDG1N+s9nv0zdlxk1tQMIyZwBAkEAheWnJKKuT9EpPC2mUki3HrHBu9USaLIvBOzp12MaEp1wN/js/cfBW8tI/ZjYLbwY5P7H94Uloau1NFS1dD9gXw==
            //公钥:MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCAytvG9qZby1HyL3LqnPj92f7ZZE8HAy4ZHXn7AyCwl0ZFvXOXJKjuflhVi3E/EEprDPBz9Tm+iJn7/xrA7yqg1OZg1OXsB+H64U3Lwg/9hWu8cLC/wrkU5qGZINPTUakk02fv1YV15aYNVsPjwl9w3tMDgJVhwoPnJzmOQ037FwIDAQAB
            //加密后内容:N9Qz/fKDOTGhW/cSTAEgif4R6GgGE6FjAcFVBv+7eWHby/IylIL+gu/6eyYfGCOljm9bSuACKYhUQ/aqlTIdLn+cagNSe87V73vJMYhX47K8RGzlTSZ8jOjIbzAbduIy+h5zaMl4Ib1QoWCxot6zqXgmyf+N2Gql9p88970cH+g=
            //解密后内容:待加密的文字内容
            //签名:eolKFVbIjMgdrUZyhureGIHERwXKfnpHhZCDYWF/36XJpiNLPuon3+YTieMmyC5JRQblhHwhpTFthfY29ax5HC6eXlRDG5//2zHMHFygFzN4YU1g6PkiqWuBx/GarFEQ2zgv5V7D+9/6i+t+ln/6SOV2I5Uzk6CO0p4v0q1U0TQ=
            //验签结果:true9
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("加解密异常");
        }
    }
}