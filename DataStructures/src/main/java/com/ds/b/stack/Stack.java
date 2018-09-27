/*
 * @author Janardhan Sharma 
 */
package com.ds.b.stack;

/**
 * The Interface Stack.
 *
 * @param <T> the generic type
 */
public interface Stack<T> {

	/**
	 * Push.
	 *
	 * @param data the data
	 */
	void push(T data);

	/**
	 * Pop.
	 *
	 * @return the t
	 */
	T pop();

	/**
	 * Peek.
	 *
	 * @return the t
	 */
	T peek();

	/**
	 * Size.
	 *
	 * @return the integer
	 */
	Integer size();
	
	/**
	 * Checks if is empty.
	 *
	 * @return the boolean
	 */
	Boolean isEmpty();

}