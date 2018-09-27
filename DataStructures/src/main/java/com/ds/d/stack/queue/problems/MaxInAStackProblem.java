/*
 * @author Janardhan Sharma 
 */
package com.ds.d.stack.queue.problems;

import com.ds.b.stack.LinkedListStack;
import com.ds.b.stack.Stack;

/**
 * The Class MaxInAStackProblem.
 */
public class MaxInAStackProblem {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		MaxStack<Integer> stack = new MaxStack<>();
		stack.push(10);
		stack.push(30);
		stack.push(5);
		stack.push(300);
		stack.push(50);

		System.out.println(stack.getMax());

		System.out.println(stack.pop());

	}

}

class MaxStack<T extends Comparable<T>> extends LinkedListStack<T> {

	private Stack<T> maxStack;

	public MaxStack() {
		maxStack = new LinkedListStack<>();
	}

	public T getMax() {
		return maxStack.pop();
	}

	@Override
	public void push(T value) {
		super.push(value);

		if (maxStack.isEmpty()) {
			maxStack.push(value);
			return;
		}
		T temp = maxStack.peek();
		if (value.compareTo(temp) > 0) {
			maxStack.push(value);
			return;
		}

	}

	@Override
	public T pop() {
		T returnValue = super.pop();

		if (maxStack.isEmpty())
			return returnValue;

		T temp = maxStack.peek();
		if (returnValue.compareTo(temp) == 0)
			maxStack.pop();

		return returnValue;
	}
}
