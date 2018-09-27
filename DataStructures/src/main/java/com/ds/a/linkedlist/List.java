/*
 * @author Janardhan Sharma 
 */
package com.ds.a.linkedlist;

import com.ds.a.common.Node;

/**
 * The Interface List.
 *
 * @param <T> the generic type
 */
public interface List<T> {

	/**
	 * Adds the.
	 *
	 * @param value the value
	 */
	public void add(T value);

	/**
	 * Removes the.
	 *
	 * @param value the value
	 */
	public void remove(T value);

	/**
	 * Gets the node.
	 *
	 * @param value the value
	 * @return the node
	 */
	public Node<T> getNode(T value);

	/**
	 * Traverse.
	 */
	public void traverse();

	/**
	 * Checks if is present.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	public Boolean isPresent(T value);

	/**
	 * Size.
	 *
	 * @return the integer
	 */
	public Integer size();
}
