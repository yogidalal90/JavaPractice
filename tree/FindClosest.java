package tree;

public class FindClosest {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        TreeNode root = node.createBST();
        TreeNode res = findClosest(root,12);
        System.out.print(res.data);
    }
    static TreeNode res ;
    static int closest = Integer.MAX_VALUE;
    private static  TreeNode findClosest(TreeNode root, int target){
        if(root==null)
            return null;

        if(root.data==target) {
            res= root;
            closest=0;
        }
        int diff = Math.abs(target-root.data);
        if(diff<closest) {
            closest = diff;
            res = root;
        }
        if(root.data > target)
            findClosest(root.left,target);
        else
            findClosest(root.right, target);
        return res;
    }
}
