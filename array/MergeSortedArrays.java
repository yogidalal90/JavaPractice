package array;

public class MergeSortedArrays {
    int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int idx = m+n-1;
        int mi=m-1;
        int ni = n-1;
        while(mi>=0 && ni>=0){
            if(nums1[mi] > nums1[ni]){
                nums1[idx--]=nums1[mi--];
            }else
                nums1[idx--] = nums2[ni--];
        }

        if(ni>=0)
            nums1[idx--]= nums2[ni--];

        return nums1;
    }

}
