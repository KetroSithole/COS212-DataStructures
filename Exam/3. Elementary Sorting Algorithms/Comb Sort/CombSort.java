
public class CombSort {

    static void swap(int []arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArr(int []arr) {
        System.out.print("(");
        for (int i=0;   i<arr.length;  i++) {
            if (i == arr.length-1) System.out.println(arr[i] + ")");
            else System.out.print(arr[i] + ",");
        }
    }

	static void sort(int []data) {
		int gap = data.length;
    	boolean swapped = false;
    	while (gap > 1 || swapped) {
        	swapped = false;
            gap = (gap > 1) ? (int)(gap/1.3) : gap;

            int  i = 0;
            while (i + gap < data.length) {
                if (data[i] > data[i + gap]) {
                    swap(data, i, i + gap);
                    swapped = true;
                }
                i++;
                if (i+gap == data.length) printArr(data);
            }
        }
	}

	public static void main(String[] args){
		int []data = {8, 3, 14, 2, 9, 1, 25, 7};
        sort(data);
        
	}
}
