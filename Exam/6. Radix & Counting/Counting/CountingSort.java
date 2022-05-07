class CountingSort {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";


	static void countSort(Integer[] data) {

		System.out.println(ANSI_RED + "**********   1  *********" + ANSI_RESET);
		int maxValue = Integer.MIN_VALUE;
		for (int index=0;	index<data.length;		index++)
			if (data[index] > maxValue) maxValue = data[index];

		Integer count[] = new Integer[maxValue + 1];
		for (int i = 0; i < count.length; i++) count[i] = 0;
		for (int i = 0; i < data.length; i++) count[data[i]]++;
		printArray(count, "Count");

		
		System.out.println(ANSI_RED + "**********   2  *********" + ANSI_RESET);
		for (int i = 1; i < count.length; i++)
			count[i] += count[i - 1];
		printArray(count, "Count");

		System.out.println(ANSI_RED + "**********   3  *********" + ANSI_RESET);
		Integer []temp = new Integer[data.length];
		for (int i=data.length-1;		i>=0;	i--) {
			temp[count[data[i]]-1] = data[i];
			printArray(temp, "Temp");
			printArray(count, "Count");
			count[data[i]]--;
		}

	}

	static void printArray(Integer[] arr, String arrType) {
		System.out.print(arrType + ": [");
		for (int i = 0; i < arr.length; i++)
			if (i == arr.length-1) System.out.println(arr[i] + "]");
			else System.out.print(arr[i] + ", ");
			if (arrType == "Count") System.out.println();
	}


	// Driver code
	public static void main(String[] args) {
		Integer[] arr = {7, 2, 9, 3, 7, 3, 4, 1};
		countSort(arr);
	}
}
