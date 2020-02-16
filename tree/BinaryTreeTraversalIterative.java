package tree;


import queue.Queue;
import queue.QueueUsingLLForTree;

/**
 * Tree traversals iteratively
 *              Tree Structure
 *                      1
 *                  2        3
 *              4      5  6      7
 */
public class BinaryTreeTraversalIterative {
    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode r = t.createBT();
        levelOrderTraversal(r);
    }

    /**
     * Level Order Traversal Using Queue
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root){
        if(root == null) {
            return;
        }
        QueueUsingLLForTree queue = new QueueUsingLLForTree();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            root = queue.dequeue();

            if(root.left != null)
                queue.enqueue(root.left);
            if(root.right != null)
                queue.enqueue(root.right);
        }


    }


}
