package tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ComputeSibliing {

    static void computeSibling(TreeNode root){
        if(root == null)
            return;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int n =	que.size();
            TreeNode prev= null;
            for(int i=0;i<n;i++){
                TreeNode curr= que.poll();
                if(curr.left!= null)
                     que.offer(curr.left);
                if(curr.right!= null)
                    que.offer(curr.right);
                if(prev != null)
                    prev.next= curr;
                prev= curr;
            }

        }
    }

    static void computeSiblingForPerfectTree(TreeNode root){
        if(root== null)
            return;

        if(root != null && root.left != null){
            computeNextLevelSibling(root);
            root = root.left;
        }

    }

    static void computeNextLevelSibling(TreeNode root){

        while(root != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
            root = root.next;
        }
    }

    public static void main(String[] args) {
        TreeNode tree= new TreeNode();
        TreeNode root = tree.createBT();
        computeSibling(root);
        computeSiblingForPerfectTree(root);
        System.out.print("done");
    }
}
