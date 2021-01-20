package tree;

import java.util.LinkedList;

public class LinkedListFromLeaves {
    LinkedList<Integer> listFromLeaves(TreeNode root){

        LinkedList<Integer> ls = new LinkedList<>();
        listFromLeaves(root,ls);
        return ls;
    }

    void listFromLeaves(TreeNode root,LinkedList<Integer> ls ){
        if(root== null)
            return ;
        if(root.left == null && root.right == null){
            ls.add(root.data);
            return;
        }
        if(root.left != null)
            listFromLeaves(root.left,ls);
        if(root.right != null)
            listFromLeaves(root.right,ls);

    }

}
