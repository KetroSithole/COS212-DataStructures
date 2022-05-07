public class SelectionSort {

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
        int i,j,least;
        for (i = 0; i < data.length-1; i++) {
            for (j = i+1, least = i; j < data.length; j++)
                if (data[j].compareTo(data[least]) < 0) least = j;
                if (i != least) {
                    swap(data,least,i);
                    printArr(data);
                }
        }
    }

    public static void main(String ...args) {
        Integer [] arr = new Integer[] {1024, 793, 342, 450, 999, 99, 100, 99, 12, 4, 60, 31, 342, 36};
        printArr(arr);
        sort(arr);
        printArr(arr);
    }
}
