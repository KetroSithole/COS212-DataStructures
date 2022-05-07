import java.util.Arrays;

@SuppressWarnings("unchecked")
public class Sort {

	////// Implement the functions below this line //////
	/********** HEAP **********/
	static <T extends Comparable<? super T>> void swap(T[] data, int i, int j){
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static <T extends Comparable<? super T>> void heapsort(T[] data, boolean debug) {
		for (int index=data.length/2 - 1;		index >= 0;		index--)
			movedown(data, index, data.length-1, debug);
		for (int index=data.length-1;	index >= 1;		index--) {
			swap(data, 0, index);
			movedown(data, 0, index-1, debug);
		}
	}

	private static <T extends Comparable<? super T>> void movedown(T[] data, int first, int last, boolean debug) {
		int largest = 2 * first + 1;
		while (largest <= last) {
			if (largest < last && data[largest].compareTo(data[largest+1]) < 0)	largest++;
			if (data[first].compareTo(data[largest]) < 0) {
				swap(data, first, largest);
				first = largest;
				largest = 2 * first + 1;
			}
			else largest = last + 1;
		}
		// DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}

	/********** MERGE **********/
	public static <T extends Comparable<? super T>> void mergesort(T[] data, int first, int last, boolean debug) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergesort(data, first, mid, debug);
			mergesort(data, mid + 1, last, debug);
			merge(data, first, last, debug);
		}
	}

	private static <T extends Comparable<? super T>> void merge(T[] data, int first, int last, boolean debug) {
		int l = first, r = last, mid = (first + last) / 2, it1 = mid - l + 1, it2 = r - mid, i = 0, j = 0, k = l;

		Comparable[] LeftArr = new Comparable[it1];
		Comparable[] RightArr = new Comparable[it2];

		int max = (it1 < it2) ? it2 : it1;
		for (int index=0;		index<max;		index++) {
			if (index < it1) LeftArr[index] = (T) data[l + index];
			if (index < it2) RightArr[index] = data[mid + 1 + index];
		}


		while (i < it1 && j < it2) {
			if (LeftArr[i].compareTo(RightArr[j]) <= 0) data[k++] = (T)LeftArr[i++];
			else data[k++] = (T)RightArr[j++];
		}

		while (i < max) {
			if (i < it1) data[k++] = (T)LeftArr[i++];
			if (i < it2) data[k++] = (T)RightArr[i++];
		}

		// DO NOT MOVE OR REMOVE!
		 if (debug)
		 	System.out.println(Arrays.toString(data));
	}

}