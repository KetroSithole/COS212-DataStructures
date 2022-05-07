public class ShellSort {

	static <T extends Comparable<? super T>> void printArray(T data[]) {
        int n = data.length;
        for (int i=0; i<n; ++i)
            System.out.print(data[i] + " ");
        System.out.println();
    }

    static <T extends Comparable<? super T>> void swap(T []data, int i, int j) {
    	T temp = data[i];
    	data[i] = data[j];
    	data[j] = temp;
    }

	static <T extends Comparable<? super T>> void sort(T []data) {
		for (int gap = 5; gap >=1; gap =  (int)Math.floor(gap /1.3)) {
            for (int i = gap; i < data.length; i ++) {
                T temp = data[i];
                int j;
                for (j = i; j >= gap && data[j - gap].compareTo(temp) > 0; j -= gap)
                    data[j] = data[j - gap];
                data[j] = temp;
            }
            printArray(data);
        }
	}
    

	public static void main(String[] args){
		Integer []data = {1024, 793, 342, 450, 999, 99, 100, 99, 12, 4, 60, 31, 342, 36};
		sort(data);
	}
}

/*  https://www.w3resource.com/ODSA/AV/Sorting/shellsortAV.html */