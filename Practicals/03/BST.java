import javax.swing.text.html.parser.TagElement;

@SuppressWarnings("unchecked")
public class BST<T extends Comparable<? super T>> {

	protected BSTNode<T> root = null;

	public BST() {
	}

	public void clear() {
		root = null;
	}

	// returns a verbose inorder string of the BST
	public String inorder(BSTNode<T> node) {
		boolean verbose = true;
		if (node != null) {
			String result = "";
			result += inorder(node.left);
			if (verbose) {
				result += node.toString() + "\n";
			} else {
				result += node.element.toString() + " ";
			}
			result += inorder(node.right);
			return result;
		}
		return "";
	}

	////// You may not change any code above this line //////

	////// Implement the functions below this line //////

	public boolean isEmpty() {
		return (root == null);
	}

	public BSTNode<T> clone() {
		return clone(this.root);
	}

	public BSTNode<T> clone(BSTNode<T> currPtr){
		if(currPtr != null) {
			BSTNode<T> newNode = new BSTNode<>(currPtr.element);
			newNode.left = clone(currPtr.left);
			newNode.right = clone(currPtr.right);
			return newNode;
		}
		return null;
	}

	public BSTNode<T> mirror() {
		return mirror(this.root);
	}

	public BSTNode<T> mirror(BSTNode<T> node){
		if (node != null) {
			BSTNode<T> mirror_node = new BSTNode<>(node.element);
			mirror_node.right = mirror(node.left);
			mirror_node.left = mirror(node.right);
			return mirror_node;
		}
		return null;
	}

	public void insert(T element) {
		if (search(element) == null) {
			BSTNode<T> currPtr = root, prevPtr = null;
			while (currPtr != null) {
				prevPtr = currPtr;
				if (currPtr.element.compareTo(element) < 0)
					currPtr = currPtr.right;
				else currPtr = currPtr.left;
			}
			if (root == null)
				root = new BSTNode<>(element);
			else if (prevPtr.element.compareTo(element) < 0)
				prevPtr.right = new BSTNode<>(element);
			else
				prevPtr.left = new BSTNode<>(element);
		}
	}

	public boolean deleteByMerge(T element) {
		BSTNode<T> temp, node, currPtr = root, prevPtr = null;
		while (currPtr != null && !currPtr.element.equals(element)) {
			prevPtr = currPtr;
			if (currPtr.element.compareTo(element) < 0)
				currPtr = currPtr.right;
			else
				currPtr = currPtr.left;
		}
		node = currPtr;
		if (currPtr != null && currPtr.element.equals(element)) {
			if (node.right == null)
				node = node.left;
			else if (node.left == null)
				node = node.right;
			else {
				temp = node.left;
				while (temp.right != null)
					temp = temp.right;
				temp.right = node.right;
				node = node.left;
			}
			if (currPtr == root)
				root = node;
			else if (prevPtr.left == currPtr)
				prevPtr.left = node;
			else prevPtr.right = node;
			return true;
		}
		return false;
	}

	public boolean deleteByCopy(T element){
		BSTNode<T> node, currPtr = root, prevPtr = null;
		while (currPtr != null && !currPtr.element.equals(element)) {
			prevPtr = currPtr;
			if (currPtr.element.compareTo(element) < 0)
				currPtr = currPtr.right;
			else currPtr = currPtr.left;
		}
		node = currPtr;
		if (currPtr != null && currPtr.element.equals(element)){
			if (node.right == null)
				node = node.left;
			else if (node.left == null)
				node = node.right;
			else {
				BSTNode<T> temp = node.left, previous = node;
				while (temp.right != null) {
					previous = temp;
					temp = temp.right;
				}
				node.element = temp.element;
				if (previous == node)
					previous.left = temp.left;
				else previous.right = temp.left;
			}
			if (currPtr == root)
				root = node;
			else if (prevPtr.left == currPtr)
				prevPtr.left = node;
			else prevPtr.right = node;
			return true;
		}
		return false;
	}

	public T search(T element) {
		if (root != null){
			BSTNode<T> currPtr = root;
			while (currPtr != null) {
				if (currPtr.element.equals(element))
					return element;
				else if (element.compareTo(currPtr.element) < 0)
					currPtr = currPtr.left;
				else
					currPtr = currPtr.right;
			}
		}
		return null;
	}

	public T getPredecessor(T element) {
		if (root != null && search(element) != null) {
			BSTNode<T> predecessor = null, traversalPtr = root;

			while(traversalPtr != null && !traversalPtr.element.equals(element)){
				if(traversalPtr.element.compareTo(element) > 0)
					traversalPtr = traversalPtr.left;
				else{
					predecessor = traversalPtr;
					traversalPtr = traversalPtr.right;
				}
			}
			if(traversalPtr != null && traversalPtr.left != null) {
				predecessor = traversalPtr.left;
				while (predecessor.right != null)
					predecessor = predecessor.right;
			}
			return (predecessor == null) ? null : predecessor.element;
		}
		return null;
	}

	public T getSuccessor(T element) {
		if (root != null && search(element) != null) {
			BSTNode<T> successor = null, traversalPtr = root;

			while (traversalPtr != null && !traversalPtr.element.equals(element)) {
				if (traversalPtr.element.compareTo(element) > 0) {
					successor = traversalPtr;
					traversalPtr = traversalPtr.left;
				} else
					traversalPtr = traversalPtr.right;
			}

			if (traversalPtr != null && traversalPtr.right != null) {
				successor = traversalPtr.right;
				while (successor.left != null)
					successor = successor.left;
			}
			return (successor == null) ? null : successor.element;
		}
		return null;
	}
}