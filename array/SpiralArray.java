package array;

import java.util.ArrayList;

/**
 * Create list with elements in spiral order of 2D arrayList.
 */
public class SpiralArray {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>  al = generateMutliDArray(3);
        System.out.println(printSpiral(al));
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


    private static ArrayList<Integer> printSpiral(ArrayList<ArrayList<Integer>> A) {

        ArrayList<Integer> al = new ArrayList<>();
        if (A == null || A.isEmpty()) {
            return al;
        }
        int n = A.size();
        int sc = 0, ec = n - 1, sr = 0, er = n - 1;

        while (sc <= ec || sr <= er) {
            for (int i = sc; i <= ec; i++) {
                al.add(A.get(sr).get(i));
            }

            for (int i = sr + 1; i <= er; i++)
                al.add(A.get(i).get(ec));

            for (int i = ec - 1; i >= sc; i--)
                al.add(A.get(er).get(i));

            for (int i = er - 1; i > sr; i--)
                al.add(A.get(i).get(sc));

            sc += 1;
            ec -= 1;
            sr += 1;
            er -= 1;
        }
        return al;

    }

}
