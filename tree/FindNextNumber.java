package tree;

import sun.reflect.generics.tree.Tree;

public class FindNextNumber {


    public static void main(String[] args) {
        TreeNode tree= new TreeNode();
        TreeNode root = tree.createBST();
        System.out.print(findNextNumber(root,8));
    }
    static int max = Integer.MAX_VALUE;
    static int findNextNumber(TreeNode root, int num){
        findNextNum(root,num);
        return max;

    }
    static void findNextNum(TreeNode root, int num){
        if(root == null)
            return ;


        if(root.data > num) {
            max = root.data;
            findNextNum(root.left, num);
        }
        else
            findNextNum(root.right,num);
    }

}
