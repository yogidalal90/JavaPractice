package tree;

public class RootToLeafSum {

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode r = t.createBT();
        System.out.print(hasPathSum(r,7));
    }
  static  boolean hasPathSum(TreeNode root, int sum){
        if(root == null){
            return sum == 0;
        }

        if(root.left == null && root.right==null)
            return sum==root.data;

        return hasPathSum(root.left,sum-root.data) ||
                hasPathSum(root.right,sum-root.data);

    }

}
