public class Trie {	
	protected char[] letters;
	protected Node root = null;
	private int numPtrs;

	public Trie(char[] letters) {
		this.letters = letters;
		this.numPtrs = letters.length + 1;
	}

	// Provided Helper functions
	private int index(char c) {
		for (int k = 0; k < letters.length; k++)
			if (letters[k] == (c))
				return k+1;
		return -1;
	}
	
	private char character(int i) {
		if (i == 0)
			return '#';
		else
			return letters[i-1];
	}
	
	private String nodeToString(Node node, boolean debug) {
		if (node.isLeaf)
			return node.key;
		else {
			String res = "";
			for (int k = 0; k < node.ptrs.length; k++) {
				if (node.ptrs[k] != null)
					res += " (" + character(k) + ",1) ";
				else if (debug)
					res += " (" + character(k) + ",0) ";
			}
			return res;
		}
	}

	public void print(boolean debug) {
		Queue queue = new Queue();
		Node n = root;
		if (n != null) {
			n.level = 1;
			queue.enq(n);
			while (!queue.isEmpty()){
				n = queue.deq();
				System.out.print("Level " + n.level + " [");
				System.out.print(nodeToString(n, debug));
				System.out.println("]");
				for (int k = 0; k < n.ptrs.length; k++) {
					if (n.ptrs[k] != null) {
						n.ptrs[k].level = n.level+1;
						queue.enq(n.ptrs[k]);
					}
				}
			}
		}
	}

	////// You may not change any code above this line //////

	////// Implement the functions below this line //////

	
	// Function to insert the given key into the trie at the correct position.
	public void insert(String key) {
		if(root == null) root = new Node(numPtrs);
		if(!contains(key)) insert(key, root, 0);
	}

	public void insert(String key, Node currNode, int pos){
		int index = (pos < key.length()) ? index(key.charAt(pos)) : 0;
		if(index != -1 && currNode != null && currNode.ptrs[index] != null)
			if(currNode.ptrs[index].isLeaf){
				String leaf_key = currNode.ptrs[index].key;
				do {
					currNode.ptrs[index] = new Node(numPtrs);
					currNode = currNode.ptrs[index];
					index = (pos+1 < key.length()) ? index(key.charAt(++pos)) : 0;
				} while (pos < leaf_key.length() && pos < key.length() && leaf_key.charAt(pos) == key.charAt(pos));
				insert(key, currNode, pos);
				insert(leaf_key, currNode, pos);
			}
			else insert(key, currNode.ptrs[index], ++pos);
		else if(index != -1 && currNode != null) currNode.ptrs[index] = new Node(key, numPtrs);
		return;
	}

	// Function to determine if a node with the given key exists.
	public boolean contains(String key) {
		return contains(key, root, 0);
	}

	public boolean contains(String key, Node currNode, int pos){
		if(currNode != null){
			int index = pos < key.length() ? this.index(key.charAt(pos)) : 0;
			if(index == 0) return (currNode.ptrs[0] != null && currNode.ptrs[0].key == key);
			else if (index != -1)
				if (currNode.ptrs[index] != null && currNode.ptrs[index].key == key) return true;
				else return contains(key, currNode.ptrs[index], ++pos);
		}
		return false;
	}

	public void printKeyList() {
		printKeyList(root);
	}

	public void printKeyList(Node currNode){
		if(currNode != null){
			int index = 0;
			while(index < numPtrs){
				if(currNode.ptrs[index] != null)
					if(currNode.ptrs[index].isLeaf)	System.out.print(currNode.ptrs[index].key + " ");
					else printKeyList(currNode.ptrs[index]);
					index++;
			}
		}
	}
}