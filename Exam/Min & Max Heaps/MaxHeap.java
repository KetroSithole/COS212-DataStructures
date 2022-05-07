public class MaxHeap {

	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

	static Integer[] heap = new Integer[1];
	static int size = 0;

	static boolean isFull(){
		for(int index=0;	index<heap.length;		index++)
			if (heap[index] == null)
				return false;
		return true;
	}

	static void swap(Integer data[], int i, int j){
		Integer temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	static void printHeap(Integer[] arr){
		for (int index=0; 	index<arr.length;		index++) {
			Integer leftChild = (2*index + 1 < arr.length) ? arr[2*index + 1] : null;
			Integer rightChild =  (2*index + 2 < arr.length) ? arr[2*index + 2] : null;
			System.out.println(arr[index] + ":    " + "[L:    " + leftChild + "]    [R:   " + rightChild + "] ");
		}
	}

	public  static void FloydAlgorithm(Integer []arr){
		int index = Math.floorDiv(arr.length-2, 2);
		for (;		index>=0;		index-- ) {
			int largest = 2*index + 1;
			while (largest <= arr.length-1) {
				if (largest < arr.length-1 && arr[largest] < arr[largest+1])
					largest++;
				if (arr[index] < arr[largest]) {
					swap(arr, index, largest);
					index = largest;
					largest = 2*index + 1;
				}
				else largest = arr.length-1 + 1;
			}
		}
	}

	public static void heapify(){
		int index = heap.length - 1;

		while (index != 0 && heap[index] > heap[Math.floorDiv(index-1,  2)]){
			Integer temp = heap[index];
			heap[index] = heap[Math.floorDiv(index-1, 2)];
			heap[Math.floorDiv(index-1, 2)] = temp;
			index = Math.floorDiv(index-1, 2);
		}
	}

	private static void insert(int elem){
		if (size == 0){
			heap[0] = elem;
			size++;
		}
		else if (!isFull()){
			for (int index=0;	index<heap.length;		index++){
				if (heap[index] == null){
					heap[index] = elem;
					break;
				}
			}
		}
		else {
			Integer []new_heap = new Integer[heap.length];
			for (int index=0;	index<heap.length;	index++)
				new_heap[index] = heap[index];

			heap = new Integer[size+1];
			for (int index=0;	index<heap.length-1;	index++)
				heap[index] = new_heap[index];
			heap[size] = elem;
			size++;
		}
		heapify();
	}

	private static boolean delete(int elem){
		int pos = -1;
		boolean deleted = false;
		for (int index=0;	index<heap.length;		index++){
			if (heap[index].equals(elem)){
				pos = index;
				break;
			}
		}

		if (pos >= 0) {
			heap[pos] =heap[heap.length-1];
			heap[heap.length-1] = null;

			while (pos < heap.length &&  getIndexOfLChild(pos) < heap.length && heap[pos] < heap[getIndexOfLChild(pos)]){
				swap(heap,  pos, getIndexOfLChild(pos));
				pos = getIndexOfLChild(pos);
			}
			deleted = true;
		}

		return deleted;
	}

	static int getIndexOfLChild(int pos) {
		if (2 * pos + 1 < heap.length && 2 * pos + 2 < heap.length){
			if (heap[2*pos+1] == null) return 2*pos+2;
			else if (heap[2*pos+2] == null) return 2*pos+1;
			else return  (heap[2*pos+1] > heap[2*pos+2]) ?  2*pos+1 : 2*pos+2;
		}
		else if ( 2* pos + 1 < heap.length && 2 *pos + 1 >= heap.length)
			 return 2 * pos + 1;
		else
			return 2 * pos + 2;
	}

	public static void main(String[] args){

		// System.out.println(ANSI_RED + "Inserting into heap: " + ANSI_RESET);
		// for (int index=0;	index<=10;	index++)
		// 	insert(index);

		// System.out.println();
		// System.out.println(ANSI_PURPLE + "Printing heap: " + ANSI_RESET);
		// printHeap(heap);

		System.out.println();

		System.out.println(ANSI_BLUE + "Floyd Algorithm for this heap: [7, 1, 5, 3, 5, 2, 8, 1]" + ANSI_RESET);
		Integer []arr = {7, 1, 5, 3, 5, 2, 8, 1};
		printHeap(arr);
		System.out.println();
		FloydAlgorithm(arr);
		printHeap(arr);

		// System.out.println();
		// System.out.println(ANSI_GREEN + "Deleting 10 from heap" + ANSI_RESET);
		// if (delete(10))
		// 	System.out.println("Success.");
		// else System.out.println("Failed");

		// System.out.println();
		// System.out.println(ANSI_PURPLE + "Printing heap: " + ANSI_RESET);
		// printHeap(heap);


	}
}

