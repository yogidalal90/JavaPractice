package array;

import java.util.Arrays;

public class TripletSum {

    public static void main(String[] args) {
        int[] a = {5,7,2,5 };
        int sum = 13;
        System.out.println(maxClosetSum(a,sum));
    }

    private static int maxClosetSum(int[] a, int sum){
        int currSum = 0;
        int closestSum = 0;
        Arrays.sort(a);
        if(a.length < 3){
            return -1;
        }

        int first = 0, second =1,third = a.length-1;
        while(second != third){

            currSum = a[first]+a[second]+a[third];
            if(Math.abs(currSum-sum) < Math.abs(closestSum-sum)){
                closestSum = currSum;
            }

            if(currSum > sum){
                third--;
            }else{
                first++;
                second++;
            }
        }

        return closestSum;
    }
}
