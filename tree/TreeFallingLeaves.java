package tree;
import java.util.*;

public class TreeFallingLeaves {
    public static void main(String[] args) {
        TreeNode tree=  new TreeNode();
        TreeNode root = tree.createBT();
        List<List<Integer>> list = new TreeFallingLeaves().findLeaves(root);
        for(List<Integer> ls:list){
            for(Integer i:ls)
                System.out.print(i+" ");
            System.out.println();
        }
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        findLeavesHelper(list, root);
        return list;
    }

    // return the level of root
    private int findLeavesHelper(List<List<Integer>> list, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftLevel = findLeavesHelper(list, root.left);
        int rightLevel = findLeavesHelper(list, root.right);
        int level = Math.max(leftLevel, rightLevel) + 1;
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.data);
     //   root.left = root.right = null;
        return level;
    }
}
