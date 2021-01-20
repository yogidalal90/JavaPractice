package array;
import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] arr) {
        int n  = arr.length;
        List<List<Integer>> ls = new ArrayList<>();
        if(n<3)
            return ls;
        Arrays.sort(arr);
        int i=0;
        while(i<n && arr[i]<=0){
            if(i>0 && arr[i]==arr[i-1]){
                i++;
                continue;
            }

            int target = 0-arr[i];
            int left= i+1;
            int right=n-1;
            while(left<right){
                int currSum = arr[left]+arr[right];
                if(currSum < target){
                    left++;
                }else if(currSum > target){
                    right--;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);list.add(arr[left]);list.add(arr[right]);
                    ls.add(list);


                    while(left<right && arr[left+1]==arr[left]){
                        left++;
                    }
                    while(right>left && arr[right-1]==arr[right])
                        right--;
                    left = left+1;
                    right = right-1;

                }

            }
            i++;
        }
        return ls;
    }

}
