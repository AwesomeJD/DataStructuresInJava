/*
 * @author Janardhan Sharma 
 */
package com.ds.e.bst;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class BinarySearchTreeTest.
 */
public class BinarySearchTreeTest {

	/** The bst. */
	private Tree<Integer> bst;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(2);
		bst.insert(5);

	}

	/**
	 * Test bst insert.
	 */
	@Test
	public void test_bst_insert() {
		// given

		// when

		// then
		assertThat(bst.size(), is(equalTo(3)));
	}

	/**
	 * Test bst insert existing element.
	 */
	@Test
	public void test_bst_insert_existing_element() {
		// given
		bst.insert(5);

		// when

		// then
		assertThat(bst.size(), is(equalTo(3)));
	}

	/**
	 * Test bst get max.
	 */
	@Test
	public void test_bst_get_max() {
		// given
		bst.insert(1000);

		// when
		Integer max = bst.getMax();

		// then
		assertThat(max, is(equalTo(1000)));
	}

	/**
	 * Test bst get min.
	 */
	@Test
	public void test_bst_get_min() {
		// given
		bst.insert(-22);

		// when
		Integer max = bst.getMin();

		// then
		assertThat(max, is(equalTo(-22)));
	}

	/**
	 * Test bst inorder traverse.
	 */
	@Test
	public void test_bst_inorder_traverse() {
		// given
		bst.clear();
		bst.insert(5);
		bst.insert(3);
		bst.insert(6);
		bst.insert(1);
		bst.insert(0);
		bst.insert(2);
		bst.insert(4);
		bst.insert(7);
		bst.insert(8);

		// when
		List<Integer> items = bst.toList();

		// then
		assertThat(items, containsInAnyOrder(0, 1, 2, 3, 4, 5, 6, 7, 8));
		assertThat(items, hasSize(new Integer(9)));
	}

	/**
	 * Test bst inorder traverse recursive.
	 */
	@Test
	public void test_bst_inorder_traverse_recursive() {
		// given
		Tree<Integer> bst = new BinarySearchTree<>(Traverse.RECURSIVE, TraverseOrder.INORDER);
		bst.insert(5);
		bst.insert(3);
		bst.insert(6);
		bst.insert(1);
		bst.insert(0);
		bst.insert(2);
		bst.insert(4);
		bst.insert(7);
		bst.insert(8);

		// when
		List<Integer> items = bst.toList();

		// then
		assertThat(items, containsInAnyOrder(0, 1, 2, 3, 4, 5, 6, 7, 8));
		assertThat(items, hasSize(new Integer(9)));
	}

	/**
	 * Test bst inorder traverse iterative preorder.
	 */
	@Test
	public void test_bst_inorder_traverse_iterative_preorder() {
		// given
		Tree<Integer> bst = new BinarySearchTree<>(Traverse.ITERAVTIVE, TraverseOrder.PREORDER);
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		bst.insert(0);
		bst.insert(2);
		bst.insert(4);
		bst.insert(6);
		bst.insert(8);

		// when
		List<Integer> items = bst.toList();

		// then
		assertThat(items, contains(5, 3, 1, 0, 2, 4, 7, 6, 8));
		assertThat(items, containsInAnyOrder(0, 1, 2, 3, 4, 5, 6, 7, 8));
		assertThat(items, hasSize(new Integer(9)));
	}

	/**
	 * Test bst inorder traverse recursive preorder.
	 */
	@Test
	public void test_bst_inorder_traverse_recursive_preorder() {
		// given
		Tree<Integer> bst = new BinarySearchTree<>(Traverse.RECURSIVE, TraverseOrder.PREORDER);
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		bst.insert(0);
		bst.insert(2);
		bst.insert(4);
		bst.insert(6);
		bst.insert(8);

		// when
		List<Integer> items = bst.toList();

		// then
		assertThat(items, contains(5, 3, 1, 0, 2, 4, 7, 6, 8));
		assertThat(items, containsInAnyOrder(0, 1, 2, 3, 4, 5, 6, 7, 8));
		assertThat(items, hasSize(new Integer(9)));
	}

	/**
	 * Test bst inorder traverse recursive postorder.
	 */
	@Test
	public void test_bst_inorder_traverse_recursive_postorder() {
		// given
		Tree<Integer> bst = new BinarySearchTree<>(Traverse.RECURSIVE, TraverseOrder.POSTORDER);
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		bst.insert(0);
		bst.insert(2);
		bst.insert(4);
		bst.insert(6);
		bst.insert(8);

		// when
		List<Integer> items = bst.toList();

		// then
		assertThat(items, contains(0, 2, 1, 4, 3, 6, 8, 7, 5));
		assertThat(items, containsInAnyOrder(0, 1, 2, 3, 4, 5, 6, 7, 8));
		assertThat(items, hasSize(new Integer(9)));
	}

	/**
	 * Test bst inorder traverse iterative postorder.
	 */
	@Test
	public void test_bst_inorder_traverse_iterative_postorder() {
		// given
		Tree<Integer> bst = new BinarySearchTree<>(Traverse.ITERAVTIVE, TraverseOrder.POSTORDER);
		bst.insert(10);
		bst.insert(15);
		bst.insert(16);
		bst.insert(13);
		bst.insert(12);
		bst.insert(14);
		bst.insert(5);
		bst.insert(7);
		bst.insert(6);
		bst.insert(8);
		bst.insert(3);
		bst.insert(1);
		bst.insert(4);

		// when
		List<Integer> items = bst.toList();

		// then
		assertThat(items, contains(1, 4, 3, 6, 8, 7, 5, 12, 14, 13, 16, 15, 10));
		assertThat(items, containsInAnyOrder(1, 4, 3, 6, 8, 7, 5, 12, 14, 13, 16, 15, 10));
		assertThat(items, hasSize(new Integer(13)));
	}

	/**
	 * Test bst delete leaf node.
	 */
	@Test
	public void test_bst_delete_leaf_node() {
		// given
		Tree<Integer> bst = new BinarySearchTree<>(Traverse.ITERAVTIVE, TraverseOrder.INORDER);
		bst.insert(10);
		bst.insert(15);
		bst.insert(16);
		bst.insert(13);
		bst.insert(12);
		bst.insert(14);
		bst.insert(5);
		bst.insert(7);
		bst.insert(6);
		bst.insert(8);
		bst.insert(3);
		bst.insert(1);
		bst.insert(4);
		bst.insert(17);

		// when

		bst.delete(17);
		List<Integer> items = bst.toList();

		// then
		assertThat(items, contains(1, 3, 4, 5, 6, 7, 8, 10, 12, 13, 14, 15, 16));
		assertThat(items, containsInAnyOrder(1, 3, 4, 5, 6, 7, 8, 10, 12, 13, 14, 15, 16));
		assertThat(items, hasSize(new Integer(13)));
	}

	/**
	 * Test bst delete node with one children.
	 */
	@Test
	public void test_bst_delete_node_with_one_children() {
		// given
		Tree<Integer> bst = new BinarySearchTree<>(Traverse.ITERAVTIVE, TraverseOrder.INORDER);
		bst.insert(10);
		bst.insert(15);
		bst.insert(16);
		bst.insert(13);
		bst.insert(12);
		bst.insert(14);
		bst.insert(5);
		bst.insert(7);
		bst.insert(6);
		bst.insert(8);
		bst.insert(3);
		bst.insert(1);
		bst.insert(4);
		bst.insert(17);

		// when

		bst.delete(16);
		List<Integer> items = bst.toList();

		// then
		assertThat(items, contains(1, 3, 4, 5, 6, 7, 8, 10, 12, 13, 14, 15, 17));
		assertThat(items, containsInAnyOrder(1, 3, 4, 5, 6, 7, 8, 10, 12, 13, 14, 15, 17));
		assertThat(items, hasSize(new Integer(13)));
	}

	/**
	 * Test bst delete with two children.
	 */
	@Test
	public void test_bst_delete_with_two_children() {
		// given
		Tree<Integer> bst = new BinarySearchTree<>(Traverse.ITERAVTIVE, TraverseOrder.INORDER);
		bst.insert(10);
		bst.insert(15);
		bst.insert(16);
		bst.insert(13);
		bst.insert(12);
		bst.insert(14);
		bst.insert(5);
		bst.insert(7);
		bst.insert(6);
		bst.insert(8);
		bst.insert(3);
		bst.insert(1);
		bst.insert(4);
		bst.insert(17);

		// when

		bst.delete(13);
		List<Integer> items = bst.toList();

		// then
		assertThat(items, contains(1, 3, 4, 5, 6, 7, 8, 10, 12, 14, 15, 16, 17));
		assertThat(items, containsInAnyOrder(1, 3, 4, 5, 6, 7, 8, 10, 12, 14, 15, 16, 17));
		assertThat(items, hasSize(new Integer(13)));
	}

	/**
	 * Test bst inorder traverse.
	 */
	@Test
	public void test_bst_kth_element() {
		// given
		bst.clear();
		bst.insert(5);
		bst.insert(3);
		bst.insert(6);
		bst.insert(1);
		bst.insert(0);
		bst.insert(2);
		bst.insert(4);
		bst.insert(7);
		bst.insert(8);

		// when
		int third = bst.getKthElement(3);
		int fifth = bst.getKthElement(5);

		// then
		assertThat(third, is(equalTo(2)));
		assertThat(fifth, is(equalTo(4)));
	}

}
