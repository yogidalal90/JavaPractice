package list;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
 *
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Given numRows = 5,
 *
 * Return
 *
 * [
 *      [1],
 *      [1,1],
 *      [1,2,1],
 *      [1,3,3,1],
 *      [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

        public ArrayList<ArrayList<Integer>> createPascalTriangle(int A) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
            if(A == 0)
                return al;

            for(int i=0;i<A;i++){

                list = new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    if(j==0 || i==j){
                        list.add(1);
                    } else {

                        list.add(getIndexEle(al,i-1,j-1)+getIndexEle(al,i-1,j));
                    }
                }
                al.add(list);

            }
            return al;

        }

        private Integer getIndexEle(ArrayList<ArrayList<Integer>> al, int i,int j){
            ArrayList<Integer> list = al.get(i);
            return list.get(j);
        }

}
