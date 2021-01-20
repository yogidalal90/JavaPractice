package sorting;

import java.util.Arrays;

public class KthLargestInSorted {
    public static void main(String[] args) {
        int[] arr1 = {11,13,15,17};
        int[] arr2= {12,14,16};
       System.out.print(kthLargestInSortedArrays(arr1,arr1.length,arr2,arr2.length,3));

    }

    static int kthLargestInSortedArrays(int[] a, int n, int[] b,int m,int k){

        if(k>m+n || k<1)
            return -1;

        if(m<n){
            return kthLargestInSortedArrays(b,m,a,n,k);
        }

        if(m==0){
            return b[k-1];
        }

        if(k==1)
            return Math.min(a[0],b[0]);

        int i=Math.min(k/2,a.length);
        int j=Math.min(k/2,b.length);
        //discard element till i-1
        if(a[i-1] < b[j-1]){
            
            
            int[] temp = Arrays.copyOfRange(a,i,n);
            return kthLargestInSortedArrays(temp,temp.length,b,m,k-i);
        }else{
            int[] temp  = Arrays.copyOfRange(b,j,m);
            return kthLargestInSortedArrays(a,n,temp,temp.length,k-j);
        }

    }

}
