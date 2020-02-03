package Map;

import java.util.*;

/**
 * Given an integer N. The task is to find the number in the range from 1 to N-1 which is having
 *  the maximum number of terms in its Collatz Sequence and the number of terms in the sequence.
 *
 * The collatz sequence of a number N is defined as:
 *
 * If N is Odd then change N to 3*N + 1.
 * If N is Even then change N to N / 2.
 * For example let us have a look at the sequence when N = 13:
 * 13 -> 40 -> 20 -> 10 -> 5 > 16 -> 8 -> 4 -> 2 -> 1
 */
public class CollatzSeq {
    public static void main(String[] args) {
        int n=10;
        if(n > 0)
            getMaxCollatzSeq(n);
    }

    private static void getMaxCollatzSeq(int n){
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=1;i<n;i++){
            map.put(i,-1);
        }

        for(int i=n-1;i>=1;i--){
            if(map.containsKey(i)){
                map = getCollatzSeqCount(map,i);
            }
        }
        Integer key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println( "Number "+key+" with "+map.get(key)+" elements in sequence");
    }

    private static HashMap getCollatzSeqCount(HashMap<Integer,Integer> map, int num){
        int count=0;
        int N = num;
        while(N> 1) {
            if(N%2 == 0)
                N=N/2;
            else
                N = (3*N)+1;

            // remove the number from map, as its sequence will be smaller than num.
            if(N<num)
                map.remove(N);
            count++;
        }

        map.put(num,count+1);
        return map;
    }
}