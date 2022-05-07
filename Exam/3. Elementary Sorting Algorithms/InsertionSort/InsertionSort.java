public class InsertionSort {

    public static <T extends Comparable<? super T>> void printArr(T []data) {
        System.out.print("(");
        for (int i=0;   i<data.length;  i++) {
            if (i == data.length-1) System.out.println(data[i] + ")");
            else System.out.print(data[i] + ",");
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] data) {
        for (int i=1; i<data.length;    i++) {
            T temp = (T) data[i];
            int j = i -1;
            
            while (j >= 0 && data[j].compareTo(temp) > 0) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = temp;
            printArr(data);
        }
    }

    public static void main(String ...args) {
        Integer [] arr = new Integer[] {1024, 793, 342, 450, 999, 99, 100, 99, 12, 4, 60, 31, 342, 36};
        sort(arr);
    }
}


/* Best Case => 0 iterations */
/*  Worst Case => n iterations */
/* Average Case => 1/2 of worst case    */