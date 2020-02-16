package array;

import java.util.List;

/**
 * Yor are given an array with positive and negative integer values.
 * Get the maximum sum of a subarray from the list.
 */
public class MaxSubArray {

    public int maxSubArray(final List<Integer> A) {
        if(A == null || A.isEmpty()){
            return -1;
        }
        int maxSum = maxEle(A);
        if(maxSum < 0) return maxSum;
        int sum = 0;
        for(int i=0;i<A.size();i++){
            sum +=A.get(i);

            if(sum<0){
                sum=0;
            } else if(sum>maxSum){
                maxSum=sum;
            }

        }
        return maxSum;
    }

    private  int maxEle(List<Integer> A){
        int maxSum = A.get(0);
        for(int i=0;i<A.size();i++){
            if(A.get(i)>maxSum){
                maxSum = A.get(i);
            }
        }
        return maxSum;
    }
}
