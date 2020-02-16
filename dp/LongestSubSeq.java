package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S of length N and an integer K, the task is to find the length of longest sub-sequence
 * such that the difference between the ASCII values of adjacent characters in the subsequence is not more than K.
 *
 */
public class LongestSubSeq {

    public static void main(String[] args) {

        System.out.println(longestSubseqLength(2,"acebdde"));
    }

    private static int longestSubseqLength(int k, String s) {
        if(s == null||s.isEmpty())
            return -1;

        char[] ar = s.toCharArray();
        List skipList = new ArrayList();
        int maxCount =-1;

        for(int i=0;i<ar.length-1;i++){
            if(skipList.contains(i))
                continue;
            int count =1;
            char ele = ar[i];
            for(int j=i+1;j<ar.length;j++){
                if(elementInRange(ele,ar[j])){
                    count++;
                    ele = ar[j];
                    skipList.add(j);
                }
            }
            if(count > maxCount)
                maxCount = count;
        }
        return maxCount;

    }

    public static boolean elementInRange(char a,char b){
        if(((a-b) <=2 )&& ((a-b) >= -2 )){
            return true;
        }
        return  false;
    }
}
