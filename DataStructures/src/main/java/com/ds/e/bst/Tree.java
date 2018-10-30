/*
 * @author Janardhan Sharma 
 */
package com.ds.e.bst;

import java.util.List;

/**
 * The Interface Tree.
 *
 * @param <T> the generic type
 */
public interface Tree<T> {

	/**
	 * To list.
	 *
	 * @return the list
	 */
	public List<T> toList();

	/**
	 * Insert.
	 *
	 * @param value the value
	 */
	public void insert(T value);

	/**
	 * Delete.
	 *
	 * @param value the value
	 */
	public void delete(T value);

	/**
	 * Gets the max.
	 *
	 * @return the max
	 */
	public T getMax();

	/**
	 * Gets the min.
	 *
	 * @return the min
	 */
	public T getMin();

	/**
	 * Size.
	 *
	 * @return the integer
	 */
	public Integer size();
	
	/**
	 * Clear.
	 */
	public void clear();
	
	public T getKthElement(int k);

}
