package array;

/**
 * Print the combination on elements in the array.
 */
public class PermutationElement {
	
	public static void main(String[] args) {
		int[] arr = {1,3,5};
		int lth=arr.length;
		permute(arr,lth,0);
	}

	static void permute(int[] arr, int lth, int index){
		if(index >= lth)
			printArray(arr,lth);
		for(int i=index;i<lth;i++){
		//	System.out.println("swaping1: "+index + "to"+i);
			swap(arr,index,i);
		//	System.out.println("permute with"+(index+1));
			permute(arr,lth,index+1);
			swap(arr,index,i);
	//		System.out.println("swaping2: "+index + "to"+i);

		}
		
	}
	
	static void swap(int[] arr,int a, int b){
		int temp = arr[a];
		arr[a]=arr[b]; 
		arr[b]=temp;
	}
	static void printArray(int[] a, int n){
		for(int i=0;i<n;i++)
			System.out.print(a[i]);
		System.out.println();
	}
}
