package tree;

import sun.reflect.generics.tree.Tree;

public class LCAinBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        TreeNode root = node.createBST();
        root = LCAinBST(root,12,17);
        System.out.print(root.data);
    }

   static TreeNode LCAinBST(TreeNode root, int snode, int lnode){

        if(root== null)
            return null;

        while(root.data < snode || root.data > lnode){

            if(root.data < snode)
                root =root.right;
            else if(root.data > lnode)
                root = root.left;
    }
	return root;

}

}
