/*
 * @author Janardhan Sharma 
 */
package com.ds.d.stack.queue.problems;

import com.ds.b.stack.LinkedListStack;
import com.ds.c.queue.LinkedListQueue;
import com.ds.c.queue.Queue;

/**
 * The Class StackWithQueues.
 *
 * @param <T> the generic type
 */
public class StackWithQueues<T> extends LinkedListStack<T> {

	/** The queue 1. */
	private Queue<T> queue1;
	
	/** The queue 2. */
	private Queue<T> queue2;
	
	/** The load queue 1. */
	private Boolean loadQueue1;
	
	/** The size. */
	private int size = 0;

	/**
	 * Instantiates a new stack with queues.
	 */
	public StackWithQueues() {
		super();
		loadQueue1 = Boolean.TRUE;
		this.queue1 = new LinkedListQueue<>();
		this.queue2 = new LinkedListQueue<>();
	}

	/* (non-Javadoc)
	 * @see com.ds.b.stack.LinkedListStack#push(java.lang.Object)
	 */
	@Override
	public void push(T value) {
		this.size++;
		if (loadQueue1) {
			queue1.push(value);
		} else {
			queue2.push(value);
		}
	}

	/* (non-Javadoc)
	 * @see com.ds.b.stack.LinkedListStack#pop()
	 */
	@Override
	public T pop() {
		if (queue1.isEmpty() && queue2.isEmpty()) {
			throw new RuntimeException("Stack is empty !!!");
		}
		if (loadQueue1) {
			return pop(queue1, queue2);
		}
		return pop(queue2, queue1);
	}

	/**
	 * Pop.
	 *
	 * @param notEmptyQueue the not empty queue
	 * @param emptyQueue the empty queue
	 * @return the t
	 */
	private T pop(Queue<T> notEmptyQueue, Queue<T> emptyQueue) {
		int counter = 1;
		int sizeNonEmptyQueue = notEmptyQueue.size();
		while (counter < sizeNonEmptyQueue) {
			emptyQueue.push(notEmptyQueue.poll());
			counter++;
		}
		this.size--;
		loadQueue1 = !loadQueue1;
		return notEmptyQueue.poll();

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		StackWithQueues<Integer> stackWithQueue = new StackWithQueues<>();
		stackWithQueue.push(10);
		stackWithQueue.push(100);
		stackWithQueue.push(200);
		stackWithQueue.push(300);
		stackWithQueue.push(400);
		stackWithQueue.push(500);
		stackWithQueue.push(600);
		System.out.println(stackWithQueue.size);

		System.out.println(stackWithQueue.pop());
		System.out.println(stackWithQueue.pop());
		System.out.println(stackWithQueue.pop());
		System.out.println(stackWithQueue.pop());
		System.out.println(stackWithQueue.pop());
		System.out.println(stackWithQueue.pop());
		System.out.println(stackWithQueue.pop());
		
		stackWithQueue.push(700);
		stackWithQueue.push(800);
		
		System.out.println(stackWithQueue.pop());
		System.out.println(stackWithQueue.pop());
	}
}
