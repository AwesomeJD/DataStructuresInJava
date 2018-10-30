/*
 * @author Janardhan Sharma 
 */
package com.ds.f.substring.search;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * The Class BruteForceSearchAlgoTest.
 */
public class BruteForceSearchAlgoTest {

	/**
	 * Test substring search.
	 */
	@Test
	public void test_substring_search() {
		// given
		BruteForceSearchAlgo algo = new BruteForceSearchAlgo();
		String text = "Elephant";
		String subString = "an";
		
		
		// when
		Integer index = algo.searchSubString(text, subString);
		
		
		// then
		assertThat(index, not(equalTo(-1)));
		assertThat(index, is(equalTo(5)));

	}

	
	/**
	 * Test substring search long.
	 */
	@Test
	public void test_substring_search_long() {
		// given
		BruteForceSearchAlgo algo = new BruteForceSearchAlgo();
		String text = "aseudsadsadsadsadsadsadsadsadasdasretretreuio";
		String subString = "eu";
		
		
		// when
		Integer index = algo.searchSubString(text, subString);
		
		
		// then
		assertThat(index, not(equalTo(-1)));
		assertThat(index, is(equalTo(2)));

	}

	
}
