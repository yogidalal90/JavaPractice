package searching;

public class BinarySearch {
	
	public static void main(String args[]) 
    { 
        BinarySearch ob = new BinarySearch(); 
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length; 
        int x = 100;
        int result = ob.binarySearch(arr, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at " +  
                                   "index " + result); 
    }

	private int binarySearch(int[] arr, int x) {
		int lth = arr.length;
		int start = 0, end=lth-1;
		int mid;
		while(start<end){
			mid = start + (end-start)/2;
			if(x == arr[mid]){
				return mid;
			} else if(x < arr[mid]){
				end = mid-1;
			} else 
				start = mid+1;
		}
		
		
		return -1;
	} 

}
