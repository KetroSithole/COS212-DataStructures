// Radix sort Java implementation
import java.io.*;
import java.util.*;

class RadixSort {

	static int getMax(int arr[])	{
		int mx = arr[0];
		for (int i = 1; i < arr.length; i++)
			mx = (arr[i] > mx) ? arr[i] : mx;
		return mx;
	}

	static void countSort(int arr[], int exp) {
		int output[] = new int[arr.length];
		int count[] = new int[10];
		Arrays.fill(count, 0);

		for (int i=0;	i<arr.length;	i++) count[(arr[i] / exp) % 10]++;
		for (int i=1;	i<10;	i++) count[i] += count[i - 1];
		for (int i=arr.length-1;		i>=0;	i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		for (int i=0;	i<arr.length;	i++) arr[i] = output[i];
	}

	static void radixsort(int arr[])	{
		int m = getMax(arr);
		for (int exp = 1; m / exp > 0; exp *= 10) {
			print(arr);
			countSort(arr, exp);
		}
	}

	static void print(int arr[])	{
		System.out.print("[");
		for (int i = 0; i <arr.length; i++)
			if (i == arr.length-1) System.out.println(arr[i] + "]");
			else System.out.print(arr[i] + ", ");
	}

	public static void main(String[] args) {
		int arr[] = {1024, 793, 342, 450, 999, 99, 100, 99, 12, 4, 60, 31, 342, 36};
		int n = arr.length;
		radixsort(arr);
		print(arr);
	}
}
