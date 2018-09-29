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

		Node<T> tempNode = this.root;
		Node<T> lastNode = null;
		while (tempNode.getNext() != null) {
			lastNode = tempNode.getNext();
		}
		this.root = lastNode;
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
		list.reverse();
		System.out.println("******************");
		list.traverse();
	}
}
