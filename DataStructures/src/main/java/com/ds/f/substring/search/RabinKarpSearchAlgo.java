/*
 * @author Janardhan Sharma 
 */
package com.ds.f.substring.search;

/**
 * The Class RabinKarpSearchAlgo.
 */
public class RabinKarpSearchAlgo {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		System.out.println(searchString("adbabcABCashgdaccFeghjdsadasfabc", "ABC"));
	}

	/**
	 * Search string.
	 *
	 * @param text      the text
	 * @param subString the sub string
	 * @return the int
	 */
	public static int searchString(String text, String subString) {

		int subStringLength = subString.length();
		int originalSubStringHashCode = getHash(subString);

		for (byte i = 0; i <= text.length() - subStringLength; i++) {
			String localSubString = text.substring(i, subStringLength + i);
			int localHashCode = getHash(localSubString);

			if (originalSubStringHashCode == localHashCode && localSubString.equals(subString)) {
				return i;
			}

		}
		return -1;
	}

	/**
	 * Gets the hash.
	 *
	 * @param subString the sub string
	 * @return the hash
	 */
	// gets the hash code, as per mentioned by Rabin Karp : for abc it should be [(1
	// * 10^2) + (2 * 10 ^ 1) + (3 * 10 ^ 0)]
	public static int getHash(String subString) {
		char[] values = subString.toCharArray();
		int returnValue = 0;
		for (int i = values.length - 1; i >= 0; i--) {
			returnValue = returnValue + ((int) Math.pow(10, i) * getIntValueOfCharacter(values[values.length - 1 - i]));
		}
		return returnValue;
	}

	/**
	 * Gets the int value of character.
	 *
	 * @param character the character
	 * @return the int value of character
	 */
	// custom method to get the int value for every character a-b and A-Z
	public static int getIntValueOfCharacter(char character) {
		int value = character;
		if (90 >= value && value >= 65) {
			return value - 64;
		} else if (122 >= value && value >= 97) {
			return value - 96;
		} else {
			throw new RuntimeException("Invalid Character detected.");
		}
	}
}
