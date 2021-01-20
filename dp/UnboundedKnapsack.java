package dp;

public class UnboundedKnapsack {
    private static int unboundedKnapsack(int W,
                                         int[] val, int[] wt) {

        if (W < 1)
            return 0;
        int n = val.length;
        int[] dp = new int[W + 1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if(i>=wt[j])
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
            }
        }

        return dp[W];
    }
    public static void main(String[] args) {
        int W = 100;
        int val[] = {1, 30};
        int wt[] =  {1, 50};
        System.out.println(unboundedKnapsack(W,  val, wt));
    }
}
