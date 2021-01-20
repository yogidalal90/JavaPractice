package tree;

import java.util.Stack;

public class LcaBFS {

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode r = t.createBT();
        TreeNode tes = lca(r,3,4);
        System.out.print(tes.data);
    }
    public static TreeNode lca(TreeNode tree, int n1, int n2) {
        if(tree==null)
                return null;

        Stack<TreeNode> pathToN1 = pathTo(tree, n1);
        Stack<TreeNode> pathToN2 = pathTo(tree, n2);
        if (pathToN1 == null || pathToN2 == null) return null;

        TreeNode prev = null;
        while (!pathToN1.isEmpty() && !pathToN2.isEmpty()) {
            TreeNode s = pathToN1.pop();
            TreeNode t = pathToN2.pop();
            if (s.equals(t)) prev = s;
            else break;
        }

        return prev;
    }

    public  static Stack<TreeNode> pathTo(TreeNode tree, int n) {
        if (tree == null) return null;
        if (tree.data==n) {
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(tree);
            return s;
        }

        Stack<TreeNode> left = pathTo(tree.left, n);
        if (left != null) {
            left.push(tree);
            return left;
        }
        Stack<TreeNode> right = pathTo(tree.right, n);



        if (right != null) {
            right.push(tree);
            return right;
        }

        return null;
    }
}
