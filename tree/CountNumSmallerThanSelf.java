package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 */
public class CountNumSmallerThanSelf {
    private List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        if(n <1)
        {
            return list;
        }
        TreeNode root = new TreeNode(nums[n-1]);
        list.add(0,0);
        for(int i=n-2;i>=0;i--){
            list.add(0,insertNode(root,nums[i]));
        }

        return list;

    }

    private int insertNode(TreeNode root, int val){
        int count=0;
        TreeNode node = new TreeNode(val);
        boolean isConnected=false;

        while(!isConnected){
            if(node.data <= root.data){
                root.count++;
                if(root.left == null){
                    root.left = node;
                    isConnected=true;
                }else{
                    root = root.left;
                }
            }else{
                count +=root.count;
                if(root.right == null){
                    root.right = node;
                    isConnected=true;
                }else{
                    root = root.right;
                }
            }
        }
        return count;
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        int count;
        public TreeNode(int data){
            this.data = data;
            this.count =1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        CountNumSmallerThanSelf countNum = new CountNumSmallerThanSelf();
        List<Integer> list = countNum.countSmaller(nums);
        for(int i:list)
            System.out.print(i+" ");
    }
}
