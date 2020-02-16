package searching;

/**
 * Search the index of an element, in a sorted array using Jump Sort
 */
public class JumpSearch {

    public static void main(String [ ] args)
    { 
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 
                    34, 55, 89, 144, 233, 377, 610}; 
        int x = 55; 
  
        int index = jumpSearch(arr, x);
        System.out.println("Number " + x + " is at index " + index);
    }

	private static int jumpSearch(int[] arr, int x) {
		int lth = arr.length;
		int j = 4; //(√n) is 4.
		
		int start = 0;
		int end=start+j;
		return 0;
	} 
}
