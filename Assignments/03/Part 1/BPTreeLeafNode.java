/**
 * A B+ tree leaf node
 * 
 *
 * @param <TKey>
 *            the data type of the key
 * @param <TValue>
 *            the data type of the value
 */
class BPTreeLeafNode<TKey extends Comparable<TKey>, TValue> extends BPTreeNode<TKey, TValue> {

	protected ValueNode<TValue>[] values; // Each ValueNode here is the head of a linked list for a particular key corresponding to the keys[] array for this leaf node.

	@SuppressWarnings("unchecked")
	public BPTreeLeafNode(int order) {
		this.m = order;
		// The strategy used here first inserts and then checks for overflow. 
		// Thus an extra space is required i.e. m instead of m-1.
		// You can change this if needed. 
		this.keys = new Object[m]; 
		this.values = new ValueNode[m]; 
	}

	@Override
	public boolean isLeaf() { return true; }
	
	////// You should not change any code above this line //////

	////// Implement functions below this line ////// 
	@SuppressWarnings("unchecked")
	public TValue getValue(int index) {	return (TValue)this.values[index]; }

	public void setValue(int index, TValue value) {	this.values[index] = value;	}
	
	// A getValue and setValue could help

}
