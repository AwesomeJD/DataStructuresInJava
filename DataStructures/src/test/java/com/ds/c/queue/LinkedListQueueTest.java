/*
 * @author Janardhan Sharma 
 */
package com.ds.c.queue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * The Class LinkedListQueueTest.
 */
public class LinkedListQueueTest {

	/**
	 * Test queue push method.
	 */
	@Test
	public void test_queue_push_method() {
		// given
		Queue<Integer> queue = new LinkedListQueue<>();
		// when
		queue.push(5);
		queue.push(6);

		// then
		assertThat(queue.size(), is(equalTo(2)));
	}

	/**
	 * Test queue poll method.
	 */
	@Test
	public void test_queue_poll_method() {
		// given
		Queue<Integer> queue = new LinkedListQueue<>();
		// when
		queue.push(10);
		queue.push(20);
		queue.push(1000);
		queue.push(1010);
		queue.push(1020);

		// then
		assertThat(queue.size(), is(equalTo(5)));
		assertThat(queue.poll(), is(equalTo(10)));
		assertThat(queue.poll(), is(equalTo(20)));
		assertThat(queue.poll(), is(equalTo(1000)));
		assertThat(queue.poll(), is(equalTo(1010)));
		assertThat(queue.poll(), is(equalTo(1020)));
		assertThat(queue.size(), is(equalTo(0)));
		assertThat(queue.isEmpty(), is(Boolean.TRUE));
	}

	/**
	 * Test poll on empty.
	 */
	@Test
	public void test_poll_on_empty() {
		// given
		Queue<Integer> queue = new LinkedListQueue<>();
		// when

		// then
		assertThat(queue.poll(), is(equalTo(null)));
	}

	/**
	 * Test peek.
	 */
	@Test
	public void test_peek() {
		// given
		Queue<Integer> queue = new LinkedListQueue<>();
		
		// when
		
		queue.push(1000);
		queue.push(100);
		queue.push(10);
		
		queue.poll();
		queue.poll();
		
		// then
		assertThat(queue.peek(), is(equalTo(10)));
		assertThat(queue.size(), is(equalTo(1)));
		
	}
	
	/**
	 * Test when size is made to zero and elements pushed peek.
	 */
	@Test
	public void test_when_size_is_made_to_zero_and_elements_pushed_peek() {
		// given
		Queue<Integer> queue = new LinkedListQueue<>();
		
		// when
		
		queue.push(1000);
		queue.push(100);
		queue.push(10);
		
		queue.poll();
		queue.poll();
		queue.poll();
		
		queue.push(5);
		
		// then
		assertThat(queue.size(), is(equalTo(1)));
		assertThat(queue.poll(), is(equalTo(5)));
		assertThat(queue.size(), is(equalTo(0)));
		
	}
}
