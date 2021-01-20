package string;

import java.util.*;
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        if(s.trim().isEmpty())
            return 1;

        Set<Character> set = new HashSet<>();

        int start=0, end=0, n=s.length();
        int count=0;
        while(end<n){
            char c = s.charAt(end);
            if(set.contains(c)){
                count = Math.max(count,end-start);
                while(s.charAt(start) != c){
                    set.remove(s.charAt(start++));
                }
                start++;
            }

            set.add(c);
            end++;
        }
        count = Math.max(count,end-start);
        return count;

    }

}
