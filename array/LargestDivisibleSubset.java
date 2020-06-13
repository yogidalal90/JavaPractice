package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * Si % Sj = 0 or Sj % Si = 0.
 * Input: [1,2,4,6]
 * Output: [1,2,4] or [1,2,6]
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] data = {1,2,4,6};
        List<Integer> subSet = largestDivisibleSubset(data);
        for(int i:subSet)
            System.out.print(i+" ");
    }
    private static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int n=nums.length;
        if(n<2)
        {
            for(int i:nums)
                ls.add(i);
            return ls;
        }
        Arrays.sort(nums);
        int[] count = new int[n];
        Arrays.fill(count ,1);

        // count valid paris for each index
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    count[i]=Math.max(count[i],count[j]+1);
                }
            }
        }

        // find the index, at which we have max pairs
        int maxIndex = 0;
        for(int i=1;i<n;i++){
            maxIndex = count[i]>count[maxIndex]?i:maxIndex;
        }

        // track all the pairs to reach the maxIndex
        int temp = nums[maxIndex];
        int curr = count[maxIndex];
        for(int i=maxIndex;i>=0;i--){
            if(temp%nums[i]==0 && curr == count[i])
            {
                ls.add(nums[i]);
                temp = nums[i];
                curr--;
            }

        }
        return ls;
    }
}
