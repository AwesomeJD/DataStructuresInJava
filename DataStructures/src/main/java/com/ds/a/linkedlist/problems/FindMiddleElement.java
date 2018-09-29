/*
 * @author Janardhan Sharma 
 */
package com.ds.a.linkedlist.problems;

import com.ds.a.common.Node;
import com.ds.a.linkedlist.LinkedList;

/*
 * QUESTION :
 * 
 * Suppose we have a standard linked list. Construct an in-place (without extra
 * memory) algorithm thats able to find the middle node !
 * 
 */

/**
 * The Class FindMiddleElement.
 *
 * @param <T> the generic type
 */
public class FindMiddleElement<T> extends LinkedList<T> {

	/**
	 * Find middle element.
	 *
	 * @return the t
	 */
	public T findMiddleElement() {

		Node<T> firstNode = root;
		Node<T> secondNode = root;

		int sizeCheck = 1;
		while (secondNode != null) {

			firstNode = firstNode.getNext();
			sizeCheck = sizeCheck + 2;
			if(sizeCheck >= size) {
				break;
			}
			secondNode = secondNode.getNext().getNext();
			
		}

		return firstNode.getValue();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		FindMiddleElement<Integer> list = new FindMiddleElement<>();

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
		System.out.println(list.findMiddleElement());
	}
}
