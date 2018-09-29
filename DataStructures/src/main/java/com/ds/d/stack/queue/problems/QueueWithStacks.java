/*
 * @author Janardhan Sharma 
 */
package com.ds.d.stack.queue.problems;

import com.ds.b.stack.LinkedListStack;
import com.ds.b.stack.Stack;
import com.ds.c.queue.LinkedListQueue;

/**
 * The Class QueueWithStacks.
 *
 * @param <T> the generic type
 */
public class QueueWithStacks<T> extends LinkedListQueue<T> {

	/** The add stack. */
	private Stack<T> addStack;
	
	/** The remove stack. */
	private Stack<T> removeStack;

	/** The size queue with stack. */
	private int sizeQueueWithStack = 0;

	/**
	 * Instantiates a new queue with stacks.
	 */
	public QueueWithStacks() {
		super();
		this.addStack = new LinkedListStack<>();
		this.removeStack = new LinkedListStack<>();
	}

	/* (non-Javadoc)
	 * @see com.ds.c.queue.LinkedListQueue#push(java.lang.Object)
	 */
	@Override
	public void push(T value) {

		while (!removeStack.isEmpty()) {
			addStack.push(removeStack.pop());
		}

		addStack.push(value);
		this.sizeQueueWithStack++;
	}

	/* (non-Javadoc)
	 * @see com.ds.c.queue.LinkedListQueue#poll()
	 */
	@Override
	public T poll() {
		while (!addStack.isEmpty()) {
			removeStack.push(addStack.pop());
		}
		this.sizeQueueWithStack--;
		return removeStack.pop();
	}

	/* (non-Javadoc)
	 * @see com.ds.c.queue.LinkedListQueue#size()
	 */
	@Override
	public Integer size() {
		return this.sizeQueueWithStack;
	}

	/* (non-Javadoc)
	 * @see com.ds.c.queue.LinkedListQueue#isEmpty()
	 */
	@Override
	public Boolean isEmpty() {
		return size() == 0 ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		QueueWithStacks<Integer> queue = new QueueWithStacks<>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(7);

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}
}
