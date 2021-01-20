package tree;

import java.util.Stack;

public class PreOdrder {

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode r = t.createBT();
        traverse(r);
    }
    // Traverse tree iteratively. We do this by replicating the same process
// done recursively using an explicit stack
    public static void traverse(TreeNode n) {
        Stack<TreeNode> s = new Stack();
        // Add the leftmost branch to the stack
        addLeftToStack(s, n);

        // While there are elements in the stack, pop and move the minimum
        // possible distance to the right
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            System.out.println(curr.data);

            // Add the right child and any of its left children to the stack
            addLeftToStack(s, curr.right);
        }
    }

    // As long as the current TreeNode has a left pointer, add it to the stack and 
// continue
    private static void addLeftToStack(Stack s, TreeNode n) {
        while (n != null) {
            s.push(n);
            n = n.left;
        }
    }
}
