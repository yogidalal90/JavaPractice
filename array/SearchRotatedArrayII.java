package array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 */
public class SearchRotatedArrayII {
	
	public static void main(String[] args) {
		int[] arr = {5,6,7,8,1,2,3};
		System.out.println(search(arr,1));
	}

	private static boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return true;
			}
			//If we know for sure right side is sorted or left side is unsorted
			if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
				//If we know for sure left side is sorted or right side is unsorted
			} else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
				if (target < nums[mid] && target >= nums[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
				//If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
				//any of the two sides won't change the result but can help remove duplicate from
				//consideration, here we just use end-- but left++ works too
			} else {
				end--;
			}
		}
		return false;
	}
}
