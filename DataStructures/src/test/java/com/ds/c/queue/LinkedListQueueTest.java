package com.ds.c.queue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class LinkedListQueueTest {
	/**
	 * Test stack push method.
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
	 * Test stack pop method.
	 */
	@Test
	public void test_queue_poll_method() {
		// given
		Queue<Integer> queue = new LinkedListQueue<>();
		// when
		queue.push(10);
		queue.push(20);
		queue.push(1000);

		// then
		assertThat(queue.size(), is(equalTo(3)));
		assertThat(queue.poll(), is(equalTo(10)));
		assertThat(queue.poll(), is(equalTo(20)));
		assertThat(queue.poll(), is(equalTo(1000)));
		assertThat(queue.size(), is(equalTo(0)));
		assertThat(queue.isEmpty(), is(Boolean.TRUE));
	}

	/**
	 * Test stack pop on empty.
	 */
	@Test
	public void test_poll_on_empty() {
		// given
		Queue<Integer> queue = new LinkedListQueue<>();
		// when

		// then
		assertThat(queue.poll(), is(equalTo(null)));
	}
}
