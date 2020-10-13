package com.te.pos.security;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.te.pos.misc.Constants;

public class AESEncryptionDecryptionUtility {
	
	
	 public static String encrypt(String plainText) {
		String key = Constants.AES_CBC_KEY_FOR_256;
		String iv = Constants.AES_CBC_IV;
		int keySize = Constants.AES_CBC_KEY_SIZE_FOR_256;
        try {
            if (key.length() < keySize) {
                int numPad = keySize - key.length();
                for(int i = 0; i < numPad; i++){
                    key += "0"; //0 pad to len 16 bytes
                }
            } else if (key.length() > keySize) {
                key = key.substring(0, keySize); //truncate to 16 bytes
            }
            IvParameterSpec initVector = new IvParameterSpec(iv.getBytes("ISO-8859-1"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("ISO-8859-1"), "AES");
            Cipher cipher = Cipher.getInstance(Constants.ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, initVector);
            byte[] encryptedData = cipher.doFinal((plainText.getBytes()));
            byte[] base64_EncryptedDataBytes = Base64.getEncoder().encode(encryptedData);
            String doubleBase64_EncryptedData = Base64.getEncoder().encodeToString(base64_EncryptedDataBytes);
            return doubleBase64_EncryptedData;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
	}
	
	public static String decrypt(String cipherText) {
		
		cipherText = new String(Base64.getDecoder().decode(cipherText));
		String key = Constants.AES_CBC_KEY_FOR_256;
		int keySize = Constants.AES_CBC_KEY_SIZE_FOR_256;
		String iv = Constants.AES_CBC_IV;
        try {
            if (key.length() < keySize) {
                int numPad = keySize - key.length();
                for(int i = 0; i < numPad; i++){
                    key += "0"; //0 pad to len 16 bytes
                }   
            } else if (key.length() > keySize) {
                key = key.substring(0, keySize); //truncate to 16 bytes
            }
            //String[] parts = cipherText.split(":");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("ISO-8859-1"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("ISO-8859-1"), "AES");
            Cipher cipher = Cipher.getInstance(Constants.ALGO);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivSpec);
            byte[] decodedEncryptedData = Base64.getDecoder().decode(cipherText);
            byte[] original = cipher.doFinal(decodedEncryptedData);

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
	
	
	public static void main(String[] args) {
		System.out.println(encrypt("admin"));
	}
}
