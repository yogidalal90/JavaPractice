package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrokenKeyboard {

    public static void main(String[] args) {
        List<String> ls = brokenWord(new String[] {"can", "canes", "serene", "rene", "sam"}, "can s r n ");
        for(String l:ls)
            System.out.println(l);
    }
    static class Trie{
        Map<Character,Trie> map;
        boolean isWord;
        char ch;

        Trie(char ch){
            map = new HashMap<>();
            this.ch=ch;
        }


    }
    static Trie root = new Trie('#');

    static void buildTrie(String[] dict){
        Trie temp;
        for(String word:dict){
            temp = root;
            for(char c:word.toCharArray()){
                if(!temp.map.containsKey(c))
                    temp.map.put(c,new Trie(c));
                temp = temp.map.get(c);
            }
            temp.isWord=true;
        }

    }

    public static List<String> brokenWord(String[] dict, String input){
        buildTrie(dict);
        List<String> ls = new ArrayList<>();
        StringBuilder sb  = new StringBuilder();
        dfs(input,sb,ls,0,root);
        return ls;
    }

   static void dfs(String input, StringBuilder sb, List<String> ls, int idx, Trie temp){
        if(idx == input.length()-1){
            char ch  = input.charAt(idx);
            if(ch== ' ')
                ch='e';
            if(temp.map.containsKey(ch) && temp.map.get(ch).isWord){
                ls.add(new String(sb.toString()+ch));
            }
            return;
        }

        char ch = input.charAt(idx);
        if(ch==' '){
            if(temp.isWord){
                sb.append(' ');
                dfs(input,sb,ls,idx+1,root);
                sb.deleteCharAt(sb.length()-1);
            }
            ch= 'e';
            if(temp.map.containsKey(ch)) {
                sb.append(ch);
                dfs(input, sb, ls, idx + 1, temp.map.get(ch));
                sb.deleteCharAt(sb.length() - 1);
            }

        }else{
            if(temp.map.containsKey(ch)){
                sb.append(ch);
                dfs(input,sb,ls,idx+1,temp.map.get(ch));
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }

}
