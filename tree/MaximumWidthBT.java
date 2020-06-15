package tree;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *  output:  4 (5,3,null,9).
 */
public class MaximumWidthBT {
    private int max;
    private Map<Integer,Integer> map;

    private int widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        max =0;
        treeWidth(root,0,0);
        return max;
    }
    /**
     * for left child: 2*ci
     * for right child: 2*ci+1
     * for width = lastIndex-firstIndex+1 (for a particular level)
     */
    private void treeWidth(TreeNode root, int ci, int level){
        if(root == null)
            return;

        if(!map.containsKey(level))
            map.put(level,ci);

        int firstIndex = map.get(level);
        max = Math.max(max, ci-firstIndex+1);

        treeWidth(root.left,ci*2,level+1);
        treeWidth(root.right, ci*2+1, level+1);
    }

    public static void main(String[] args) {
        MaximumWidthBT maxWidth = new MaximumWidthBT();
        TreeNode treeNode = new TreeNode();
        TreeNode root = treeNode.createBT();
        System.out.println(maxWidth.widthOfBinaryTree(root));
    }
}
