package tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSuccessor {
    /**
     *                      1
     *                  2        3
     *              4      5  6      7
     * @return rootNode
     */
    public static TreeNode createBT(){
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.parent=t;
        t.right = new TreeNode(3);
        t.right.parent=t;
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
          t.right.right = new TreeNode(7);
        return t;

    }



    int findSuccessor(TreeNode root, int n){
        if(root == null)
            return -1;
        if(root.right != null){
            root = root.right;
            while(root.left!= null)
            {
                root=root.left;

            }
            return root.data;
        }
        while(root.parent != null && root.parent.right != root)
            root = root.parent;

        return root.parent.data;
    }


    public static TreeNode binaryTreeFromPreorderlnorder( List<Integer> preorder, List<Integer> inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.size();i++)
            map.put(inorder.get(i),i);

        return constructTreeNode(preorder,0,preorder.size(), 0, inorder.size(),map);
    }

    public static TreeNode constructTreeNode(List<Integer> preorder, int pStart, int pEnd, int inStart, int inEnd, Map<Integer, Integer> map){

        if(inStart >=inEnd || pStart >= pEnd)
            return null;

        int rootIndexInorder = map.get(preorder.get(pStart));
        int numOfNodes = rootIndexInorder-inStart;

        TreeNode node = new TreeNode(preorder.get(pStart));
        node.left = constructTreeNode(preorder,pStart+1,pStart+numOfNodes+1,inStart,rootIndexInorder,map);
        node.right = constructTreeNode(preorder,pStart+1+numOfNodes,pEnd,rootIndexInorder+1,inEnd,map);
        return node;
    }

}
