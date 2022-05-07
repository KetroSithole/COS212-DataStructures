
public class Cuckoo {

	static void cuxkooHash(int []arr) {
		Integer []tab1 = new Integer[11];
		Integer []tab2 = new Integer[11];

		for (int index=0;	index<arr.length;	index++) {
			if ( tab1[arr[index] % 11] == null)
				tab1[arr[index] % 11] = arr[index];
			else {
				tab2[(tab1[arr[index] % 11] / 11) % 11] = tab1[arr[index] % 11];
				tab1[arr[index] % 11] = arr[index];
			}
		}

		printArray(tab1, "Table 1");
		printArray(tab2, "Table 2");

	}

	static void printArray(Integer arr[], String table)	{
		System.out.print(table + ": [");
		for (int i = 0; i <arr.length; i++)
			if (i == arr.length-1) System.out.println(arr[i] + "]");
			else System.out.print(arr[i] + ", ");
	}

	public static void main(String[] args){
		int []arr = {20, 50, 53, 75, 100, 67};
		cuxkooHash(arr);
	}
}