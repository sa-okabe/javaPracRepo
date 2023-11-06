package com.example.demo.controller;

import java.security.GeneralSecurityException;

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

}
