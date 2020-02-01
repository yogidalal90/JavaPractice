package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5
 */
public class WaveArray {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(4);
        al.add(2);
        al.add(5);
        al.add(1);
        al.add(6);
        System.out.println(wave(al));
    }
        public static ArrayList<Integer> wave(ArrayList<Integer> A) {
            ArrayList<Integer> al = new ArrayList<Integer>();
            if(A == null || A.isEmpty())
                return al;
          int high = A.size();

            Collections.sort(A);

            al =A;
            for(int i=0;i<high-1;i++){
               int temp = al.get(i+1);
                al.set(i+1,al.get(i));
                al.set(i,temp);
                i++;
            }
            return al;
        }

}
