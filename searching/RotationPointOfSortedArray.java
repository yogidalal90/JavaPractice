package searching;

/**
 * Consider an array of distinct numbers sorted in increasing order.
 * The array has been rotated (clockwise) k number of times.
 * Given such an array, find the value of k.
 */
public class RotationPointOfSortedArray {
    public static void main(String[] args) {
        int[]  array = {6,8,1,1,3,4,5};
        System.out.println(indexOfRotation(array));
    }

    public static int indexOfRotation(int[] array){
        if(array == null){
            return -1;
        }
        int low=0,high=array.length;
        int mid;
        while(low<high){
            mid= low+(high-low)/2;
            if(mid == 0){
                return -1;
            }
            // If previous element is higher that current, then current index is point of rotation
            else if(array[mid]<array[mid-1]){
                return mid;

            } else if(array[mid]>array[0]){ // if first element is smaller that middle one, rotation point is in 2nd half
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return -1;
    }
}
