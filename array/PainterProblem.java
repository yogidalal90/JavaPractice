package array;

public class PainterProblem {

    public static void main(String[] args) {
        int[] arr = {274,465,130,135,254,45,70,122,149,95,453,65,392,331,316,484,372,339,45,46,31,167,351,415,387,275,355,440,290,462,436,416,279,66,403,33,464,473,8,113,420,461,30,312};
        System.out.print(paintPartition(arr,26,44));
    }
    private static int paintPartition(int[] arr, int k, int n){
        int right= 0; 	int left = -1;
        for(int i:arr){
            left = Math.max(left,i);
            right +=i;
        }

        int maxSum =0;
        while(left <= right){
            int mid = (right+left)/2;

            if(isValid(arr,k,n,mid)){
                maxSum = mid;
                right=mid-1;
            }else{
                left= mid+1;
            }
        }
        return maxSum;
    }

    private static boolean isValid(int[] arr, int k, int n, int mid){
        int count=1; int curr=0;
        for(int i=0;i<n;i++){
            if(curr+arr[i] > mid){
                count+=1;
                curr=0;
                if(count>k){
                    return false;
                }
            }
            curr +=arr[i];

        }
        return true;
    }
}
