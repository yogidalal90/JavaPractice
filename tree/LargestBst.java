package tree;
/**
 * Print the size of largest BST in the given tree
 *                       10
 *                  7           13
 *           6          8   19       17
 */
public class LargestBst {
    private static int size =0;
    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode r = t.createBST();
        System.out.println(largestBSTSubtree(r));
    }
    private static int largestBSTSubtree(TreeNode root) {
        isBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
       return size;
    }

    private static boolean isBst(TreeNode root, int min, int max){
        if(root == null)
            return true;

        if(root.data <= min || root.data >= max){
            return false;
        }

        if(isBst(root.left,min,root.data) && isBst(root.right,root.data,max)){
            size +=1;
            return true;
        }
        return  false;
    }
}
