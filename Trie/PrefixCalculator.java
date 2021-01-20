package Trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrefixCalculator{
    String findPrefix(Set<String> dic, String word){

        if(word == null|| word.isEmpty())
            return word;

        for(String str:dic){
            insert(str);
        }

        return findPrefix(word);

    }

    class Trie{
        Map<Character,Trie> map;


        public Trie(){
            map=new HashMap<>();

        }
    }

    Trie root = new Trie();

    void insert(String word){
        Trie node = root;
        for(char c:word.toCharArray()){
            Map<Character,Trie> curr = node.map;
            if(!curr.containsKey(c)){
                curr.put(c,new Trie());
            }
            node = curr.get(c);
        }

    }

    String findPrefix(String word){
        Trie node = root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            Map<Character,Trie> curr = node.map;
            if(!curr.containsKey(c)){
                return word.substring(0,i+1);
            }
            node = curr.get(c);
        }
        return null;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("dog"); set.add("be"); set.add("cut");
        String word = "cat";
        System.out.print(new PrefixCalculator().findPrefix(set,word));
    }

}
