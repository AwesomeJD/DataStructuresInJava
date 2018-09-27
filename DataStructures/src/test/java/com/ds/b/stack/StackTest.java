/*
 * @author Janardhan Sharma 
 */
package com.ds.b.stack;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * The Class StackTest.
 */
public class StackTest {

	/**
	 * Test stack push method.
	 */
	@Test
	public void test_stack_push_method() {
		// given
		Stack<Integer> stack = new Stack<>();
		// when
		stack.push(5);
		stack.push(6);

		// then
		assertThat(stack.size(), is(equalTo(2)));
	}

	/**
	 * Test stack pop method.
	 */
	@Test
	public void test_stack_pop_method() {
		// given
		Stack<Integer> stack = new Stack<>();
		// when
		stack.push(10);
		stack.push(20);

		// then
		assertThat(stack.pop(), is(equalTo(20)));
		assertThat(stack.pop(), is(equalTo(10)));
	}

	/**
	 * Test stack pop on empty.
	 */
	@Test
	public void test_stack_pop_on_empty() {
		// given
		Stack<Integer> stack = new Stack<>();
		// when

		// then
		assertThat(stack.pop(), is(equalTo(null)));
	}
}
