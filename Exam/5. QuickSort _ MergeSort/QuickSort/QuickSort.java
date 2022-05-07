public class QuickSort {

	static <T extends Comparable<? super T>> void swap(T []data, int i, int j){
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	static <T extends Comparable<? super T>> void quicksort(T[] data, int first, int last) {
		int lower = first + 1, upper = last;
		swap(data,first,(first+last)/2);
		printArray(data);
		T bound = data[first];
		while (lower <= upper) {
			while (bound.compareTo(data[lower]) > 0)
				lower++;
			while (bound.compareTo(data[upper]) < 0)
				upper--;
			if (lower < upper) {
				swap(data,lower++,upper--);
				printArray(data);
			}
			else lower++;
		}
		swap(data,upper,first);
		printArray(data);
		if (first < upper-1)
			quicksort(data,first,upper-1);
		if (upper+1 < last)
			quicksort(data,upper+1,last);
	}

	static <T extends Comparable<? super T>> void quicksort(T[] data) {
		if (data.length >= 2) {
			int max = 0;
			for (int i = 1; i < data.length; i++)
				if (data[max].compareTo(data[i]) < 0)
					max = i;
			swap(data,data.length-1,max);
			printArray(data);
			quicksort(data,0,data.length-2);
		}
	}

	static <T extends Comparable<? super T>> void printArray(T data[]) {
		int n = data.length;
		for (int i=0; i<n; ++i)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	public static void main(String[] args){ 
		Integer []data = {1024, 793, 342, 450, 999, 99, 100, 99, 12, 4, 60, 31, 342, 36};
		printArray(data);
		quicksort(data);
 	}
}