package searching;

import java.util.*;

public class FindKthElementQuick
{

    public static void main(String[] args) {
        int[] arr ={-4,3,2,6,5,9};
        System.out.println("-4,3,2,6,5,9");
        System.out.print(findKthLargest(arr,2));

    }
        public static int findKthLargest(int[] A, int k) {
        k = A.length - k; // convert to index of k largest
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int i = l; // partition [l,r] by A[l]: [l,i]<A[l], [i+1,j)>=A[l]
            for (int j = l + 1; j <= r; j++)
                if (A[j] < A[l]) swap(A, j, ++i);
            swap(A, l, i);

            if (k < i) r = i - 1;
            else if (k > i) l = i + 1;
            else return A[i];
        }
        return -1; // k is invalid
    }


    static void swap(int[] arr, int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] =temp;
    }
}
