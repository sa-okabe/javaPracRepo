package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NgramFunction {
	public static List<String> generateBiGrams(String name6) {
		List<String> biGrams = new ArrayList<>();
		//文字列を単語に分割する
		String[] words = name6.split("\\s+"); 
		//単語間に空白を挿入してbi-gramを生成〜
		for (int i = 0; i < words.length - 1; i++) {
			String biGram = words[i] + " " + words[i + 1]; 
			biGrams.add(biGram);
		}

		return biGrams;
	}

	public static Set<String> produceBiGrams(String name7) {
		Set<String> biGrams = new HashSet<>();
		for (int i = 0; i < name7.length() - 1; i++) {
			biGrams.add(name7.substring(i, i + 2));
		}
		return biGrams;
	}

	public static Set<String> produceBiGrams2(String name8) {
		Set<String> biGrams = new HashSet<>();
		for (int i = 0; i < name8.length() - 1; i++) {
			biGrams.add(name8.substring(i, i + 2));
		}
		return biGrams;
	}

}
