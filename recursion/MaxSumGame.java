package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MaxSumGame {


    static int findMax(int[] arr, int i, int j, int sum){
        if(i+1 == j)
            return Math.max(arr[i],arr[j]);

        return Math.max(sum-(findMax(arr,i+1,j,sum-arr[i])),sum-(findMax(arr,i,j-1,sum-arr[j])));
    }



    public static void main(String[] args) {
       // 42
        int[] arr=  {4993 ,4883 ,8894, 7241 ,1476 ,8226 ,1207 ,5674 ,6967 ,6766 ,8371 ,1467, 3169 ,2228 ,297 ,288 ,4300 ,4194 ,4689 ,1155 ,3934 ,5209 ,4342 ,2916};
        //8,15, 3, 7};
       int sum = 0;
       for(int i:arr){
           sum +=i;
       }
       System.out.print(findMax(arr,0,arr.length-1,sum));
    }
}
