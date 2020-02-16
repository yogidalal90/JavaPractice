package array;

/**
 * Find the element in array which is present more than 50% of size of array.
 */
public class MaxOccurrence {

	public static void main(String[] args) {

		int[] arr = { 0,2,1, 2, 2, 2, 2, 4, 5, 3,2,2 };
		int num = (arr.length / 2) + 1;
		// where elements with small numbers only.
		countNum(arr, num);
		// can be used for large as well as small numbers.
		maxOccurance(arr, num);
	}
	
	
	static int maxOccurance(int[] arr, int num){
		int maxNum = 0; int element = 0;
		for(int i=0;i<arr.length;i++){
			int count=1;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]==arr[i]){
					count++;
				}
			}
			if(maxNum<count){
				maxNum=count;
				element = arr[i];
			}
		}
		
		System.out.println("maxNum: "+maxNum);
		System.out.println("element: "+element);
		return element;
	}
	
	
	static int countNum(int[] arr, int num){
		int max = 0;
		// find max to find size of array B
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		int[] b = new int[max+1];
		
		//insert the number of appearance in b
		for (int i = 0; i < arr.length; i++) {
			b[arr[i]]++;
		}
		
		for (int i = 0; i < b.length; i++) {
			if (b[i] >= num) {
				System.out.println("maxNum: "+b[i]);
				System.out.println("element: "+i);
				return i;
			}
		}
		return -1;
	}
}
