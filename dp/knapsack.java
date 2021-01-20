package dp;

public class knapsack {

    static int[] val = {1,1};
    static  int[] wt = {2,1};

    public static void main(String[] args) {
        System.out.print(calculateQuantity(3,3));
    }
    static int calculateQuantity(int n, int w){

        int[][] dp = new int[w+1][2];

        for(int i=0;i<=w;i++){
            for(int j=0;j<wt.length;j++){
                if(wt[j]<=i && dp[i-wt[j]][1]<n){

                    if(dp[i][0]<=dp[i-wt[j]][0]+val[j]){
                        dp[i][0]=dp[i-wt[j]][0]+val[j];
                        dp[i][1] = dp[i-wt[j]][1]+1;

                    }

                }
            }
        }

        return dp[w][0];


    }

}
