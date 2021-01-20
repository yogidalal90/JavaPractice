package tree;

import java.util.*;
public class SerializeTreeIterative {
    public static void main(String[] args) {
        TreeNode tree=  new TreeNode();
        TreeNode root = tree.createBT();
        String encoding = new SerializeTreeIterative().serializeTree(root);
        System.out.print(encoding);
        TreeNode output = new SerializeTreeIterative().deserialize(encoding);
        System.out.print(output.data);
    }

    String serializeTree(TreeNode root){
        if(root== null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int n = que.size();
            for(int i=0;i<n;i++){
                TreeNode node = que.poll();
                if(node==null)
                    sb.append("#,");
                else{
                    sb.append(node.data+",");
                    que.offer(node.left);
                    que.offer(node.right);
                }
            }

        }
        return sb.toString();
    }

    TreeNode deserialize(String encoded){
        if(encoded.equals(""))
            return null;

        String[] str= encoded.split(",");

        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        que.offer(root);
        int i=1;
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node.equals("#"))
                continue;
            if(!str[i].equals("#"))
            {
                node.left=new TreeNode(Integer.parseInt(str[i]));
                que.offer(node.left);
            }
            i +=1;
            if(!str[i].equals("#"))
            {
                node.right=new TreeNode(Integer.parseInt(str[i]));
                que.offer(node.right);
            }
            i++;
        }
        return root;
    }

}
