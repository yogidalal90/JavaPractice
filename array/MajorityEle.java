package array;

/**
 * Prints the majority element (if it exists), otherwise prints “No Majority Element”.
 * Majority element is an element which has occurrences > arr.length/2
 */
public class MajorityEle {

	public static void main(String[] args) {
		int arr[] = {2, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
		 	int majIndex = printMajorityElement(arr);
			if(majIndex == -1) {
				System.out.println("no majority element");
			} else {
				System.out.println(arr[majIndex]);
			}
	}

	private static int printMajorityElement(int arr[]) {
		if(arr.length < 1){
			return -1;
		}
		int majEleIndex = 0;
		int eleCount = 1;
		int majEleCount = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[majEleIndex] == arr[i]) {
				eleCount++;
			} else {
				eleCount--;
			}
			if (eleCount == 0) {
				majEleIndex = i;
				eleCount = 1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[majEleIndex]) {
				majEleCount++;
			}
		}
		if (majEleCount > arr.length / 2) {
			return majEleIndex;
		}
		return -1;
	}
}
