
public class StringMatch {

	static void findNext(String P, Integer []next) {
		next[0] = -1;
		int i=0, j=-1;
		while (i < P.length()-1) {
			while (j == -1 || (i<P.length()-1 && P.charAt(i) == P.charAt(j))) {
				i++;
				j++;
				next[i] = j;
			}
			j = next[j];
		}
		print(next);
	}

	static void print(Integer arr[])	{
		System.out.print("[");
		for (int i = 0; i <arr.length; i++)
			if (i == arr.length-1) System.out.println(arr[i] + "]");
			else System.out.print(arr[i] + ", ");
	}

	static boolean KnuthMorrisPratt (String P, String T) {
		Integer []next = new Integer[P.length()];
		findNext(P, next);
		int i=0, j=0;
		while (i-j <= T.length() - P.length()) {
			while (j == -1 || (j < P.length() && T.charAt(i) == P.charAt(j))) {
				i++;
				j++;
			}
			if (j== P.length()) return true;
			j = next[j];
		}
		return false;
	}


	public static void main(String[] args){
		String P = "abaabaca";
		String T = "abc";
		System.out.println(KnuthMorrisPratt(P, T));
		
	}
}