/*
 * @author Janardhan Sharma 
 */
package com.ds.c.queue;

/**
 * The Interface Queue.
 *
 * @param <T> the generic type
 */
public interface Queue<T> {

	/**
	 * Push.
	 *
	 * @param value the value
	 */
	void push(T value);

	/**
	 * Poll.
	 *
	 * @return the t
	 */
	T poll();
	
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