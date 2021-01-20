package string;

import java.util.*;

public class FindReplaceString {

    public static void main(String[] args) {
        String str = "abcd";
        int[] indexes= {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets ={"eee", "ffff"};
        String output = findReplaceString(str,indexes,sources,targets);
        System.out.print(output);
    }
    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if(S== null || S.isEmpty())
            return S;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<indexes.length; i++) {
            if(S.startsWith(sources[i],indexes[i]))
                map.put(indexes[i],i);
        }
        int n = S.length();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<n){
            if(map.containsKey(i)){
                sb.append(targets[map.get(i)]);
                i+=sources[map.get(i)].length();
            }else{
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
