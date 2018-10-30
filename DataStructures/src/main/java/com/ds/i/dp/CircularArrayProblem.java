package com.ds.i.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularArrayProblem {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String length = br.readLine();
		int[] intArray = new int[Integer.parseInt(length)];

		String inputString = br.readLine();
		String[] inputStringArray = inputString.split(" ");
		for (int i = 0; i < inputStringArray.length; i++) {
			intArray[i] = Integer.parseInt(inputStringArray[i]);
		}

		int sum = Integer.MAX_VALUE;
		int lengthDividedBy2 = intArray.length / 2;
		for (int i = 0; i < intArray.length; i++) {

			int currentSum = 0;
			for (int j = 0; j < lengthDividedBy2; j++) {
				if (j + i >= intArray.length) {
					break;
				}
				currentSum = currentSum + intArray[j + i];
			}

			int m = i - lengthDividedBy2;
			if (m > 0) {

				for (int k = 0; k < m; k++) {
					currentSum = currentSum + intArray[k];
				}
			}

			if (currentSum < sum) {
				sum = currentSum;
			}
		}

		System.out.println(sum);
	}
}
