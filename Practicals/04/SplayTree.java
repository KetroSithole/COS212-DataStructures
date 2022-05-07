/**
 * Name: Isheanesu Joseph Dzingirai
 * Student Number:   u20536951
 */

public class SplayTree<T extends Comparable<T>> {

	protected enum SplayType {
		SPLAY,
		SEMISPLAY,
		NONE
	}

	protected Node<T> root = null;

	/**
	 * Prints out all the elements in the tree
	 * @param verbose
	 *			If false, the method simply prints out the element of each node in the tree
	 *			If true, then the output provides additional detail about each of the nodes.
	 */
	public void printTree(boolean verbose) {
		String result;
		result = preorder(root, verbose);
		System.out.println(result);
	}

	protected String preorder(Node<T> node, boolean verbose) {
		if (node != null) {
			String result = "";
			if (verbose) {
				result += node.toString()+"\n";
			} else {
				result += node.elem.toString() + " ";
			}
			result += preorder(node.left, verbose);
			result += preorder(node.right, verbose);
			return result;
		}
		return "";
	}

	////// You may not change any code above this line //////

	////// Implement the functions below this line //////

	/**
	 * Inserts the given element into the tree, but only if it is not already in the tree.
	 * @param elem
	 * 		 	The element to be inserted into the tree
	 * @return
	 *			Returns true if the element was successfully inserted into the tree.
	 *			Returns false if elem is already in the tree and no insertion took place.
	 *
	 */
	public boolean insert(T elem) {
		if (!contains(elem)){
			Node<T> currPtr = root, prevPtr = null;
			while (currPtr != null) {
				prevPtr = currPtr;
				if (currPtr.elem.compareTo(elem) < 0)
					currPtr = currPtr.right;
				else currPtr = currPtr.left;
			}
			if (root == null)
				root = new Node<>(elem);
			else if (prevPtr.elem.compareTo(elem) < 0)
				prevPtr.right = new Node<>(elem);
			else prevPtr.left = new Node<>(elem);
			return true;
		}
		return false;
	}

	/**
	 * Checks whether a given element is already in the tree.
	 * @param elem
	 * 		 	The element being searched for in the tree
	 * @return
	 *			Returns true if the element is already in the tree
	 *			Returns false if elem is not in the tree
	 *
	 */
	public boolean contains(T elem) {
		if (root != null){
			Node<T> currPtr = root;
			while (currPtr != null) {
				if (currPtr.elem.equals(elem)) return true;
				else if (elem.compareTo(currPtr.elem) < 0) currPtr = currPtr.left;
				else currPtr = currPtr.right;
			}
		}
		return false;
	}

	/**
	 * Accesses the node containing elem. 
	 * If no such node exists, the node should be inserted into the tree.
	 * If the element is already in the tree, the tree should either be semi-splayed so that 
	 * the accessed node moves up and the parent of that node becomes the new root or be splayed 
	 * so that the accessed node becomes the new root.
	 * @param elem
	 *			The element being accessed
	 * @param type
	 *			The adjustment type (splay or semi-splay or none)
	 */
	public void access(T elem, SplayType type) {
		Node<T> currPtr = root;
		if(!contains(elem))	insert(elem);
		else {
			while (currPtr != null) {
				if (elem.equals(currPtr.elem)) break;
				else if (elem.compareTo(currPtr.elem) < 0) currPtr = currPtr.left;
				else currPtr = currPtr.right;
			}

			if(type == SplayType.SPLAY)	splay(currPtr);
			else if(type == SplayType.SEMISPLAY) semisplay(currPtr);
			else if(type == SplayType.NONE) return;
		}
	}

	/**
	 * Semi-splays the tree using the parent-to-root strategy
	 * @param node
	 *			The node the parent of which will be the new root
	 */
	protected void semisplay(Node<T> node) {
		Node<T> child = root, parent = null, grandparent = null;
		while (child != null) {
			if (child.elem.equals(node.elem))
				break;
			else if (node.elem.compareTo(child.elem) < 0) {
				grandparent = parent;
				parent = child;
				child = child.left;
			}
			else {
				grandparent = parent;
				parent =child;
				child = child.right;
			}
		}

		if (root != node) {
			if (parent == root) {
				if (parent.left == child)
					rotateR(child.elem);
				else rotateL(child.elem);
			}

			else if (grandparent.left == parent && parent.right == child) {
				rotateL(child.elem);
				rotateR(child.elem);
			}
			else if (grandparent.right == parent && parent.left == child) {
				rotateR(child.elem);
				rotateL(child.elem);
			}
			else if (grandparent.right == parent && parent.right == child) {
				node = parent;
				rotateL(parent.elem);
			}
			else if (grandparent.left == parent && parent.left == child) {
				node = parent;
				rotateR(parent.elem);
			}
			semisplay(node);
		}
	}

	/**
	 * Splays the tree using the node-to-root strategy
	 * @param node
	 *			The node which will be the new root
	 */
	protected void splay(Node<T> node) {
		Node<T> child = root, parent = null, grandparent = null;
		while (child != null) {
			if (child.elem.equals(node.elem))
				break;
			else if (node.elem.compareTo(child.elem) < 0) {
				grandparent = parent;
				parent = child;
				child = child.left;
			}
			else {
				grandparent = parent;
				parent =child;
				child = child.right;
			}
		}

		if (root != child) {
			if (parent == root) {
				if (parent.left == node)
					rotateR(child.elem);
				else rotateL(child.elem);
			}

			else if (grandparent.left == parent && parent.right == child) {
				rotateL(child.elem);
				rotateR(child.elem);
			}
			else if (grandparent.right == parent && parent.left == child) {
				rotateR(child.elem);
				rotateL(child.elem);
			}
			else if (grandparent.right == parent && parent.right == child) {
				rotateL(parent.elem);
				rotateL(child.elem);
			}
			else if (grandparent.left == parent && parent.left == child) {
				rotateR(parent.elem);
				rotateR(child.elem);
			}
			splay(node);
		}
	}

	//Helper functions
	public void rotateR(T elem)	{
		Node<T> child = root, parent = null, grandparent = null, temp = null;

		while (child != null) {
			if (child.elem == elem)
				break;
			else if (elem.compareTo(child.elem) < 0) {
				grandparent = parent;
				parent =child;
				child = child.left;
			}
			else {
				grandparent = parent;
				parent =child;
				child = child.right;
			}
		}

		temp = child.right;
		child.right = parent;
		if(parent == root)
			root = child;
		else if (grandparent != null){
			if(grandparent.left == parent) grandparent.left=child;
			if(grandparent.right == parent) grandparent.right=child;
		}
		parent.left = temp;
	}

	public void rotateL(T elem) {
		Node<T> child = root, parent = null, grandparent = null, temp = null;

		while (child != null) {
			if (child.elem == elem)	break;
			else if (elem.compareTo(child.elem) < 0) {
				grandparent = parent;
				parent =child;
				child = child.left;
			}
			else {
				grandparent = parent;
				parent =child;
				child = child.right;
			}
		}

		temp = child.left;
		child.left = parent;
		if(parent == root)
			root = child;
		else if (grandparent != null){
			if(grandparent.left == parent) grandparent.left=child;
			if(grandparent.right == parent) grandparent.right=child;
		}
		parent.right = temp;
	}
}
