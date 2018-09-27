/*
 * @author Janardhan Sharma 
 */
package com.ds.a.common;

/**
 * The Class Node.
 *
 * @param <T> the generic type
 */
public class Node<T> {

	/** The value. */
	private T value;
	
	/** The next. */
	private Node<T> next;

	/**
	 * Instantiates a new node.
	 *
	 * @param value the value
	 */
	public Node(T value) {
		super();
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Sets the next.
	 *
	 * @param next the new next
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value.toString();
	}

}
