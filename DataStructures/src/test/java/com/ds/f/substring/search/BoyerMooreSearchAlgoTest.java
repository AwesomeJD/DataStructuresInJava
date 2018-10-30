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
 * The Class BoyerMooreSearchAlgoTest.
 */
public class BoyerMooreSearchAlgoTest {

	/**
	 * Test substring search.
	 */
	@Test
	public void test_substring_search() {
		// given
		BoyerMooreSearchAlgo algo = new BoyerMooreSearchAlgo();
		String text = "Elephant";
		String subString = "an";

		// when
		Integer index = algo.searchString(text, subString);

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
		BoyerMooreSearchAlgo algo = new BoyerMooreSearchAlgo();
		String text = "aseudsadsadsadsadsadsadsadsadasdasretretreuio";
		String subString = "eu";

		// when
		Integer index = algo.searchString(text, subString);

		// then
		assertThat(index, not(equalTo(-1)));
		assertThat(index, is(equalTo(2)));

	}

}
