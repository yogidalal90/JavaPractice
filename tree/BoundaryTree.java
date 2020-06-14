package tree;

import java.util.Comparator;

/**
 * Print boundary of the tree, anticlockwise direction
 *                      1
 *                  2        3
 *              4      5  6      7
 */
public class BoundaryTree {

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode root = t.createBT();

        BoundaryTree bt = new BoundaryTree();
        if(root == null)
            System.out.println("");
        if(root != null){
            System.out.print(root.data+" ");
        }
        bt.printLeftBoundary(root.left);
        bt.printLeavesBoundary(root.left);
        bt.printLeavesBoundary(root.right);
        bt.printRightBoundary(root.right);
    }


    void printLeftBoundary(TreeNode root){
        if(root != null){
            if(root.left != null){
                System.out.print(root.data+" ");
                printLeftBoundary(root.left);
            }else if(root.right != null){
                System.out.print(root.data+" ");
                printLeftBoundary(root.right);
            }
        }
    }

    void printRightBoundary(TreeNode root){

        if(root != null){
            if(root.right != null){
                System.out.println(root.data+" ");
                printRightBoundary(root.right);
            }else if(root.left != null){
                System.out.print(root.data+" ");
                printRightBoundary(root.left);
            }
        }
    }

    void printLeavesBoundary(TreeNode root){
        if(root!= null){
            printLeavesBoundary(root.left);

            if(root.left == null && root.right == null){
                System.out.print(root.data+" ");
            }
            printLeavesBoundary(root.right);

        }
    }
}
