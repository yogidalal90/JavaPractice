package string;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation
 * of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 */
public class PalindromePairs {

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>>  pairs = palindromePairs(words);
        for(List<Integer> pair:pairs){
            System.out.println(pair.get(0)+" "+pair.get(1));
        }
    }
    private static List<List<Integer>> ls= new ArrayList<>();
    private static List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        if(n<1)
            return ls;

        for(int i=0;i<n;i++){
            String s1 = words[i];
            for(int j=i+1;j<n;j++){
                String s2 = words[j];
                isPalindrome(s1,s2,i,j);
            }
        }

        return ls;
    }

    private static void isPalindrome(String s1, String s2, int i, int j){
        String fs1 = s1+s2;
        StringBuilder first = new StringBuilder(fs1);

        if(fs1.contentEquals(first.reverse()))
        {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(j);
            ls.add(list);
        }


        String fs2 = s2+s1;
        StringBuilder sec = new StringBuilder(fs2);
        if(fs2.contentEquals(sec.reverse())){
            List<Integer> list = new ArrayList<>();
            list.add(j);
            list.add(i);
            ls.add(list);
        }
    }
    }