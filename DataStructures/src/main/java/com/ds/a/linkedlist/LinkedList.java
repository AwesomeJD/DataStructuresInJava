/*
 * @author Janardhan Sharma 
 */
package com.ds.a.linkedlist;

import com.ds.a.common.Node;

/**
 * The Class LinkedList.
 *
 * @param <T> the generic type
 */
public class LinkedList<T> implements List<T> {

	/** The root. */
	private Node<T> root;
	
	/** The size. */
	private Integer size = 0;

	/* (non-Javadoc)
	 * @see com.ds.a.linkedlist.List#add(java.lang.Object)
	 */
	@Override
	public void add(T value) {

		Node<T> newNode = new Node<>(value);
		this.size++;

		if (root == null) {
			root = newNode;
		} else {
			Node<T> tempNode = this.root;
			tempNode.setNext(newNode);
			this.root.setNext(newNode);
			tempNode = null;
		}
	}

	/* (non-Javadoc)
	 * @see com.ds.a.linkedlist.List#remove(java.lang.Object)
	 */
	@Override
	public void remove(T value) {

		if (size() == 0)
			return;

		if (this.root.getValue().equals(value)) {
			Node<T> tempNode = this.root.getNext();
			this.root = tempNode;
			tempNode = null;
			size--;
			return;
		}

		// We need two Nodes in a singly linked list to remove a node.
		// Where as in a doubly linked list one node is enough to remove a node, since
		// we know previous and next nodes from the current node.
		
		Node<T> currentNode = this.root;
		Node<T> nextNode = currentNode.getNext();

		while (nextNode != null) {
			if (nextNode.getValue().equals(value)) {
				currentNode.setNext(nextNode.getNext());
				nextNode = null;
				size--;
				return;
			}
			currentNode = nextNode;
			nextNode = nextNode.getNext();
		}

	}

	/* (non-Javadoc)
	 * @see com.ds.a.linkedlist.List#getNode(java.lang.Object)
	 */
	@Override
	public Node<T> getNode(T value) {
		return getNodeFromValue(value);
	}

	/* (non-Javadoc)
	 * @see com.ds.a.linkedlist.List#traverse()
	 */
	@Override
	public void traverse() {
		Node<T> currentNode = this.root;
		while (currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
		}

	}

	/* (non-Javadoc)
	 * @see com.ds.a.linkedlist.List#isPresent(java.lang.Object)
	 */
	@Override
	public Boolean isPresent(T value) {
		return getNodeFromValue(value) != null ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * Gets the node from value.
	 *
	 * @param value the value
	 * @return the node from value
	 */
	private Node<T> getNodeFromValue(T value) {
		Node<T> currentNode = this.root;
		while (currentNode != null) {
			if (currentNode.getValue().equals(value)) {
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ds.a.linkedlist.List#size()
	 */
	@Override
	public Integer size() {
		return this.size;
	}

}
