/*
 * @author Janardhan Sharma 
 */
package com.ds.c.queue;

import com.ds.a.common.Node;

/**
 * The Class LinkedListQueue.
 *
 * @param <T> the generic type
 */
public class LinkedListQueue<T> implements Queue<T> {

	// Two nodes because we need a start and end of the linked list to be able to go
	// the end to push and to the start to poll
	//
	// N -> N -> N -> N -> N
	// HEAD................TAIL
	// In Singly linked list the head and tail meanings are a little reversed.

	/** The add. */
	private Node<T> add;

	/** The remove. */
	private Node<T> remove;

	/** The size. */
	private Integer size = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.c.queue.Queue#push(T)
	 */
	@Override
	public void push(T value) {
		Node<T> newNode = new Node<>(value);

		size++;
		if (add == null) {
			add = remove = newNode;
			newNode = null;
			return;
		}

		Node<T> temp = this.add;
		temp.setNext(newNode);
		this.add = newNode;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.c.queue.Queue#poll()
	 */
	@Override
	public T poll() {

		if (remove == null)
			return null;

		T returnData = this.remove.getValue();

		Node<T> temp = this.remove.getNext();
		this.remove = temp;
		temp = null; // Object eligible for garage collection
		size--;
		return returnData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.c.queue.Queue#size()
	 */
	@Override
	public Integer size() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.c.queue.Queue#isEmpty()
	 */
	@Override
	public Boolean isEmpty() {
		return size == 0 ? Boolean.TRUE : Boolean.FALSE;
	}

}
