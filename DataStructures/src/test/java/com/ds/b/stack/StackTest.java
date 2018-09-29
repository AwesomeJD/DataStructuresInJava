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
		Stack<Integer> stack = new LinkedListStack<>();
		// when
		stack.push(5);
		stack.push(6);
		stack.push(10);

		// then
		assertThat(stack.size(), is(equalTo(3)));
	}

	/**
	 * Test stack pop method.
	 */
	@Test
	public void test_stack_pop_method() {
		// given
		Stack<Integer> stack = new LinkedListStack<>();
		// when
		stack.push(10);
		stack.push(20);
		stack.push(200);
		stack.push(500);
		stack.push(1000);
		
		// then
		assertThat(stack.pop(), is(equalTo(1000)));
		assertThat(stack.pop(), is(equalTo(500)));
		assertThat(stack.pop(), is(equalTo(200)));
		assertThat(stack.pop(), is(equalTo(20)));
		assertThat(stack.pop(), is(equalTo(10)));
	}

	/**
	 * Test stack pop on empty.
	 */
	@Test
	public void test_stack_pop_on_empty() {
		// given
		Stack<Integer> stack = new LinkedListStack<>();
		// when

		// then
		assertThat(stack.pop(), is(equalTo(null)));
	}
}
