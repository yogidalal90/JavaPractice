package dp;

public class MaxSumGame {

    private static pair[][] findMaxSum(int[] arr){
        int n = arr.length;
        pair[][] dp =  new pair[n][n];

        // fill dp matrix
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++)
               dp[i][j]=new pair();
        }

        //set diagonal elements
        for(int i=0;i<n;i++){
            dp[i][i].first=arr[i];
            dp[i][i].index=i;
        }

        for(int k=2;k<=n;k++){
            for(int i=0;i<=n-k;i++){
                int j=i+k-1;
                if(arr[i]+dp[i+1][j].second > arr[j]+dp[i][j-1].second){
                    dp[i][j].first = arr[i]+dp[i+1][j].second;
                    dp[i][j].second = dp[i+1][j].first;
                    dp[i][j].index=i;
                }else{
                    dp[i][j].first = arr[j]+dp[i][j-1].second;
                    dp[i][j].second = dp[i][j-1].first;
                    dp[i][j].index=j;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
       
        int[] arr= {5, 1, 2,1,3,1,3,2};
       pair[][] res = findMaxSum(arr);

       int i=0;int j=arr.length-1;
        System.out.println(res[i][j]);
        for(int k=0;k<res.length;k++){
           int idx=res[i][j].index;
           System.out.println(idx+" : "+arr[idx]);
           if(idx <= i)
               i++;
           else
               j--;
        }
    }

    static class pair{
        int first, second;
        int index=0;
        public String toString(){
            return first+":"+second+":"+index;
        }
    }
}
