package tree;

import sun.reflect.generics.tree.Tree;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int x) {
        this.data = x;
        this.left = null;
        this.right = null;
    }

    /**
     *                      1
     *                  2        3
     *              4      5  6      7
     * @return rootNode
     */
    public TreeNode createBT(){
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(7);
return t;

    }

    /**
     *
     *                       10
     *                  7           13
     *           6          8   19       17
     *
     *
     * @return
     */
    public TreeNode createBST(){
        TreeNode t = new TreeNode(10);
        t.left = new TreeNode(7);
        t.right = new TreeNode(13);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(8);
        t.right.left = new TreeNode(12);
        t.right.right = new TreeNode(17);
        return t;

    }
}
