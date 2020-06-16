package array;

import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Given nums = [1,1,1,2,2,3]
 * out: [1, 1, 2, 2, 3]
 *
 */
public class RemoveDuplicateFromSortedII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int ret = new RemoveDuplicateFromSortedII().removeDuplicates(nums);
        int[] arr = Arrays.copyOfRange(nums,0, ret);
        for(int out:arr)
            System.out.print(out+" ");
    }
    private int removeDuplicates(int[] nums) {
        int n  = nums.length;
        if(n <3)
            return 2;

        int i=2;
        for(int j=2;j<n;j++){
            if(nums[j]!=nums[i-2]){
                nums[i++]=nums[j];
            }
        }
        return i;
    }
}
