package list;

import java.util.ArrayList;

/**
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 */
public class MaxAbsoluteDiff {
    public int maxArr(ArrayList<Integer> A) {

        if(A == null || A.isEmpty()){
            return -1;
        }
        int maxSum=0;

        for(int i=0;i<A.size();i++){
            int sum=0;
            for(int j=0;j<=i;j++){
                sum = Math.abs(A.get(i)-A.get(j)) + Math.abs(i-j);
                if(sum>maxSum){
                    maxSum=sum;
                }
            }
        }
        return maxSum;
    }

}
