/*
 * @author Janardhan Sharma 
 */
package com.ds.f.substring.search;

/**
 * The Class BruteForceSearchAlgo.
 */
public class BruteForceSearchAlgo {

	/**
	 * Search sub string.
	 *
	 * @param text the text
	 * @param subString the sub string
	 * @return the integer
	 */
	public Integer searchSubString(String text, String subString) {

		Integer lengthOfText = text.length();
		Integer lengthOfSubstring = subString.length();

		for (int i = 0; i < lengthOfText - lengthOfSubstring; i++) {

			for (int j = 0; j < lengthOfSubstring; j++) {

				if (text.charAt(i + j) != subString.charAt(j)) {
					break;
				}
				if (j == lengthOfSubstring - 1) {
					return i;
				}
			}
		}
		return -1;
	}
}
