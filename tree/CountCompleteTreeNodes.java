package tree;

/**
 *222. Count Complete Tree Nodes
 * Given a complete binary tree, count the number of nodes.
 */
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.createBT();
        System.out.println(countNodes((root)));
    }
    private static int countNodes(TreeNode root) {
        if(root==null)
            return 0;

        int leftH=depth(root.left);
        int rightH=depth(root.right);


        if(leftH == rightH) // left subtree is full tree
            return countNodes(root.right)+ (1<<leftH);
        else{                   // right subtree is full tree
            return countNodes(root.left) + (1<<rightH);
        }
    }

    // always check left side of tree because in complete binary tree, left nodes are filled first
    private static int depth(TreeNode node){
        int depth=0;
        while(node != null){
            node = node.left; depth++;
        }
        return depth;

    }

}
