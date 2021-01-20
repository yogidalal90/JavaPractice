package tree;

import com.sun.org.apache.xerces.internal.util.XMLInputSourceAdaptor;

import java.util.LinkedList;
import java.util.Queue;

public class FindKLargestElements {

    public static void main(String[] args) {
        TreeNode tree=  new TreeNode();
        TreeNode root = tree.createBST();
        Queue<Integer> q=findKElements(root,3);
        for(int i:q){
            System.out.print(i+" ");
        }
    }
   static Queue<Integer> findKElements(TreeNode root, int k){
        Queue<Integer> que = new LinkedList<>();
        findKLargestElements(root,k,que);
        return que;
    }

    static void findKLargestElements(TreeNode root, int k, Queue<Integer> que){
        if(root==null)
            return ;

       if(que.size()<k){
           if(root.right != null)
               findKLargestElements(root.right,k-1,que);
           if(que.size()<k) {
               que.offer(root.data);
               if (root.left != null)
                   findKLargestElements(root.left, k - 1, que);
           }
       }


    }

}
