package array;

//program for an array where keep all 0'z at beginning positions and all 1's at last positions
public class ZerosOnes {
	public static void main(String[] args) {
		int arr[] = {1,0,0,1,1,1,0,0,1};
		zerosAndOnes(arr);
	}
	
	private static int[] zerosAndOnes(int[] arr){
		if(arr.length == 0 || arr.length==1)
			return arr;

		int lth = arr.length;
		int end = lth-1;
		int curr=0;
		// run two counter from start and end. Swap if curr is 1 and end is 0
		// else increase curr by 1 and decrease end by 1
		while(curr<end){
			if(arr[curr] == 0){
				curr++;
			}
			if(arr[end] == 1){
				end --;
			}

			if(arr[curr] != arr[end] ){
				arr[curr]=arr[curr]^arr[end];
				arr[end]=arr[curr]^arr[end];
				arr[curr]=arr[curr]^arr[end];
				curr++;
				end --;
			}
		}
		for(int a:arr){
			System.out.print(a+" ");
		}
		return arr;
	}
}
