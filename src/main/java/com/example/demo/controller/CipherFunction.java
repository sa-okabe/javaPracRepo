package com.example.demo.controller;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CipherFunction {
	public static String cipher(String name13) throws GeneralSecurityException {
//与えられた文字に対して ASCII コードの変換を行う。
		StringBuilder result = new StringBuilder();
		// 文字列name13の各文字を処理する
		for (char word : name13.toCharArray()) {
			// 英小文字の場合は変換する
			if (Character.isLowerCase(word)) {
				result.append((char) (219 - (int) word));
			}
			// その他の文字はそのまま出力する
			else {
				result.append(word);
			}
		}

		return result.toString();
	}


	// 鍵の生成
	//	        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	//	        keyGenerator.init(128); // AES鍵サイズを指定
	//	        SecretKey secretKey = keyGenerator.generateKey();
	//
	//	        // 暗号化
	//	        Cipher cipher = Cipher.getInstance("AES");
	//	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	//	        byte[] encryptedBytes = null;
	//			try {
	//				encryptedBytes = cipher.doFinal(name13.getBytes("UTF-8"));
	//			} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
	//				// TODO 自動生成された catch ブロック
	//				e.printStackTrace();
	//			}
	//	        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

	//return encryptedText;

	public static String decodeCipher(String name14) throws Exception {
		// 鍵の生成（暗号化時と同じ鍵を使用）
		byte[] keyBytes = Base64.getDecoder().decode("GeneratedSecretKey"); // 実際には生成された鍵を使用
		SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

		// 復号化
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] encryptedBytes = Base64.getDecoder().decode(name14);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		String decryptedText = new String(decryptedBytes, "UTF-8");
		//		Charset charset = Charset.forName("UTF-8");
		//		String decodedCipher = new String(name14, charset);
		//		System.out.println(decodedCipher);
		return decryptedText;
	}
}
