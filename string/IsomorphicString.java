package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 */
public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.isEmpty())
            return true;
        int n = s.length();
        Map<Character, Integer> sMap  = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();

        for(Integer i=0;i<n;i++){
            if(sMap.put(s.charAt(i),i) != tMap.put(t.charAt(i),i) )
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicString isoString = new IsomorphicString();
        System.out.println(isoString.isIsomorphic("paper","title"));
    }
}
