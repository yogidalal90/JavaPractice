package array;

import java.util.Arrays;
/**
 * Find the elements in an array with odd number of occurrences.
 */
public class OddOneOut {
	
	public static void main(String[] args) {
		int[] arr = {1, 1,  2, 5, 4, 3, 4, 3, 2, 6, 6};
		findOddNum(arr);
		System.out.println("Find Num:");
		findNum(arr);
	}

	//Bitwise Operator : If only one number present, with odd occurrence
	private  static void findNum(int[] arr){
		int val = 0;
		for(int i=0;i<arr.length;i++){
			val = val^arr[i];
		}
		System.out.println(val);
	}

	//Arithmetic operation : For any number of elements with odd occurrences
	private static void findOddNum(int[] arr){
		if(arr == null){
			System.out.println("Empty array");
			return;
		}

		Arrays.sort(arr);
		for(int i=0;i<=arr.length-1;i++){
			if(i==arr.length-1){
				System.out.println(arr[i]);
				break;
			}
			if(arr[i] != arr[i+1]){
				System.out.println(arr[i]);
				continue;
			}
			i=i+1;
		}
	}
}
