/*
 * @author Janardhan Sharma 
 */
package com.ds.a.linkedlist.problems;

import com.ds.a.common.Node;
import com.ds.a.linkedlist.LinkedList;

/**
 * The Class ReverseLinkedList.
 *
 * @param <T> the generic type
 */
public class ReverseLinkedList<T> extends LinkedList<T> {

	/**
	 * Reverse.
	 */
	public void reverse() {

		if (size() < 2)
			return;

		int counter = 1;
		int sizeCounter = super.size();

		Node<T> currentRoot = this.root.getNext();
		Node<T> newRoot = this.root;
		newRoot.setNext(null);

		while (counter < sizeCounter) {

			Node<T> temp = currentRoot;
			currentRoot = temp.getNext();
			temp.setNext(newRoot);
			newRoot = temp;
			counter++;
		}

		this.root = newRoot;

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {

		ReverseLinkedList<Integer> list = new ReverseLinkedList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.traverse();
		System.out.println("******************");
		list.reverse();
		list.traverse();
	}
}
