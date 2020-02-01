package array;

/**
 * Find the missing and repeated number from an array, which should hold a sequence of numbers.
 */
public class MissingRepeatingNumbers {
	
	public static void main(String[] args) {
		int[] a = { 3, 2, 3, 5, 5, 7, 6, 8, 8};
		findNumbers(a);
	}
	
	private static void findNumbers(int a[]){
		int n=a.length;
		int arr[] = new int[n+1];
		
		for(int i=0;i<n;i++){
			if(arr[a[i]] != 0)
				System.out.println("repeating number: "+ a[i]);
			arr[a[i]] = a[i];
			
		}
		for(int i=1;i<n+1;i++){
			if(arr[i] == 0)
				System.out.println("missing number: "+i);
		}
	}

}
