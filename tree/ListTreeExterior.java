package tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ListTreeExterior {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        TreeNode root= tree.createBT();
        Queue<Integer> que = traverseTreeExterior(root);
        for(int i:que)
            System.out.print(i+" ");
    }
    static Queue<Integer> traverseTreeExterior(TreeNode root){
        Queue<Integer> que = new LinkedList<>();
        if(root==  null)
            return que;
        traverseLeft(root,que);
        traverseLeave(root,que);
        traverseRight(root.right,que);
        return que;

    }



    static void traverseLeft(TreeNode root, Queue<Integer> que){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;

        que.offer(root.data);
        if(root.left != null)
            traverseLeft(root.left,que);
        else
            traverseLeft(root.right,que);

    }

   static void traverseLeave(TreeNode root, Queue<Integer> que){
        if(root==null)
            return;
        if(root.left==null && root.right ==null)
            que.add(root.data);
        else{
            traverseLeave(root.left,que);
            traverseLeave(root.right,que);
        }
    }

   static  void traverseRight(TreeNode root, Queue<Integer> que){
        if(root == null)
            return;
        if(root.left== null && root.right==null)
            return;
        if(root.right != null)
            traverseRight(root.right,que);
        else
            traverseRight(root.left,que);
       que.add(root.data);

   }

}
