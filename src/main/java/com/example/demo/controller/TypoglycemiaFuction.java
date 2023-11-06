package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypoglycemiaFuction {
	public static List<String> typoLogic(String name15) {
		String[] words = name15.split("\\s+"); //分割

		List<String> shuffledCharacters = new ArrayList<>();

		for (String word : words) {
			//4文字未満は除外
			if (word.length() > 4) {
				// 先頭と末尾の文字を保持
				char firstChar = word.charAt(0);
				char lastChar = word.charAt(word.length() - 1);

				// 中身をシャッフル
				List<Character> middleChars = new ArrayList<>();
				for (int i = 1; i < word.length() - 1; i++) {
					middleChars.add(word.charAt(i));
				}
				Collections.shuffle(middleChars);

				// 新しい単語を組み立て
				StringBuilder shuffledCharacter = new StringBuilder();
				shuffledCharacter.append(firstChar);
				for (char middleChar : middleChars) {
					shuffledCharacter.append(middleChar);
				}
				shuffledCharacter.append(lastChar);

				shuffledCharacters.add(shuffledCharacter.toString());
			} else {
				shuffledCharacters.add(word);
			}
		}

		System.out.println(shuffledCharacters);

		return shuffledCharacters;
	}
}
