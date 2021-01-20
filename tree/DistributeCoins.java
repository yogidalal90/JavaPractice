package tree;

public class DistributeCoins {
    int countMoves=0;
    int distributeCoins(TreeNode root){
        distributionHelper(root);
        return countMoves;
    }

    int distributionHelper(TreeNode root){
        if(root== null)
            return 0;

        int left= distributionHelper(root.left);
        int right = distributionHelper(root.right);

        countMoves += Math.abs(left)+Math.abs(right);
        return root.data+left+right-1;
    }
}