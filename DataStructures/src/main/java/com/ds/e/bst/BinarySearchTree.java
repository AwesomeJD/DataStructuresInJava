/*
 * @author Janardhan Sharma 
 */
package com.ds.e.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * The Class BinarySearchTree.
 *
 * @param <T> the generic type
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	/** The root. */
	private Node<T> root;

	/** The size. */
	private Integer size = 0;

	/** The traverse. */
	private Traverse traverse = Traverse.ITERAVTIVE;

	/** The traverse oder. */
	private TraverseOrder traverseOder = TraverseOrder.INORDER;

	/**
	 * Instantiates a new binary search tree.
	 */
	public BinarySearchTree() {
		super();
	}

	/**
	 * Instantiates a new binary search tree.
	 *
	 * @param traverse     the traverse
	 * @param traverseOder the traverse oder
	 */
	public BinarySearchTree(Traverse traverse, TraverseOrder traverseOder) {
		super();
		this.traverse = traverse;
		this.traverseOder = traverseOder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.e.bst.Tree#toList()
	 */
	@Override
	public List<T> toList() {
		List<T> returnList = new LinkedList<>();
		if (this.traverse.equals(Traverse.RECURSIVE)) {
			switch (traverseOder) {
			case INORDER:
				returnList = traverseRecursiveInOrder(this.root, returnList);
				break;
			case PREORDER:
				returnList = traverseRecursivePreOrder(this.root, returnList);
				break;
			case POSTORDER:
				returnList = traverseRecursivePostOrder(this.root, returnList);
				break;
			}
		} else {
			switch (traverseOder) {
			case INORDER:
				returnList = traverseIterativeInOrder(this.root, returnList);
				break;
			case PREORDER:
				returnList = traverseIterativePreOrder(this.root, returnList);
				break;
			case POSTORDER:
				returnList = traverseIterativePostOrder(this.root, returnList);
				break;
			}
		}
		return returnList;
	}

	/**
	 * Traverse iterative post order.
	 *
	 * @param root2      the root 2
	 * @param returnList the return list
	 * @return the list
	 */
	private List<T> traverseIterativePostOrder(Node<T> root2, List<T> returnList) {

		List<T> items = new LinkedList<>();
		if (this.size() == 0)
			return items;
		Stack<Node<T>> stack = new Stack<>();
		Node<T> currentNode = this.root;

		// push all the items from root to the left most node in the stack.
		pushToStack(stack, currentNode);

		Node<T> peekedItem = null;
		Node<T> poppedItem = null;

		// while stack is not empty keep on doing this.
		while (!stack.isEmpty()) {
			peekedItem = stack.peek();

			// if the peeked item left and right child are null pop the item and add to
			// return list.
			if (peekedItem.getLeftChild() == null && peekedItem.getRightChild() == null) {
				poppedItem = stack.pop();
				items.add(poppedItem.getData());

				// if the peeked item has right child but the last popped item is right child of
				// peeked. That means right child is already processed, so we can pop the item.
			} else if (peekedItem.getRightChild() != null && peekedItem.getRightChild() == poppedItem) {
				poppedItem = stack.pop();
				items.add(poppedItem.getData());

				// The right child is not null, so we have to add all the nodes from right child
				// to the left most node of the subtree of the right child
			} else if (peekedItem.getRightChild() != null) {
				pushToStack(stack, peekedItem.getRightChild());
			}
		}
		return items;
	}

	/**
	 * Push to stack.
	 *
	 * @param stack       the stack
	 * @param currentNode the current node
	 */
	private void pushToStack(Stack<Node<T>> stack, Node<T> currentNode) {
		if (currentNode != null)
			stack.push(currentNode);
		while (currentNode.getLeftChild() != null && currentNode.getRightChild() != null) {
			stack.push(currentNode.getLeftChild());
			currentNode = currentNode.getLeftChild();
		}
	}

	/**
	 * Traverse iterative pre order.
	 *
	 * @param root2      the root 2
	 * @param returnList the return list
	 * @return the list
	 */
	private List<T> traverseIterativePreOrder(Node<T> root2, List<T> returnList) {
		List<T> items = new LinkedList<>();
		Stack<Node<T>> stack = new Stack<>();
		stack.push(this.root);
		while (!stack.isEmpty()) {
			Node<T> currentNode = stack.peek();
			items.add(stack.pop().getData());
			if (currentNode.getRightChild() != null)
				stack.push(currentNode.getRightChild());
			if (currentNode.getLeftChild() != null)
				stack.push(currentNode.getLeftChild());

		}
		return items;
	}

	/**
	 * Traverse iterative in order.
	 *
	 * @param rootNode   the root node
	 * @param returnList the return list
	 * @return the list
	 */
	private List<T> traverseIterativeInOrder(Node<T> rootNode, List<T> returnList) {
		List<T> items = new LinkedList<>();
		Stack<Node<T>> stack = new Stack<>();

		Node<T> currentNode = rootNode;
		currentNode = pushInstack(currentNode, stack);

		while (checkCondition(stack, currentNode)) {
			Node<T> popedItem = stack.pop();
			items.add(popedItem.getData());
			currentNode = popedItem.getRightChild();
			currentNode = pushInstack(currentNode, stack);
		}

		return items;
	}

	/**
	 * Check condition.
	 *
	 * @param stack       the stack
	 * @param currentNode the current node
	 * @return true, if successful
	 */
	private boolean checkCondition(Stack<Node<T>> stack, Node<T> currentNode) {
		return stack.isEmpty() && currentNode == null ? Boolean.FALSE : Boolean.TRUE;
	}

	/**
	 * Push instack.
	 *
	 * @param currentNode the current node
	 * @param stack       the stack
	 * @return the node
	 */
	private Node<T> pushInstack(Node<T> currentNode, Stack<Node<T>> stack) {
		// push all the nodes in the left in to the stack
		while (currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.getLeftChild();
		}
		return currentNode;
	}

	/**
	 * Traverse recursive in order.
	 *
	 * @param rootNode   the root node
	 * @param returnList the return list
	 * @return the list
	 */
	private List<T> traverseRecursiveInOrder(Node<T> rootNode, List<T> returnList) {
		if (rootNode.getLeftChild() != null) {
			traverseRecursiveInOrder(rootNode.getLeftChild(), returnList);
		}
		returnList.add(rootNode.getData());
		if (rootNode.getRightChild() != null) {
			traverseRecursiveInOrder(rootNode.getRightChild(), returnList);
		}
		return returnList;
	}

	/**
	 * Traverse recursive pre order.
	 *
	 * @param rootNode   the root node
	 * @param returnList the return list
	 * @return the list
	 */
	private List<T> traverseRecursivePreOrder(Node<T> rootNode, List<T> returnList) {

		returnList.add(rootNode.getData());
		if (rootNode.getLeftChild() != null) {
			traverseRecursivePreOrder(rootNode.getLeftChild(), returnList);
		}
		if (rootNode.getRightChild() != null) {
			traverseRecursivePreOrder(rootNode.getRightChild(), returnList);
		}
		return returnList;
	}

	/**
	 * Traverse recursive post order.
	 *
	 * @param rootNode   the root node
	 * @param returnList the return list
	 * @return the list
	 */
	private List<T> traverseRecursivePostOrder(Node<T> rootNode, List<T> returnList) {

		if (rootNode.getLeftChild() != null) {
			traverseRecursivePostOrder(rootNode.getLeftChild(), returnList);
		}

		if (rootNode.getRightChild() != null) {
			traverseRecursivePostOrder(rootNode.getRightChild(), returnList);
		}
		returnList.add(rootNode.getData());

		return returnList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.e.bst.Tree#insert(java.lang.Object)
	 */
	@Override
	public void insert(T value) {
		// new node
		Node<T> newNode = new Node<>(value);

		// tree is empty so the new node is the root
		if (this.root == null) {
			this.root = newNode;
			this.size++;
			return;
		}
		// node use for iteration;
		Node<T> nodeForIteration = this.root;

		// node which will act as parent of the new node
		Node<T> nodeToBeModified = null;
		while (nodeForIteration != null) {

			// if the nodeForIteration is equal to the new node return.
			if (newNode.getData().compareTo(nodeForIteration.getData()) == 0) {
				return;
			}

			if (newNode.getData().compareTo(nodeForIteration.getData()) < 0) {
				nodeToBeModified = nodeForIteration;
				nodeForIteration = nodeForIteration.getLeftChild();
			} else {
				nodeToBeModified = nodeForIteration;
				nodeForIteration = nodeForIteration.getRightChild();
			}

		}
		if (newNode.getData().compareTo(nodeToBeModified.getData()) < 0) {
			// update the left child of the nodeTobeModified with the new node.
			nodeToBeModified.setLeftChild(newNode);
		} else {
			// update the right child of the nodeTobeModified with the new node.
			nodeToBeModified.setRightChild(newNode);
		}
		this.size++;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.e.bst.Tree#delete(java.lang.Object)
	 */
	@Override
	public void delete(T value) {

		// Three scenarios
		// 1. The node has no left and right child. (leaf node)
		// 2. The node has only one child.
		// 3. The node has two children.

		Node<T> nodeTobeDeleted = new Node<>(value);
		Node<T> currentNode = this.root;
		Node<T> parentNode = this.root;

		while (currentNode != null) {
			if (currentNode.getData().compareTo(nodeTobeDeleted.getData()) == 0) {
				break;
			}
			if (nodeTobeDeleted.getData().compareTo(currentNode.getData()) < 0) {
				parentNode = currentNode;
				currentNode = currentNode.getLeftChild();
			}
			if (nodeTobeDeleted.getData().compareTo(currentNode.getData()) > 0) {
				parentNode = currentNode;
				currentNode = currentNode.getRightChild();
			}
		}
		// No node found to be deleted.
		if (currentNode == null) {
			return;
		}
		// 1. The node has no left and right child. (leaf node)
		if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
			if (parentNode.getLeftChild() == null) {
				parentNode.setRightChild(null);
			} else {
				parentNode.setLeftChild(null);
			}
			this.size--;
			return;
		}
		// 2. The node has only one child.
		if (currentNode.getLeftChild() == null || currentNode.getRightChild() == null) {
			if (currentNode.getLeftChild() == null) {
				currentNode.setData(currentNode.getRightChild().getData());
				currentNode.setRightChild(null);
			} else {
				currentNode.setData(currentNode.getLeftChild().getData());
				currentNode.setLeftChild(null);
			}
			this.size--;
			return;
		}
		// 3. The node has two children.
		Node<T> parentToSuppresor = null;
		Node<T> suppressor = currentNode;
		// Find the suppressor.
		while (suppressor.getRightChild() != null) {
			parentToSuppresor = suppressor;
			suppressor = suppressor.getRightChild();
		}
		// Swap the node to be deletd with the suppressor.
		currentNode.setData(suppressor.getData());
		parentToSuppresor.setRightChild(null);
		this.size--;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.e.bst.Tree#getMax()
	 */
	@Override
	public T getMax() {
		Node<T> currentNode = this.root;

		while (currentNode.getRightChild() != null) {
			currentNode = currentNode.getRightChild();
		}
		return currentNode.getData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.e.bst.Tree#getMin()
	 */
	@Override
	public T getMin() {
		Node<T> currentNode = this.root;

		while (currentNode.getLeftChild() != null) {
			currentNode = currentNode.getLeftChild();
		}
		return currentNode.getData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.e.bst.Tree#size()
	 */
	@Override
	public Integer size() {
		return this.size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ds.e.bst.Tree#clear()
	 */
	@Override
	public void clear() {
		this.root = null;
	}

	@Override
	public T getKthElement(int k) {
		Node<T> currentNode = this.root;
		Deque<Node<T>> stack = new ArrayDeque<>();

		int counter = 0;
		currentNode = pushToStack(currentNode, stack);

		while (!(stack.isEmpty() && currentNode == null)) {
			Node<T> poppedItem = stack.pop();
			counter++;
			if (counter == k)
				return poppedItem.getData();

			currentNode = poppedItem.getRightChild();
			currentNode = pushToStack(currentNode, stack);
		}
		return null;
	}

	private Node<T> pushToStack(Node<T> currentNode, Deque<Node<T>> stack) {
		while (currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.getLeftChild();
		}
		return currentNode;
	}
}
