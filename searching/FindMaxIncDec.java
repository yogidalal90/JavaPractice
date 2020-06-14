package searching;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Find peak element
 */
public class FindMaxIncDec {

    public static void main(String[] args) {
        int[] arr = {8, 10, 20, 180, 100, 200, 400, 500, 600, 700, 500};
        System.out.println(findMaxIncDec(arr));

    }

    public static int findMaxIncDec(int[] arr){

        int low =0, high = arr.length-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(arr[mid] < arr[mid+1]){
                low =mid+1;
            }else{
                high = mid;
            }
        }
        return arr[low];

    }
}
