/*
 * @author Janardhan Sharma 
 */
package com.ds.f.substring.search;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class BoyerMooreSearchAlgo.
 */
public class BoyerMooreSearchAlgo {

	/** The bad match table. */
	private Map<Character, Integer> badMatchTable = new HashMap<>();

	/** The sub string. */
	private String subString;

	/**
	 * Search string.
	 *
	 * @param text      the text
	 * @param subString the sub string
	 * @return the integer
	 */
	public Integer searchString(String text, String subString) {
		this.subString = subString;

		if (text == null || subString == null) {
			return -1;
		}
		loadBadMatchTable(subString);

		int shiftCounter = 0;
		int subStringLength = subString.length();

		for (int outerLoop = subStringLength - 1; outerLoop < text.length(); outerLoop += shiftCounter) {

			for (int innerLoop = subStringLength - 1; innerLoop >= 0; innerLoop--) {
				if (text.charAt(outerLoop - (subStringLength - 1 - innerLoop)) != subString.charAt(innerLoop)) {
					shiftCounter = getBadMatchValue(text.charAt(outerLoop));
					break;
				}
				if (innerLoop == 0)
					return outerLoop - (subStringLength - 1);
			}
		}
		return -1;
	}

	/**
	 * Load bad match table.
	 *
	 * @param subString the sub string
	 */
	private void loadBadMatchTable(String subString) {
		for (int i = 0; i < subString.length(); i++) {
			Integer value = Math.max(1, subString.length() - i - 1);
			this.badMatchTable.put(subString.charAt(i), value);
		}
	}

	/**
	 * Gets the bad match value.
	 *
	 * @param charAtIndex the char at index
	 * @return the bad match value
	 */
	private Integer getBadMatchValue(Character charAtIndex) {
		if (badMatchTable.containsKey(charAtIndex)) {
			return badMatchTable.get(charAtIndex);
		}
		return subString.length();
	}

}
