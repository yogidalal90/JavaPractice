package tree;

import java.util.*;

/**
 * Traverse the tree diagonally
 *                      1
 *                  2        3
 *              4      5  6      7
 */
public class DiagonalTraverse {
    static Map<Integer, List<Integer>> map = new TreeMap<>();

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        TreeNode root  = node.createBT();

        printDiagonalTraverse(root,0);
        Set<Integer> set = map.keySet();
        for(Integer ele:set){
            List<Integer> ls = map.get(ele);
            for(Integer e:ls){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    public static void printDiagonalTraverse(TreeNode root, int d){
            if(root == null){
                return;
            }
            List<Integer> list = map.getOrDefault(d,new ArrayList<>());
            list.add(root.data);
            map.put(d,list);
        printDiagonalTraverse(root.left,d+1);
        printDiagonalTraverse(root.right,d);
    }

}
