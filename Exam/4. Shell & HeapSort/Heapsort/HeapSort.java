public class HeapSort {

	static <T extends Comparable<? super T>> void swap(T []data, int i, int j) {
		T temp =data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	static <T extends Comparable<? super T>> void sort(T []data) {
		int n = data.length;
		for (int i = n / 2 - 1; i >= 0; i--) heapify(data, n, i);
		for (int i = n - 1; i > 0; i--) {
			swap(data, 0, i);
			heapify(data, i, 0);
		}
	}

	static <T extends Comparable<? super T>> void heapify(T []data, int n, int i) {
		int largest = i; 
		int l = 2 * i + 1; 
		int r = 2 * i + 2;

		if (l < n && data[l].compareTo(data[largest]) > 0) largest = l;
		if (r < n && data[r].compareTo(data[largest]) > 0)	largest = r;

		if (largest != i) {
			swap(data, i, largest);
			printArray(data);
			heapify(data, n, largest);
		}
	}

	static <T extends Comparable<? super T>> void printArray(T []data)	{
		int n = data.length;
		System.out.print("[");
		for (int i = 0; i < n; ++i)
			if (i == n-1) System.out.print(data[i]);
			else System.out.print(data[i] + ", ");
		System.out.println("]");
	}

	public static void main(String args[]) {
		Integer arr[] = {1024, 793, 342, 450, 999, 99, 100, 99, 12, 4, 60, 31, 342, 36};
		Integer data[] = {8, 3, 14, 2, 9, 1, 25, 7};
		sort(arr);
		printArray(arr);
	}
}
