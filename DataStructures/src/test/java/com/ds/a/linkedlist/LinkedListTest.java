/*
 * @author Janardhan Sharma 
 */
package com.ds.a.linkedlist;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ds.a.common.Node;

/**
 * The Class LinkedListTest.
 */
public class LinkedListTest {

	/** The list. */
	public List<Integer> list;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		list = new LinkedList<>();
		System.out.println("Initialize");
	}

	/**
	 * Clean up.
	 */
	@After
	public void cleanUp() {
		list = null;
		System.out.println("Clean Up");

	}

	/**
	 * Test linked list add method.
	 */
	@Test
	public void test_linked_list_add_method() {
		// given

		// when
		list.add(5);
		list.add(6);

		// then
		list.traverse();
		assertThat(list.size(), is(equalTo(2)));
	}

	/**
	 * Test linked list remove method.
	 */
	@Test
	public void test_linked_list_remove_method() {
		// given
		list.add(6);
		list.add(7);

		// when
		list.remove(6);

		// then
		list.traverse();
		assertThat(list.size(), is(equalTo(1)));
	}

	/**
	 * Test linked list remove on empty list.
	 */
	@Test
	public void test_linked_list_remove_on_empty_list() {
		// given

		// when
		list.remove(6);

		// then
		assertThat(list.size(), is(equalTo(0)));
	}

	/**
	 * Test linked list remove having single element.
	 */
	@Test
	public void test_linked_list_remove_having_single_element() {
		// given
		list.add(7);

		// when
		list.remove(7);

		// then
		list.traverse();
		assertThat(list.size(), is(equalTo(0)));
	}

	/**
	 * Test linked list is present positive.
	 */
	@Test
	public void test_linked_list_is_present_positive() {
		// given
		list.add(10);

		// when
		Boolean check = list.isPresent(10);

		// then
		list.traverse();
		assertThat(check, is(Boolean.TRUE));
	}

	/**
	 * Test linked list is present negative.
	 */
	@Test
	public void test_linked_list_is_present_negative() {
		// given
		list.add(10);

		// when
		Boolean check = list.isPresent(77);

		// then
		list.traverse();
		assertThat(check, is(Boolean.FALSE));
		assertThat(list.size(), is(equalTo(1)));
	}

	/**
	 * Test linked list get node.
	 */
	@Test
	public void test_linked_list_get_node() {
		// given
		list.add(10);

		// when
		Node<Integer> node = list.getNode(10);

		// then
		list.traverse();
		assertThat(node.toString(), is(equalTo("10")));
	}

}
