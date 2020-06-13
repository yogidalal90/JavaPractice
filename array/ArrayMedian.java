package array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class ArrayMedian {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,8,21};
        int[] arr2 = {5,7,9,13,15,22};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        if(n1 < n2)
            return findMedianSortedArray(nums1,nums2);
        else
            return findMedianSortedArray(nums2, nums1);

    }
    private static double findMedianSortedArray(int[] nums1, int[] nums2){
        int start = 0, end = nums1.length;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while(start <= end){
            int limitX = start + (end-start)/2;
            int limitY  = (n1+n2+1)/2-limitX;

            int leftxMax = (limitX > 0)?nums1[limitX-1]:Integer.MIN_VALUE;
            int leftyMax = (limitY > 0)?nums2[limitY-1]:Integer.MIN_VALUE;

            int rightxMin = (limitX < n1)?nums1[limitX]:Integer.MAX_VALUE;
            int rightyMin = (limitY < n2)?nums2[limitY]:Integer.MAX_VALUE;

            if(leftxMax <= rightyMin && leftyMax <= rightxMin){
                if((n1+n2)%2 == 0){
                    return ((double)Math.max(leftxMax,leftyMax) + Math.min(rightyMin,rightxMin))/2;
                }
                else
                    return Math.max(leftxMax,leftyMax);

            }else if(leftxMax > rightyMin){
                end = limitX-1;
            }else{
                start = limitX+1;
            }

        }
        return 0;
    }

}
