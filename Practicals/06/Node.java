public class Node {
	protected String key;
	protected boolean isLeaf;
	protected Node[] ptrs = null;
	protected boolean endOfWord = false;
	protected int level = 0;

	public Node(String key, int numPtrs) {
		this.key = key;
		isLeaf = true;
		ptrs = new Node[numPtrs];
	}

	public Node(int numPtrs) {	
		isLeaf = false;
		ptrs = new Node[numPtrs];
	}

	public String toString() {
		if (this.isLeaf)
			return this.key;
		else {
			String res = "";
			for (int k = 0; k < this.ptrs.length; k++) {
				if (this.ptrs[k] == null)
					res += " 0 ";
				else
					res += " 1 ";
			}
			return res;
		}
	}
}