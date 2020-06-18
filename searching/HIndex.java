package searching;

import java.util.Arrays;

/**
 * 274. H-Index
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 */
public class HIndex {
    private int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        int low=0, high = n-1;

        while(low<= high){
            int mid  = low+(high-low)/2;

            if(citations[mid]==n-mid){
                return n-mid;
            }
            if(citations[mid]<n-mid){
                low=mid+1;
            }else
                high=mid-1;
        }

        return n-low;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex.hIndex(citations));
    }
}
