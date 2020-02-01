package array;

import java.util.ArrayList;

/**
 * Traverse a 2D list diagonally
 * e.g. 1 2
 *      3 4
 *
 * Output: [1], [2,3], [4]
 *
 */
public class DiagonalArray {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al =generateMutliDArray(2);

       System.out.println(diagonal(al));
    }
    private static ArrayList<ArrayList<Integer>> generateMutliDArray(int x){
        ArrayList<ArrayList<Integer>> al = new  ArrayList<>();
        ArrayList<Integer> list;
        int ele=1;
        for(int i=0;i<x;i++){
            list = new ArrayList<>();
            for(int j=0;j<x;j++){
                list.add(ele);
                ele++;
            }
            al.add(list);
        }
        return al;
    }
    private static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
            ArrayList<ArrayList<Integer>> al = new ArrayList<>();
            ArrayList<Integer> oldList;
            if(A == null || A.isEmpty())
                return al;

            for(int i=0;i<A.size();i++){
                oldList = A.get(i);
                for(int j=0;j<oldList.size();j++){
                    int ele = fetchElement(A,i,j);
                    al = addElement(al,i,j,ele);
                }
            }
            return al;
        }

    private static ArrayList<ArrayList<Integer>> addElement(ArrayList<ArrayList<Integer>> al, int i,int j, int ele){
            ArrayList<Integer> list;
            if( al.size()<=(i+j)){
                list = new ArrayList<>();
                list.add(ele);
                al.add(list);
            } else {
                list = al.get(i + j);
                list.add(ele);
                al.set((i+j),list);

            }
            return al;
        }

    private static  int fetchElement(ArrayList<ArrayList<Integer>> A,int i,int j){
            ArrayList<Integer> oldList = A.get(i);
            return oldList.get(j);
        }

}
