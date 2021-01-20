package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeBst2 {

    private static void mergeBst(TreeNode r1, TreeNode r2){

        if(r1==null && r2 == null)
            return ;
        if(r1 == null) {
            inOrder(r2);
            return;
        }
        if(r2 == null) {
            inOrder(r1);
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode n1 = r1; TreeNode n2 = r2;
        while(!s1.isEmpty() || !s2.isEmpty() || n1!= null || n2 != null){

            while(n1 != null) {
                s1.push(n1);
                n1 = n1.left;
            }
            while(n2 != null) {
                s2.push(n2);
                n2 = n2.left;
            }
            if(!s1.isEmpty()) n1 =s1.pop();
            if(!s2.isEmpty()) n2 = s2.pop();
            if(n1.data <= n2.data)
            {
                System.out.print(n1.data+" ");
                TreeNode temp = n1;
                n1 = s1.pop();
                s1.push(temp.right);
                n2 = null;
            }else{
                System.out.print(n2.data+" ");
                n2 = s2.pop();
                n1 = null;
            }
        }

    }

    private static void inOrder(TreeNode r1){
        if(r1==null)
            return;
        inOrder(r1.left);
       System.out.print(r1.data+" ");
        inOrder(r1.right);
    }


}
