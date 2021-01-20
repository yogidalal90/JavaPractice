package tree;

import java.util.List;

public class ConstructFromPreorder {

   static int index = 0;
    static TreeNode contructFromPreoder(List<Integer> pre){

        Integer data = pre.get(index);
        index +=1;
        if(data == null){
            return null;
        }
        TreeNode leftTree = contructFromPreoder(pre);
        TreeNode rtTree = contructFromPreoder(pre);
        TreeNode root =  new TreeNode(data);
        root.left = leftTree;
        root.right=rtTree;
        return root;
    }

}
