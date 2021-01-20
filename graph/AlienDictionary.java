package graph;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {  "caa", "aaa", "aab"};
        AlienDictionary ad = new AlienDictionary();
        System.out.print(ad.alienOrder(words));
    }
    public String alienOrder(String[] words){
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(map,inDegree,words);
        return topologicalBfsSort(map,inDegree);

    }

    private String topologicalBfsSort(Map<Character,Set<Character>> map, int[] inDegree){
        StringBuilder sb = new StringBuilder();
        int totalChars = map.size();
        Queue<Character> que = new LinkedList<>();

        for(char c:map.keySet()){
            if(inDegree[c-'a']==0){
                que.offer(c);
                sb.append(c);
            }
        }

        while(!que.isEmpty()){
            char ch = que.poll();
            if(map.get(ch)==null || map.get(ch).size() ==0) continue;
            for(char nbr:map.get(ch)){
                inDegree[nbr-'a']--;
                if(inDegree[nbr-'a']==0){
                    que.offer(nbr);
                    sb.append(nbr);
                }
            }
        }

        return sb.length()==totalChars ? sb.toString():"";

    }

    private void buildGraph(Map<Character,Set<Character>> map, int[] inDegree, String[] words){

        for(String word: words){
            for(char c:word.toCharArray()){
                map.put(c,new HashSet<>());
            }
        }

        for(int i=1;i<words.length;i++){
            String first = words[i-1];
            String sec = words[i];
            int len = Math.min(first.length(),sec.length());
            for(int j=0;j<len;j++){
                if(first.charAt(j) != sec.charAt(j)){
                    char out = first.charAt(j);
                    char in = sec.charAt(j);
                    if(!map.get(out).contains(in)){
                        map.get(out).add(in);
                        inDegree[in-'a']++;
                    }
                    break;
                }
            }
        }
    }

}
