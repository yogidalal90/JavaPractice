package searching;

/**
 * Count the number of times a specific value is present in array.
 */
public class CountRepeatingElementInSortedArray {

    public static void main(String[] args) {
        int[] array = {2,2,2,2,3,3,4,5,6,6,6};
        int value =6;
        int index = findRepeatingEleIndex(array,value);
        int count = 0;
        if(index != -1){
            for(int i=index;i<array.length;i++){
                if(array[i]==value)
                    count++;
                else
                    break;
            }
        }
        System.out.println(value+" is present at index: "+index+" and "+count+" times.");
    }

    public static  int findRepeatingEleIndex(int[] array, int val){
        if(array == null){
            return -1;
        }
        int low=0,  high =array.length;
        int mid ;
        //or mid = low + (high-low)/2 //to avoid integer size limit exceed issue due to (low+high)
        while(low<high){
            mid = (low+high)/2;
            if(array[mid] == val && ( mid == 0  ||  array[mid-1]<array[mid])){
                return mid;
            }
            else if(array[mid] >= val){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
