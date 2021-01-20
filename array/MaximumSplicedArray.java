package array;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplicedArray {
    public static void main(String[] args) {
        int[] A = {10,90,10};
        int[] B = {60,60,60};
        int[] res = new MaximumSplicedArray().maximumSplicedArray(A,B);
        System.out.print(res);
    }
    int[] bestSplice(int[] A, int[] B) {
        // find the maximum subarray sum in B-A
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ans[i] = B[i] - A[i];
        }

        int best = Integer.MIN_VALUE, start = 0, end = 0;
        int cur = 0, last = 0, cur_start = 0;
        for (int i = 0; i < ans.length; i++) {
            if (last <= 0) cur_start = i;
            cur = ans[i] + Math.max(last, 0);
            if (cur >= best) {
                best = cur;
                start = cur_start;
                end = i;
            }
            last = cur;
        }

        // copy over the ranges from A and B
        for (int i = 0; i < A.length; i++) {
            ans[i] = A[i];
        }
        // only copy over the range from B if it increases the final sum
        if (best > 0) {
            for (int i = start; i <= end; i++) {
                ans[i] = B[i];
            }
        }
        return ans;
    }

    int[] maximumSplicedArray(int[] A, int[] B) {
        int[] A_res = bestSplice(A, B);
        int[] B_res = bestSplice(B, A);

        // return the larger sum
        int A_sum = 0, B_sum = 0;
        for (int i = 0; i < A.length; i++) {
            A_sum += A_res[i];
            B_sum += B_res[i];
        }

        return A_sum > B_sum ? A_res : B_res;
    }
}
