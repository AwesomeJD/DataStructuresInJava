/*
 * @author Janardhan Sharma 
 */
package com.ds.b.stack;

import com.ds.a.common.Node;

/**
 * The Class Stack.
 *
 * @param <T> the generic type
 */
public class Stack<T> {

	/** The root. */
	private Node<T> root;
	
	/** The size. */
	private Integer size;

	/**
	 * Instantiates a new stack.
	 */
	public Stack() {
		this.size = 0;
	}

	/**
	 * Push.
	 *
	 * @param data the data
	 */
	public void push(T data) {
		size++;
		Node<T> newNode = new Node<>(data);
		Node<T> currentNode = this.root;

		newNode.setNext(currentNode);
		this.root = newNode;
		newNode = null;
	}

	/**
	 * Pop.
	 *
	 * @return the t
	 */
	public T pop() {
		if (root == null)
			return null;
		T toReturn = this.root.getValue();
		this.root = this.root.getNext();
		size--;
		return toReturn;
	}

	/**
	 * Peek.
	 *
	 * @return the t
	 */
	public T peek() {
		return this.root.getValue();
	}

	/**
	 * Size.
	 *
	 * @return the integer
	 */
	public Integer size() {
		return this.size;
	}

}
