package com.example.demo.controller;

import java.security.GeneralSecurityException;

public class CipherFunction {
	public static String cipher(String name13) throws GeneralSecurityException {
		//与えられた文字に対してASCIIコードの変換を行う。
		StringBuilder result = new StringBuilder();
		for (char word : name13.toCharArray()) {
			if (Character.isLowerCase(word)) {
				result.append((char) (219 - (int) word));
			}
			else {
				result.append(word);
			}
		}
		return result.toString();
	}

}
