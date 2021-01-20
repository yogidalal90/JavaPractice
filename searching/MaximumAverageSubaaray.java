package searching;

public class MaximumAverageSubaaray {
    public static void main(String[] args) {
        int[] arr =  {1,12,-5,-6,50,3};
        int k = 4;
        System.out.print(new MaximumAverageSubaaray().maxAverage(arr,k));
    }
    public double maxAverage(int[] nums, int k) {

        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i:nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
//might need to update it
        Double left = (double)min; Double right= (double)max;
        //0.00001
        while(left+ 0.01  <right){
            Double mid = left + (right-left)/2;
            if(isValid(nums,mid,k)){
                left = mid;
            }else
                right=mid;
        }
        return left;
    }

    boolean isValid(int[] nums, double target, int k){

        double sum =0;
        for(int i=0;i<k;i++){
            sum +=nums[i]-target;
        }
        if(sum >= 0)
            return true;
        double prev = 0;
        for(int i=k;i<nums.length;i++){

            sum +=nums[i]-target;
            prev += nums[i-k]-target;


                if(prev<0){
                    sum -= prev;
                    prev =0;
                }

            //check it
            if(sum >= 0){
                return true;
            }


        }
        return false;
    }

}
