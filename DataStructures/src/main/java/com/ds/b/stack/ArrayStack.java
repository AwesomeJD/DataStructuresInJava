/*
 * @author Janardhan Sharma 
 */
package com.ds.b.stack;

/**
 * The Class ArrayStack.
 *
 * @param <T> the generic type
 */
public class ArrayStack<T> implements Stack<T> {

	/** The size. */
	private Integer size = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.b.stack.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(T data) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.b.stack.Stack#pop()
	 */
	@Override
	public T pop() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.b.stack.Stack#peek()
	 */
	@Override
	public T peek() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.b.stack.Stack#size()
	 */
	@Override
	public Integer size() {
		return this.size;
	}

	/* (non-Javadoc)
	 * @see com.ds.b.stack.Stack#isEmpty()
	 */
	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return null;
	}
}
