package dp;

/**
 * Count the minimum number of operations required to make a string palindrome.
 */
public class PalindromeMinInsrtn {

	public static void main(String[] args) {
			String str = "ascsssa";
			System.out.println(minimumInsertion(str.toCharArray(), 0, str.length() - 1));

	}

	private static int minimumInsertion(char str[], int low, int high) {
		if (low > high)
			return Integer.MAX_VALUE;
		if (low == high)
			return 0;
		if (low == high - 1)
			return (str[low] == str[high]) ? 0 : 1;

		return (str[low] == str[high]) ? minimumInsertion(str, low + 1, high - 1)
				: (Integer.min(minimumInsertion(str, low, high - 1), minimumInsertion(str, low + 1, high)) + 1);
	}
}