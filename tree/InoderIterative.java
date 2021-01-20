package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InoderIterative {

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode r = t.createBT();
        List<Integer> ls = preOrder(r);
        for (int i:ls)
            System.out.print(i+" ");
    }
  static  List<Integer> inOrder(TreeNode root){
        List<Integer> ls = new ArrayList<>();
        if(root== null)
            return ls;

        Stack<TreeNode> st = new Stack();

        TreeNode node = root;
        while(!st.isEmpty() || node != null ){
            if(node != null){
                st.push(node);
                node = node.left;
            }else {
                node = st.pop();
                ls.add(node.data);
                node = node.right;
            }
        }
        return ls;

    }

    static List<Integer> preOrder(TreeNode root){
        List<Integer> ls = new ArrayList<>();
        if(root == null)
            return ls;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){

            TreeNode node = st.pop();
            ls.add(node.data);
            if(node.right!= null)
                st.push(node.right);
            if(node.left != null)
                st.push(node.left);

        }
        return ls;
    }


}
