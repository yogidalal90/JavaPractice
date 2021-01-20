package searching;

/**
 * You are given n sticks with differing lengths. You can either increase or decrease the length of the sticks. An array of cost was provided where ith entry denotes cost for increasing or decreasing the length of the ith stick by 1 unit.
 * You have to make all the sticks of equal length and ensure minimum cost was incurred doing this.
 */
public class MinCostForAverage {
    public static void main(String[] args) {
        int arr[] = { 100, 100, 101 };
        int costs[] = {3,3,4};
        int cost = new MinCostForAverage().findMinCost(arr,costs);
        System.out.print(cost);
    }

    int findMinCost(int[] arr, int[] costs){

        int n = arr.length;
        int min  = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i:arr){
            min = (i<min)?i:min;
            max = (i>max)?i:max;
        }

        while((max-min)>2){
            int mid1 = min + (max-min)/3;
            int mid2= max - (max-min)/3;
            int cost1 = costWithMid(arr,mid1,costs);
            int cost2 = costWithMid(arr,mid2,costs);
            if(cost1 < cost2){
                max=mid2;
            }else
                min  = mid1;
        }
        return costWithMid(arr, (max+min)/2,costs);
    }
    int costWithMid(int[] arr, int cost, int[] costs){
        int total = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            total += Math.abs(arr[i]-cost)*costs[i];
        }
        return total;
    }
}
