package com.ds.i.dp;

public class Fibbonaci {

	public static void main(String[] args) {
		System.out.println(computeFibonacci(5));
	}

	public static Integer computeFibonacci(Integer input) {
		
		Integer previousNumber = 0;
		Integer currenNumber = 1;
		Integer sum = null;
		for (int i = 3; i <= input; i++) {
			sum = previousNumber + currenNumber;
			previousNumber = currenNumber;
			currenNumber = sum;
		}
		return sum;
	}
}
