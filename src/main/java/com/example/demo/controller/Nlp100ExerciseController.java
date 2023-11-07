package com.example.demo.controller;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Nlp100ExerciseController {
	/** 入力画面を表示する */
	@GetMapping("show")
	public String showView() {
		//戻り値は「ビュー名を返す」
		return "entry";
	}

	/** 問1の画面を表示する */
	@PostMapping(value = "confirm", params = "no0")
	public String confirmView(Model model, @RequestParam String name) {
		String result = new StringBuilder(name).reverse().toString();
		//Modelに格納する
		model.addAttribute("name", result);

		//戻り値は「ビュー名」を返す。
		return "confirm";

	}

	/** 問1を表示する */
	@PostMapping(value = "confirm2", params = "no1")
	public String solutionA(Model model, @RequestParam String name2) {
		String str1 = name2.substring(1, 2);
		String str2 = name2.substring(3, 4);
		String str3 = name2.substring(5, 6);
		String str4 = name2.substring(7, 8);

		StringBuffer sb = new StringBuffer();
		sb.append(str1);
		sb.append(str2);
		sb.append(str3);
		sb.append(str4);
		String ans = sb.toString();

		model.addAttribute("ans2", ans);

		return "confirm2";
	}

	/** 問2を表示する */
	@PostMapping(value = "confirm3", params = "no2")
	public String solutionB(Model model, @RequestParam String name3) {
		String str1 = name3.substring(0, 1);
		String str2 = name3.substring(4, 5);
		String str3 = name3.substring(1, 2);
		String str4 = name3.substring(5, 6);
		String str5 = name3.substring(2, 3);
		String str6 = name3.substring(6, 7);
		String str7 = name3.substring(3, 4);
		String str8 = name3.substring(7, 8);

		StringBuffer sb = new StringBuffer();
		sb.append(str1);
		sb.append(str2);
		sb.append(str3);
		sb.append(str4);
		sb.append(str5);
		sb.append(str6);
		sb.append(str7);
		sb.append(str8);
		String ans = sb.toString();

		model.addAttribute("ans3", ans);

		return "confirm3";
	}

	/** 問3を表示する */
	@PostMapping(value = "confirm4", params = "no3")
	public String solutionC(Model model, @RequestParam String name4) {
		ArrayList<Integer> resultList = new ArrayList<>();
		String[] sp1 = name4.split("[,\\s]+");
		for (int i = 0; i < sp1.length; i++) {
			int length = sp1[i].length();
			resultList.add(length);
		}
		model.addAttribute("ans4", resultList);

		return "comfirm4";
	}

	/** 問4を表示する */
	@PostMapping(value = "confirm5", params = "no4")
	public String solutionD(Model model, @RequestParam String name5) {
		Integer num = SymbolFunction.SymbolLogic(name5);

		model.addAttribute("ans5", num);

		return "confirm5";

	}

	/** 問5を表示する */
	@PostMapping(value = "confirm6", params = "no5")
	public String solutionE(Model model, @RequestParam String name6) {
		List<String> biGrams = NgramFunction.generateBiGrams(name6);
		ArrayList<String> resultBigrams = new ArrayList<>();

		for (String biGram : biGrams) {
			System.out.println(biGram);
			resultBigrams.add(biGram);
		}
		model.addAttribute("ans6", resultBigrams);

		return "confirm6";

	}

	/** 問6を表示する */
	@PostMapping(value = "confirm7", params = "no6")
	public String solutionF(Model model, @RequestParam String name7, String name8, String name9) {

		// 文字bi-gramの集合 X と Y を生成
		Set<String> X = NgramFunction.produceBiGrams(name7);
		Set<String> Y = NgramFunction.produceBiGrams2(name8);

		// 和集合を計算
		Set<String> union = new HashSet<>(X);
		union.addAll(Y);

		// 積集合を計算(X ∩ Y)
		Set<String> intersection = new HashSet<>(X);
		intersection.retainAll(Y);

		// 差集合を計算(-)
		Set<String> differences = new HashSet<>(X);
		differences.removeAll(Y);

		// 'se' の存在チェック
		String ans10 = "";
		String ans11 = "";
		boolean seInX = X.contains(name9);
		boolean seInY = Y.contains(name9);
		if (seInX) {
			ans10 = "る";
		} else {
			ans10 = "ない";
		}

		if (seInY) {
			ans11 = "る";
		} else {
			ans11 = "ない";
		}

		model.addAttribute("ans7", union);
		model.addAttribute("ans8", intersection);
		model.addAttribute("ans9", differences);
		model.addAttribute("ans10", ans10);
		model.addAttribute("ans11", ans11);

		return "confirm7";

	}

	/** 問7を表示する */
	@PostMapping(value = "confirm8", params = "no7")
	public String solutionG(Model model, @RequestParam String name10, String name11, String name12) {

		model.addAttribute("ans12", name10);
		model.addAttribute("ans13", name11);
		model.addAttribute("ans14", name12);

		return "confirm8";

	}

	/** 問8を表示する(暗号化Ver) 
	 * @throws Exception */
	@PostMapping(value = "confirm9", params = "no8")
	public String solutionH(Model model, @RequestParam String name13) throws Exception {
		String encryptedText = CipherFunction.cipher(name13);
		
		model.addAttribute("ans15", encryptedText);
		
		return "confirm9";
	}

	/** 問8を表示する(復号化Ver) 
	 * @throws GeneralSecurityException 
	 * @throws Exception */
	@PostMapping(value = "confirm10", params = "no9")
	public String solutionI(Model model, @RequestParam String name14) throws GeneralSecurityException {
		String decryptedText = CipherFunction.cipher(name14);
		
		model.addAttribute("ans16", decryptedText);
		
		return "confirm10";
	}

	/** 問9を表示する */
	@PostMapping(value = "confirm11", params = "no10")
	public String solutionJ(Model model, @RequestParam String name15) {
		String resultSentense = "";
		List<String> shuffledSentense = TypoglycemiaFuction.typoLogic(name15);
		
		for (String result : shuffledSentense) {
			resultSentense += result + " ";
		}
		
		model.addAttribute("ans17", resultSentense);

		return "confirm11";
	}

}
