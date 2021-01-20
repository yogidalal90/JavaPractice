package searching;

public class FindFirstK {

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3,3,3,4,5,5};
        System.out.print(searchFirstK(arr,4));
    }
    static int searchFirstK(int[] arr, int k){

        int start =0, end = arr.length;
// 1,2,3,4,4,4,4,5
        while(start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]<k){
                start=mid+1;
            }else{
                end = mid;
            }
        }
        return (start<arr.length && arr[start]==k)?start:-1;

    }

}
