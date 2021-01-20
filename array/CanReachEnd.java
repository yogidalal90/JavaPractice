package array;

public class CanReachEnd {

    public static void main(String[] args) {
        int[] arr = {3,0,0,0,1,1,1};
        System.out.print(canReachEnd(arr));
    }
   static boolean canReachEnd(int[] arr){
        if(arr == null || arr.length<2)
            return true;
        int end =arr.length-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==0) {
                end=i+1; break;
            }
        }
        for(int i=0;i<end;i++){
            if(arr[i]+i >= end)
                return true;
        }
        return false;

    }

}
