package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolFunction {
	public static Integer SymbolLogic(String name5) {
		List<String> symbolRowList = new ArrayList<>();
		String strangeProse = "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can";
		String[] words = strangeProse.split("\\s+"); // 文字列を単語に分割する
		Map<String, Integer> symbolMap = new HashMap<String, Integer>();
		Integer result = 0;

		for (String symbols : words) {
			symbolRowList.add(symbols);
		}
		//1文字め取得するリスト
		symbolMap.put(symbolRowList.get(0), 1);
		symbolMap.put(symbolRowList.get(4), 5);
		symbolMap.put(symbolRowList.get(5), 6);
		symbolMap.put(symbolRowList.get(6), 7);
		symbolMap.put(symbolRowList.get(7), 8);
		symbolMap.put(symbolRowList.get(8), 9);
		symbolMap.put(symbolRowList.get(14), 15);
		symbolMap.put(symbolRowList.get(15), 16);
		symbolMap.put(symbolRowList.get(18), 19);

		//2文字め取得するリスト
		symbolMap.put(symbolRowList.get(1), 2);
		symbolMap.put(symbolRowList.get(2), 3);
		symbolMap.put(symbolRowList.get(3), 4);
		symbolMap.put(symbolRowList.get(9), 10);
		symbolMap.put(symbolRowList.get(10), 11);
		symbolMap.put(symbolRowList.get(11), 12);
		symbolMap.put(symbolRowList.get(12), 13);
		symbolMap.put(symbolRowList.get(13), 14);
		symbolMap.put(symbolRowList.get(16), 17);
		symbolMap.put(symbolRowList.get(17), 18);

		if (symbolMap.containsKey(name5)) {
			int value = symbolMap.get(name5);
			result = value;	
		}

		return result;
	}
}
