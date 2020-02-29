package array;

import java.util.ArrayList;

/**
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
 * Input Format:
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output Format:
 * Return a 2-d matrix that satisfies the given conditions.
 */
public class PaintZerosList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        al.add(0);

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(1);
        al2.add(0);
        a.add(al);
        a.add(al2);
        System.out.println("Original List:");

        for(ArrayList<Integer> ls : a){
            for(Integer i:ls){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        setZeroes(a);
        System.out.println("\nZeroed List:");
        for(ArrayList<Integer> ls : a){
            for(Integer i:ls){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

    private static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m=a.size();
        int n=a.get(0).size();
        boolean row[] = new boolean[a.size()];
        boolean col[] = new boolean[a.get(0).size()];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a.get(i).get(j)==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]||col[j]) a.get(i).set(j,0);
            }
        }
    }
}
