package tree;

import java.util.*;
public class SerializeTree {
    public static void main(String[] args) {
        TreeNode tree=  new TreeNode();
        TreeNode root = tree.createBT();
        String encoding = new SerializeTree().serialize(root);
        System.out.print(encoding);
        TreeNode output = new SerializeTree().deserialize(encoding);
        System.out.print(output.data);
    }
    String serialize(TreeNode root){
        if(root== null)
            return "";

        StringBuilder sb = new StringBuilder();
        serializeTree(root,sb);
        return sb.toString();

    }

    void serializeTree(TreeNode root, StringBuilder sb){
        if(root== null)
        {
            sb.append("#,");
            return;
        }

        sb.append(root.data+",");
        serializeTree(root.left,sb);
        serializeTree(root.right,sb);
    }

    TreeNode deserialize(String encodedString){
        if( encodedString==null || encodedString.isEmpty())
            return null;

        String[] str = encodedString.split(",");
        Queue<String> que = new LinkedList<>(Arrays.asList(str));
        return buildTree(que);

    }

    TreeNode buildTree(Queue<String> que){

        String val= que.poll();
        if(val.equals("#"))
        return null;

        TreeNode root= new TreeNode(Integer.parseInt(val));
        root.left = (buildTree(que));
        root.right = (buildTree(que));
        return root;

    }

}
