package tree;
/**
 *
 *                       10
 *                  7           13
 *           6          8   19       17
 *
 */
public class KthSmallestInBst {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        TreeNode root = node.createBST();
        KthSmallestInBst kth = new KthSmallestInBst();
        System.out.print(kth.KthSmallestElement(root,2));
    }
    int num; int val=-1;
    public int KthSmallestElement(TreeNode root, int K)
    {
        num = K;
        if(root == null || K<1)
            return -1;
        kthNumber(root);
        return val;
    }

    public void kthNumber(TreeNode root){
        if(root == null)
            return;

        if(root.left != null){
            kthNumber(root.left);
        }
        num=num-1;
        if(num==0){
            val=root.data;
            return;
        }

        if(root.right != null){
            kthNumber(root.right);
        }


    }
}
