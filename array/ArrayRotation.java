package array;

/**
 * Rotate the array in anti-clockwise manner.
 */
public class ArrayRotation {

	public static void main(String[] args) {
		// Write a function rotate(ar[], d, n) that rotates arr[] of size n by d
		// elements.
		int[] arr = { 1, 2, 6, 4, 3, 2, 3, 7, 6 };
		int n = arr.length;
		int d = 3;

		// 1. can use temp array of size d
		// 2. rotate elements one by one
		for (int i = 0; i < n-d; i++) {
			arr[i] = arr[i] ^ arr[d + i ];
			arr[d + i ] = arr[i] ^ arr[d + i ];
			arr[i] = arr[i] ^ arr[d + i ];

		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]+",");
		}
	}
}