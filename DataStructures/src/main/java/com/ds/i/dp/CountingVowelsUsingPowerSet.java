package com.ds.i.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CountingVowelsUsingPowerSet {
	static Set<Character> vowels = new HashSet<>();
	static Set<String> stringSet = new HashSet<>();

	static void getAllUniqueStringsWithOnlyOneVowel(char[] set, int set_size) {

		/*
		 * set_size of power set of a set with set_size n is (2**n -1)
		 */
		long pow_set_size = (long) Math.pow(2, set_size);
		int counter, j;

		/*
		 * Run from counter 000..0 to 111..1
		 */
		for (counter = 0; counter < pow_set_size; counter++) {
			StringBuilder sb = new StringBuilder();
			for (j = 0; j < set_size; j++) {
				/*
				 * Check if jth bit in the counter is set If set then print jth element from set
				 */
				if ((counter & (1 << j)) > 0)
					sb.append(Character.toString(set[j]));
			}
			updateSet(sb.toString());
			sb = null;
		}
	}

	// Driver program to test printPowerSet
	public static void main(String[] args) throws IOException {
		updateVowels();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		getAllUniqueStringsWithOnlyOneVowel(input.toCharArray(), input.length());
		System.out.println(stringSet.size());

	}

	private static void updateVowels() {
		String s = "AEIOUaeiou";
		char[] vowelsArray = s.toCharArray();
		for (char c : vowelsArray) {
			vowels.add(c);
		}
	}

	static void updateSet(String s) {
		int count = 0;
		for (char element : s.toCharArray()) {
			if (vowels.contains(element)) {
				count++;
			}
			if (count > 1)
				return;

		}
		if (count == 1)
			stringSet.add(s);
	}
}