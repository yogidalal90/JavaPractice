package array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 */
public class SearchRotatedArrayI {
	
	public static void main(String[] args) {
		int[] a = {5,6,7,8,1,2,3};
		System.out.println(search(a,1));
	}

	private static int search(int[] nums, int target) {
		if(nums.length < 1){
			return -1;
		}

		if(nums.length <3){
			for(int i=0;i<nums.length;i++){
				if(nums[i] == target){
					return i;
				}
			}
			return -1;
		}
		int rotation =  findRotationPt(nums);
		int start = 0; int end = nums.length-1;
		System.out.println(rotation);
		if(rotation != -1){
			if(target == nums[end]){
				return end;
			}else if(target < nums[end]){
				start = rotation;
			} else {
				end = rotation;
			}
		}
		System.out.println(start+":"+end);
		while(start  <= end){
			int mid = (start+end)/2;

			if(nums[mid] == target){
				return mid;
			} else if(nums[mid] <target){
				start++;
			}else {
				end--;
			}
		}
		return -1;
	}

	private static int findRotationPt(int[] a){
		int low = 0, high = a.length-1;

		while(low <= high){

			int mid = (low+high)/2;
			if(mid == 0){
				return -1;
			}
			if(a[mid] < a[mid-1]){
				return mid;
			} else if(a[mid] > a[mid+1]){
				return mid+1;

			}else if(a[mid] > a[high]){
				low = mid+1;

			} else{
				high = mid-1;
			}
		}

		return -1;
	}
}
