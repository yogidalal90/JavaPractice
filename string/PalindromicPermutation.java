package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.)
 */
public class PalindromicPermutation {
    public static void main(String[] args) {
        System.out.print(new PalindromicPermutation().isPalindromicPermutation("Tact Coa"));
    }
    boolean isPalindromicPermutation(String str){
        str = str.toLowerCase();
        int[] count = new int[26];
        for(char c:str.toCharArray()){
            if(c==' ')
                continue;
            if(count[c-'a']==0)
                count[c-'a']++;
            else
                count[c-'a']--;
        }
        int finalCount=0;
        for(int i=0;i<26;i++){
            finalCount += count[i];
        }
        return finalCount==0 || finalCount==1;
    }

}
