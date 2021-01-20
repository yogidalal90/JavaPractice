package array;

public class BuySellTwo {

    public static void main(String[] args) {
        int[] arr = {12,11,13,9,12,8,14,13,15};
        System.out.print(buySell(arr));
    }
    static int buySell(int[] arr){
        int n=arr.length;
        int[] fwd = new int[n];
        int[] bwd = new int[n];
        int front=0;
        int back =0;
        int min = arr[0]; int max = arr[n-1];
        for(int i=0;i<n;i++){
            min = Math.min(min,arr[i]);
            front= Math.max(front,arr[i]-min );
            fwd[i]=front;

            max = Math.max(max,arr[n-i-1]);
            back  = Math.max(back,max-arr[n-i-1]);
            bwd[n-i-1] = back;
        }
        int maxPrice = 0;int maxProfit =0;
        for(int i=n-1;i>0;i--){

            maxPrice = Math.max(maxPrice ,arr[i]);
            maxProfit = Math.max(maxProfit, fwd[i-1]+maxPrice-arr[i]);
        }
        return  maxProfit;
    }
}
