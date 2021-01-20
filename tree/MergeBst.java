package tree;

import java.util.ArrayList;
import java.util.List;

public class MergeBst {
    static List<Integer> list;
    private static List<Integer> mergeBst(TreeNode r1, TreeNode r2){
        list = new ArrayList<>();
        if(r1==null && r2 == null)
            return list;

        preOrder(r1);
        List<Integer> list1 = list;
        list = new ArrayList<>();
        preOrder(r2);
        List<Integer> list2 = 	list;
        return mergeList(list1,list2);

    }

    private static void preOrder(TreeNode r1){
        if(r1==null)
            return;
        preOrder(r1.left);
        list.add(r1.data);
        preOrder(r1.right);
    }

    private static List<Integer> mergeList(List<Integer> list1, List<Integer> list2){
        List<Integer> mergeList = new ArrayList<>();
        int p=0, q=0;
        int n=list1.size(); int m = list2.size();

        while(p<n && q<m){
            if(list1.get(p)<=list2.get(q))
                mergeList.add(list1.get(p++));
            else
                mergeList.add(list2.get(q++));

        }
        if(p==n){
            while(q<m)
                mergeList.add(list2.get(q++));
        }
        if(q==m){
            while(p<n)
                mergeList.add(list1.get(p++));
        }

        return mergeList;
    }

}
