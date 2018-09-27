package com.ds.b.stack;

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

}