@SuppressWarnings("unchecked")
public class MinMaxDHeap<T> {


	// Constructor
	public MinMaxDHeap(int d) {
		this.d = d;
		this.size = 0;
		heap = new Node[d + 1];
		for (int index=0;	index<d+1;	index++)
			heap[index] = null;
	}


	// Insertion
	public void insert(T data, int key)	{
		if (size == 0)
			heap[0] = new Node<>(data, key);
		else if (size >= d + 1){
			Node<T>[] old_Nodes = new Node[size];
			for (int index=0;	index<size;		index++) {
				old_Nodes[index] = heap[index];
				heap[index] = null;
			}

			heap = new Node[size + 1];
			for (int index=0;	index<size+1;	index++)
				heap[index] = (index < size) ? old_Nodes[index] : null;
			heap[size] = new Node<>(data, key);
			heapify(size);
		}
		else{
			for (int index=0;	index<d+1;		index++)
				if (heap[index] == null) {
					heap[index] = new Node<>(data, key);
					heapify(index);
					break;
				}
		}
		size++;
	}

	public void swap(int index, int parent){
		Node<T> temp = heap[index];
		heap[index] = heap[parent];
		heap[parent] = temp;
	}

	public void heapifyUp(int index){
		int parent = Math.floorDiv(index-1, d), grandparent = Math.floorDiv(parent-1, d);
		if (parent > 0 && grandparent >= 0 && (heap[index].getKey() > heap[grandparent].getKey())){
			swap(index, grandparent);
			heapifyUp(grandparent);
		}
	}

	public void heapifyDown(int index){
		int parent = Math.floorDiv(index-1, d),  grandparent = Math.floorDiv(parent-1, d);
		if (parent > 0 && grandparent >= 0 && heap[index].getKey() < heap[grandparent].getKey()) {
			swap(index, grandparent);
			heapifyDown(grandparent);
		}
	}


	// Heapify - Sort the heap
	public void heapify(int index){
		int level = getLevel(index), parent = Math.floorDiv(index-1, d);

		if (level % 2 == 0){
			if (parent >= 0 && heap[index].getKey() > heap[parent].getKey()) {
				swap(index, parent);
				heapifyUp(parent);
			} else heapifyDown(index);
		}
		else if (parent >=0 && heap[index].getKey() < heap[parent].getKey()) {
			swap(index, parent);
			heapifyDown(parent);
		} else heapifyUp(index);
	}


	// Get Level of Node
	public int getLevel(int index){
		int count = 0;
		for (;	index > 0;	index = (index-1)/d)
			count++;
		return count;
	}


	// Accessors
	public T peekMin() {
		return (size != 0) ? heap[0].getData() : null;
	}


	public T peekMax() {
		T max_data = null;
		if (size > 0){
			int highest_priority = heap[0].getKey();
			for (int index=0; index<d+1;	index++) {
				if (heap[index] != null && heap[index].getKey() > highest_priority) {
					max_data = heap[index].getData();
					highest_priority = heap[index].getKey();
				}
			}
		}
		return max_data;
	}

	// Overloaded Print
	public String toString() {
		StringBuilder heap_string = new StringBuilder();
		for (int index=0;	index<size;		index++)
			if (index == size - 1)
				heap_string.append(heap[index]);
			else
				heap_string.append(heap[index]).append(",");
		return heap_string.toString();
	}


	// Deletions
	public T deleteMin() {
		T deleted_data = null;
		if (size > 0) {
			deleted_data = heap[0].getData();
			heap[0] = heap[size - 1];
			heap[size - 1] = null;
			size--;
			minTrickleDown(0);
		}
		return deleted_data;
	}

	public T deleteMax() {
		T deleted_data = null;
		if (size == 1){
			deleted_data = heap[0].getData();
			heap[0] = null;
		}
		else if (size > 1 )  {
			int highest_priority = heap[1].getKey();
			int highest_index = 1;
			for (int index=1;	index<d+1 && index <size;	index++){
				if (heap[index].getKey() > highest_priority){
					highest_index = index;
					highest_priority = heap[index].getKey();
				}
			}
			deleted_data = heap[highest_index].getData();
			heap[highest_index] = heap[size - 1];
			heap[size - 1] = null;
			size--;
			maxTrickleDown(highest_index);
		}
		return deleted_data;
	}


	public void minTrickleDown(int index) {
		if (d * index + 1 < size) {
			int smallest = d * index + 1;

			for (int cIndex = (index * d + 1); cIndex <= index * d + d && cIndex < size; cIndex++) {
				for (int gcIndex = d * cIndex + 1; gcIndex <= cIndex * d + d && gcIndex < size; gcIndex++)
					smallest = (heap[gcIndex].getKey() < heap[smallest].getKey()) ? gcIndex : smallest;
				smallest = (heap[cIndex].getKey() < heap[smallest].getKey()) ? cIndex : smallest;
			}

			if (Math.floorDiv(Math.floorDiv(smallest - 1, d) - 1, d) == index && heap[smallest].getKey() < heap[index].getKey()) {
				swap(index, smallest);
				if (heap[smallest].getKey() > heap[Math.floorDiv(smallest-1, d)].getKey())
					swap(smallest, Math.floorDiv(smallest-1, d));
				minTrickleDown(smallest);
			}
			else if (heap[smallest].getKey() < heap[index].getKey())
				swap(index, smallest);
		}
	}

	public void maxTrickleDown(int index) {
		if (d * index + 1 < size) {
			int largest = d * index + 1;

			for (int cIndex = (index * d + 1); cIndex <= index * d + d && cIndex < size; cIndex++) {
				for (int gcIndex = d * cIndex + 1; gcIndex <= cIndex * d + d && gcIndex < size; gcIndex++)
					largest = (heap[gcIndex].getKey() > heap[largest].getKey()) ? gcIndex : largest;
				largest = (heap[cIndex].getKey() > heap[largest].getKey()) ? cIndex : largest;
			}

			if (Math.floorDiv(Math.floorDiv(largest-1, d)-1, d) == index && heap[largest].getKey() > heap[index].getKey()) {
				swap(index, largest);
				if (heap[largest].getKey() < heap[Math.floorDiv(largest-1, d)].getKey())
					swap(largest, Math.floorDiv(largest-1, d));
				maxTrickleDown(largest);
			}
			else if (heap[largest].getKey() > heap[index].getKey())
				swap(index, largest);
		}
	}

	/* Construction */
	public void construct(Node<T>[] arr) {
		int numElements = 0;
		for (int index=0;	index<arr.length;	index++)
			if (arr[index] != null)
				numElements++;

		clear();
		heap = null;
		heap = new Node[numElements];
		for (int index=0;	index<numElements;	index++)
			if (arr[index] != null)
				heap[index] = arr[index];

		this.size = numElements;

		for (int index=size-1; 	index >= 0;		index--){
			if (d * index + 1 < size){
				if (getLevel(index) % 2 == 0)
					minTrickleDown(index);
				else
					maxTrickleDown(index);
			}
		}
	}

	public void changeD(int newD) {
		Node<T> []old_heap = new Node[size];
		System.arraycopy(heap, 0, old_heap, 0, size);
		clear();
		this.d = newD;
		this.size = 0;
		for (Node<T> tNode : old_heap) this.insert(tNode.getData(), tNode.getKey());
	}

	// Clear
	public void clear()	{
		for (int index=0;   index<size;     index++)
			heap[index] = null;
		size = 0;
	}


	// Private fields
	private int d;
	private int size;
	private Node<T>[] heap;
}
