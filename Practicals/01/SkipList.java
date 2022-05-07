import java.util.Random;

@SuppressWarnings("unchecked")
public class SkipList<T extends Comparable<? super T>> {

	public int maxLevel;
	public SkipListNode<T>[] root;
	private int[] powers;
	private Random rd = new Random();


	SkipList(int i) {
		maxLevel = i;
		root = new SkipListNode[maxLevel];
		powers = new int[maxLevel];
		for (int j = 0; j < i; j++)
			root[j] = null;
		choosePowers();
		rd.setSeed(202003);
	}

	SkipList() {
		this(4);
	}


	public void choosePowers() {
		powers[maxLevel - 1] = (2 << (maxLevel - 1)) - 1;
		for (int i = maxLevel - 2, j = 0; i >= 0; i--, j++)
			powers[i] = powers[i + 1] - (2 << j);
	}


	public int chooseLevel() {
		int i, r = Math.abs(rd.nextInt()) % powers[maxLevel - 1] + 1;
		for (i = 1; i < maxLevel; i++) {
			if (r < powers[i])
				return i - 1;
		}
		return i - 1;
	}


	public boolean isEmpty() {
		return root[0] == null;
	}


	public void insert(T key) {
		SkipListNode<T>[] currPtr = new SkipListNode[maxLevel], prevPtr = new SkipListNode[maxLevel];
		int level, index;
		currPtr[maxLevel-1] = root[maxLevel-1];
		prevPtr[maxLevel-1] = null;

		for (level=maxLevel-1;		level>=0;		level--) {
			while (currPtr[level] != null && currPtr[level].key.compareTo(key) < 0) {
				prevPtr[level] = currPtr[level];
				currPtr[level] = currPtr[level].next[level];
			}

			if (currPtr[level] != null && currPtr[level].key.equals(key))
				return;

			if (level > 0)
				if (prevPtr[level] == null) {
					currPtr[level-1] = root[level-1];
					prevPtr[level-1] = null;
				}
			else {
				currPtr[level-1] = prevPtr[level].next[level-1];
				prevPtr[level-1] = prevPtr[level];
			}
		}

		level = chooseLevel();
		SkipListNode<T> newNode = new SkipListNode<>(key, level + 1);
		for (index=0;	index<=level;	index++) {
			newNode.next[index] = currPtr[index];
			if (prevPtr[index] == null)
				root[index] = newNode;
			else prevPtr[index].next[index] = newNode;
		}
	}


	public boolean delete(T key) {
		if (search(key) != null) {

			SkipListNode<T> deletedNode;
			int level = maxLevel-1;
			SkipListNode<T> prevSearchPtr, currSearchPtr;
			for ( ; level >= 0 && root[level] == null; level--);
			prevSearchPtr = currSearchPtr = root[level];

			while (true) {
				if (currSearchPtr.key.equals(key)){
					deletedNode = currSearchPtr;
					break;
				}

				else if (key.compareTo(currSearchPtr.key) < 0){
					if (currSearchPtr == root[level])
						currSearchPtr = root[--level];
					else
						currSearchPtr = prevSearchPtr.next[--level];
				}

				else {
					prevSearchPtr = currSearchPtr;
					if (currSearchPtr.next[level] != null)
						currSearchPtr = currSearchPtr.next[level];
					else {
						for (level--; level >= 0 && currSearchPtr.next[level] == null; level--);
						if (level >= 0)
							currSearchPtr = currSearchPtr.next[level];
					}
				}
			}


			// Delete the node.
		 	SkipListNode<T>[] prevPtr = new SkipListNode[deletedNode.next.length];
			SkipListNode<T> currPtr = root[deletedNode.next.length - 1];
			for (int index = deletedNode.next.length-1; index >= 0; index--) {
				if (root[index].key.equals(deletedNode.key))
					prevPtr[index] = null;
				else {
					currPtr = root[index];
					while (currPtr.next[index] != deletedNode && currPtr.next[index] != null){
							currPtr = currPtr.next[index];
					}
					prevPtr[index] = currPtr;
				}
			}

			// Relink
			for (int index = 0; index < deletedNode.next.length; index++){
				if (prevPtr[index] == null)
					root[index] = deletedNode.next[index];
				else
					prevPtr[index].next[index] = deletedNode.next[index];
			}
			return true;
		}
		return false;
	}


	public T first() {
		return (!isEmpty()) ? root[0].key : null;
	}


	public T search(T key) {
		int level;
		SkipListNode<T> prevPtr, currPtr;
		for ( level= maxLevel-1; level >= 0 && root[level] == null; level--);
		prevPtr = currPtr = root[level];

		while (true) {
			if (currPtr.key.equals(key))
				return currPtr.key;
			else if (key.compareTo(currPtr.key) < 0){
				if (level == 0)
					return null;
				else if (currPtr == root[level])
					currPtr = root[--level];
				else currPtr = prevPtr.next[--level];
			}
			else {
				prevPtr = currPtr;
				if (currPtr.next[level] != null)
					currPtr = currPtr.next[level];
				else {
					for (level--; level >= 0 && currPtr.next[level] == null; level--);
					if (level >= 0)
						currPtr = currPtr.next[level];
					else
						return null;
				}
			}
		}
	}


	public String getPathToLastNode() {
		if (!(isEmpty())){
			StringBuilder pathToLastNode = new StringBuilder();
			int level;
			for ( level= maxLevel-1; level >= 0 && root[level] == null; level--);
			for (SkipListNode<T> nodePtr = root[level];		nodePtr != null;	nodePtr = nodePtr.next[level]){
				while(level > 0 && nodePtr.next[level] == null)
					level--;
				pathToLastNode.append("[").append(nodePtr.key).append("]");
			}
			return pathToLastNode.toString();
		}
		return "";
	}
}