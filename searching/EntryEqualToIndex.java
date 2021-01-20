package searching;

public class EntryEqualToIndex {

    int searchEntryEqualToIndex(int[] arr){

        int start =0, end = arr.length;
// 0,1,2,3,4,7,12

        while(start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]>mid){
                end=mid-1;
            }else if(arr[mid] < mid){
                start = mid+1;
            }else
                return mid;
        }
        return -1;

    }

}
