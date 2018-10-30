package com.ds.i.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class SubString {
	static Set<Character> vowels = new HashSet<>();

	public static void main(String args[]) throws Exception {
		updateVowels();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		Set<String> stringSet = new HashSet<String>();
		getAllUniqueStringsWithOnlyOneVowel(input, stringSet);
		System.out.println(stringSet.size());

	}

	private static void updateVowels() {
		String s = "AEIOUaeiou";
		char[] vowelsArray = s.toCharArray();
		for (char c : vowelsArray) {
			vowels.add(c);
		}
	}

	static void getAllUniqueStringsWithOnlyOneVowel(String string, Set<String> stringSet) {
		if (!stringSet.contains(string)) {
			if (string.length() == 1) {
				updateSet(string, stringSet);
			} else {
				for (int i = 0; i < (string.length()); i++) {
					if (i == 0) {
						getAllUniqueStringsWithOnlyOneVowel(string.substring(i + 1, string.length()), stringSet);
					} else if (i == (string.length() - 1)) {
						getAllUniqueStringsWithOnlyOneVowel(string.substring(0, i), stringSet);
					} else {
						getAllUniqueStringsWithOnlyOneVowel(
								string.substring(0, i) + string.substring(i + 1, string.length()), stringSet);
					}
				}
				updateSet(string, stringSet);
			}
		}
	}

	static void updateSet(String s, Set<String> set) {
		int count = 0;
		for (char element : s.toCharArray()) {
			if (vowels.contains(element)) {
				count++;
			}
			if (count > 1)
				return;

		}
		if (count == 1)
			set.add(s);
	}
}
