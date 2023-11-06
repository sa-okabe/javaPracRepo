package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

public class SymbolFunction {
	public static Integer SymbolLogic(String name5) {
		//		List<String> symbolRowList = new ArrayList<>();
		//		List<String> symbolFirstList = new ArrayList<>();
		//		List<String> symbolSecondList = new ArrayList<>();
		String strangeProse = "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can";
		String[] words = strangeProse.split("\\s+"); // 文字列を単語に分割する
		//Map<String, Integer> firstMap = new HashMap<String, Integer>();
		Map<String, Integer> symbolMap = new HashMap<String, Integer>();
		String firstString = "";
		Integer result = 0;

		for (String first : words) {
			for (int i = 0; i < first.length(); i++) {
				if (first.contains("Hi") || first.contains("Boron") || first.contains("Could") || first.contains("Not")
						|| first.contains("Oxidize") || first.contains("Fluorine") || first.contains("Peace")
						|| first.contains("Security") || first.contains("King")) {
					char firstChar = first.charAt(0);
					firstString = String.valueOf(firstChar);
					symbolMap.put(firstString, i + 1);
				} else {
					String secondChar = first.substring(0, 2);
					symbolMap.put(secondChar, i + 1);
					System.out.println("secondCharの中身は" + secondChar);
				}
			}
		}
		System.out.println("Mapの中身は..." + symbolMap);
		//
		//		for (String symbols : words) {
		//			symbolRowList.add(symbols);
		//		}
		//		//1文字め取得するリスト
		//		symbolFirstList.add(symbolRowList.get(0));
		//		symbolFirstList.add(symbolRowList.get(4));
		//		symbolFirstList.add(symbolRowList.get(5));
		//		symbolFirstList.add(symbolRowList.get(6));
		//		symbolFirstList.add(symbolRowList.get(7));
		//		symbolFirstList.add(symbolRowList.get(8));
		//		symbolFirstList.add(symbolRowList.get(14));
		//		symbolFirstList.add(symbolRowList.get(15));
		//		symbolFirstList.add(symbolRowList.get(18));
		//
		//		//System.out.println(symbolFirstList);
		//
		//		//2文字め取得するリスト
		//		symbolSecondList.add(symbolRowList.get(1));
		//		symbolSecondList.add(symbolRowList.get(2));
		//		symbolSecondList.add(symbolRowList.get(3));
		//		symbolSecondList.add(symbolRowList.get(9));
		//		symbolSecondList.add(symbolRowList.get(10));
		//		symbolSecondList.add(symbolRowList.get(11));
		//		symbolSecondList.add(symbolRowList.get(12));
		//		symbolSecondList.add(symbolRowList.get(13));
		//		symbolSecondList.add(symbolRowList.get(16));
		//		symbolSecondList.add(symbolRowList.get(17));
		//
		//		//System.out.println(symbolSecondList);
		//
		//		for (String first : symbolFirstList) {
		//			for (int i = 0; i < first.length(); i++) {
		//				char firstChar = first.charAt(0);
		//				String firstString = String.valueOf(firstChar);
		//				firstMap.put(firstString, i + 1);
		//			}
		//		}
		//		System.out.println(firstMap);
		//
		//		for (String second : symbolSecondList) {
		//			String secondChar = second.substring(0, 1);
		//		}
		//		
		if (symbolMap.containsKey(name5)) {
			int value = symbolMap.get(name5);
			result = value;
		}

		System.out.println("結果は" + result);

		return result;
	}
}
