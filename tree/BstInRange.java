package tree;

public class BstInRange {

    public static int getCountOfNode(TreeNode root,int l, int h)
    {
        if(root== null)
            return 0;

        if(root.data <l)
            return getCountOfNode(root.right,l,h);
        else if(root.data > h)
            return getCountOfNode(root.left,l,h);
        else
            return getCountOfNode(root.left,l,h) + getCountOfNode(root.right,l,h)+1;
    }


}
