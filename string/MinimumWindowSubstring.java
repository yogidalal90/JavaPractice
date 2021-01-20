package string;

import  java.util.*;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.print(new MinimumWindowSubstring().minWindow("ADOBECODEBANC","ABC"));
    }
    public String minWindow(String src, String target) {

        if(src.isEmpty() || target.isEmpty()){
            return "";
        }
        int sn = src.length();
        int tn = target.length();
        if(tn>sn){
            return "";
        }

        Map<Character,Integer> map = new HashMap<>();

        for(char c:target.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int minLth = Integer.MAX_VALUE;
        int start=-1, end=0; int count=target.length(); String output="";
        for(int i=0;i<src.length();i++){
            char c = src.charAt(i);
            if(map.containsKey(c)){
                int curr = map.get(c);
                if(curr>0)
                    count--;
                map.put(c,curr-1);
                if(start==-1)
                    start=i;
            }
            end++;
            while(count==0){
                if(end>start){
                    if(end-start-1<minLth){
                        minLth =Math.min(minLth,end-start-1);
                        output = src.substring(start,end);
                    }
                }
                char ch = src.charAt(start);
                if(map.containsKey(ch)){
                    int curr = map.get(ch);
                    if(curr>=0)
                        count++;
                    map.put(ch,curr+1);
                }
                start++;

            }
        }
        return output;

    }
}
