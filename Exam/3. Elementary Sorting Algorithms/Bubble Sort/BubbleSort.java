public class BubbleSort {

    public static <T extends Comparable<? super T>> void printArr(T []data) {
        System.out.print("(");
        for (int i=0;   i<data.length;  i++) {
            if (i == data.length-1) System.out.println(data[i] + ")");
            else System.out.print(data[i] + ",");
        }
    }

    public  static <T extends Comparable<? super T>> void swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static <T extends Comparable<? super T>> void sort(T[] data) {
        for (int i=0;   i<data.length-1;    i++) {
            for (int j =data.length-1;  j>=i+1;  j--) {
                if (data[j].compareTo(data[j-1]) < 0) {
                    swap(data, j, j-1);
                    printArr(data);
                }
            }
        }
    }

    public static void main(String ...args) {
        Integer [] arr = new Integer[]{1024, 793, 342, 450, 999, 99, 100, 99, 12, 4, 60, 31, 342, 36};
        printArr(arr);
        sort(arr);
    }
}