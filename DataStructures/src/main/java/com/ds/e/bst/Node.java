/*
 * @author Janardhan Sharma 
 */
package com.ds.e.bst;

/**
 * The Class Node.
 *
 * @param <T> the generic type
 */
public class Node<T> {

	/** The data. */
	private T data;
	
	/** The left child. */
	private Node<T> leftChild;
	
	/** The right child. */
	private Node<T> rightChild;

	/**
	 * Instantiates a new node.
	 *
	 * @param data the data
	 */
	public Node(T data) {
		super();
		this.data = data;
	}

	/**
	 * Gets the left child.
	 *
	 * @return the left child
	 */
	public Node<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Sets the left child.
	 *
	 * @param leftChild the new left child
	 */
	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Gets the right child.
	 *
	 * @return the right child
	 */
	public Node<T> getRightChild() {
		return rightChild;
	}

	/**
	 * Sets the right child.
	 *
	 * @param rightChild the new right child
	 */
	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return data.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
