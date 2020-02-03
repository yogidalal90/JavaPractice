package list;

import java.util.ArrayList;

/**
 * Given an array with positive and negative values.
 * Print a subarray with maximum sum and containing only positive elements
 */
public class MaxSumNonNegativeArray {
// 1, 2, 5, -7, 2, 5
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(-7);
        A.add(2);
        A.add(5);
        A.toArray();
        System.out.println(maxset(A));
    }

    private static ArrayList<Integer> maxset(ArrayList<Integer> A) {

             int L = 0;
             int R = 0;
             long maxWindowSum = 0;
             int maxWindowStart = 0;
             int maxWindowEnd = 0;
             long currentWindowSum = 0;

             while (true) {
                 while (R < A.size() && A.get(R) >= 0) {
                     currentWindowSum += A.get(R);
                     R++;
                 }

                 if (R <= A.size()) {
                     if (currentWindowSum > maxWindowSum) {
                         maxWindowSum = currentWindowSum;
                         maxWindowStart = L;
                         maxWindowEnd = R;
                     } else if (maxWindowSum == currentWindowSum) {


                         if ((R - L) > (maxWindowEnd - maxWindowStart)) {
                             maxWindowStart = L;
                             maxWindowEnd = R;
                         } else if ((R - L) == (maxWindowEnd - maxWindowStart)) {
                             maxWindowStart = L;
                             maxWindowEnd = R;
                         }
                     }

                     R = R + 1;
                     L = R;
                     currentWindowSum = 0;
                 } else {
                     break;
                 }
             }
             ArrayList<Integer> al =new ArrayList<>();
             for(int i=maxWindowStart;i<maxWindowEnd;i++){
                 al.add(A.get(i));
             }
             return al;
         }
}
