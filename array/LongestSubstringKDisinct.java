package array;
import java.util.*;
public class LongestSubstringKDisinct {
//abcadcacacaca
    public static void main(String[] args) {
        System.out.print(new LongestSubstringKDisinct().lengthOfLongestSubstringKDistinct("abacaca",2));
    }
    public int lengthOfLongestSubstringKDistincts(String s, int k) {
        if(s.length()<k)
            return s.length();
        int n=s.length();
        Map<Character,Integer> map = new HashMap<>();
        int start=0;
        int max =Integer.MIN_VALUE;
//abacaca
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),i);
            if(map.size()>k){
                max = Math.max(max,i-start);
                char toRemove=s.charAt(start);
                 start = map.get(toRemove)+1;
                map.remove(toRemove);
            }
        }
        return Math.max(max,n-start);

    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int len = 0;int start=0; int maxLen = 0;
        int i=0;
        for(i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
                if(map.size()>k){
                    maxLen = Math.max(maxLen,i-start);

                    while(map.size()>k){
                        char ch = s.charAt(start);
                        int count = map.get(ch);
                        if(count==1)
                            map.remove(ch);
                        else
                            map.put(ch,count-1);
                        start++;
                    }
                }
//abacaca

        }
        return Math.max(maxLen,n-start);
    }

}
