package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBST {

    public static void main(String[] args) {
        TreeNode t =new TreeNode();
        TreeNode root = t.createBT();
        System.out.print(isBst(root));
        root = t.createBST();
        System.out.print(isBst(root));
    }
   static class TreeEntry{
        TreeNode node;
        int min;
        int max;
        public TreeEntry(TreeNode node, int min, int max){
            this.node = node;
            this.min = min;
            this.max =max;
        }
    }

    static boolean isBst(TreeNode root){
        if(root== null)
            return true;

        Queue<TreeEntry> que = new LinkedList<>();
        que.add(new TreeEntry(root,Integer.MIN_VALUE,Integer.MAX_VALUE));

        while(!que.isEmpty()){
            int n = que.size();
            for(int i=0;i<n;i++){
                TreeEntry entry = que.poll();
                TreeNode node = entry.node;
                int min = entry.min;
                int max =entry.max;
                if(node.left != null){
                    int leftMax = node.data;
                    if(node.left.data < min || node.left.data > leftMax){
                        return false;
                    }
                    que.offer(new TreeEntry(node.left,min,leftMax));
                }
                if(node.right !=null){
                    int rtMin = node.data;
                    if(node.right.data < rtMin || node.right.data > max)
                        return false;
                    que.offer(new TreeEntry(node.right,rtMin,max));
                }

            }
        }
        return true;
    }

}
