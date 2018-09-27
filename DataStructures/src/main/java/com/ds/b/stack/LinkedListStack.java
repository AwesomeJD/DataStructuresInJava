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
public class LinkedListStack<T> implements Stack<T> {

	/** The root. */
	private Node<T> root;
	
	/** The size. */
	private Integer size = 0;

	
	/* (non-Javadoc)
	 * @see com.ds.b.stack.Stack#push(T)
	 */
	@Override
	public void push(T data) {
		size++;
		Node<T> newNode = new Node<>(data);
		Node<T> currentNode = this.root;

		newNode.setNext(currentNode);
		this.root = newNode;
		newNode = null;
	}

	/* (non-Javadoc)
	 * @see com.ds.b.stack.Stack#pop()
	 */
	@Override
	public T pop() {
		if (root == null)
			return null;
		T toReturn = this.root.getValue();
		this.root = this.root.getNext();
		size--;
		return toReturn;
	}

	/* (non-Javadoc)
	 * @see com.ds.b.stack.Stack#peek()
	 */
	@Override
	public T peek() {
		return this.root.getValue();
	}

	/* (non-Javadoc)
	 * @see com.ds.b.stack.Stack#size()
	 */
	@Override
	public Integer size() {
		return this.size;
	}

}
