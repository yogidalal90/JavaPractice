package list;

import java.util.ArrayList;

/**
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 */
public class MaxDiffList {
    public int maxArr(ArrayList<Integer> A) {
        if(A == null || A.isEmpty()){
            return -1;
        }
        int max1=Integer.MIN_VALUE; int min1 = Integer.MAX_VALUE;
        int max2=Integer.MIN_VALUE; int min2 = Integer.MAX_VALUE;

        for(int i=0;i<A.size();i++){
            max1 = Math.max(max1,A.get(i)+i);
            max2 = Math.max(max2,A.get(i)-i);
            min1 = Math.min(min1,A.get(i)+i);
            min2 = Math.min(min2,A.get(i)-i);
        }
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans,Math.abs(max1-min1));
        ans = Math.max(ans,Math.abs(max2-min2));
        return ans;

    }
}
