package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        System.out.print(uniqueStringLength("aabacdeaebe",3));
    }

    private static int uniqueStringLength(String s, int k){
        if(k<1)
            return 0;
        int start =0; int end = s.length();


        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(start),start);
        int max=0; int curr = 0;
        while(curr<end ){
            if(map.size()<k){
                map.put(s.charAt(curr),curr++);
            }else{
                if(map.containsKey(s.charAt(curr))) {
                    map.put(s.charAt(curr),curr++);
                    continue;
                }

                max = Math.max(curr-start,max);
                char ch = s.charAt(start);
                start = map.get(ch)+1;
                map.remove(ch);
            }
        }
        if(map.size()<k)
            return -1;
        return Math.max(curr-start,max);
    }
}
