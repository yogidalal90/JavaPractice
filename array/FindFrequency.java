package array;

import java.util.Arrays;

public class FindFrequency {


    public static int findFreq(int[] arr, int a){
        int n =arr.length;
// 1,2,3,4,4,4,4,5
        Arrays.sort(arr);
        int start= 0, end = n;
        int first=-1;
        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid] >= a ){
                if((mid>0 && arr[mid-1] !=a && arr[mid]==a)||(mid==0 && arr[mid]==a)){
                    start = mid;
                    first= mid;
                    break;
                }
                end=mid;
            }else{
                start = mid+1;
            }
        }
        if(first ==-1 && arr[start] != a)
            return -1;
        first = start;
        end=n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] >=a){
                if((mid<n-1 && arr[mid+1]!=a && arr[mid]==a) || (mid==n-1 && arr[mid]==a)){
                    end = mid; break;
                }
                end = mid-1;

            }else{
                start= mid+1;
            }

        }
        return end-first+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1,1,1};
        System.out.println(findFreq(arr,1));
    }
}
