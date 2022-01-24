package com.system.demo.utility;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class EncripId {
	private final String  ENCRYPT_KEY="FODVNUASDNVVAOVF";
	
	public String encript(String text) throws Exception {	
		Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		byte[] encrypted = cipher.doFinal(text.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
	}

	public String decrypt(String encrypted) throws Exception {
		byte[] encryptedBytes=Base64.getDecoder().decode( encrypted.replace("\n", "") );
		Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, aesKey);
		String decrypted = new String(cipher.doFinal(encryptedBytes));  
		return decrypted;
	}

}
