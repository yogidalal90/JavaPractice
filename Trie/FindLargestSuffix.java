package Trie;
import java.util.*;
public class FindLargestSuffix {

// you can also use imports, for example:



        public static void main(String [] args) {
            // you can write to stdout for debugging purposes, e.g.
            System.out.println("This is a debug message");
            List<String> input = new ArrayList<>();
            input.add("abcdf");
            input.add("ghikl");
            input.add("cdf");
            input.add("abcd");
            input.add("ikl");
            input.add("rcdf");
            input.add("f");
            List<String> output = new FindLargestSuffix().findSuffixes(input);
            for(String str: output)
            {
                System.out.println(str);
            }

        }


        class Trie{
            Map<Character,Trie> map;

            public Trie(){
                map = new HashMap<>();
            }
        }

        public void addWord(Trie root, String word){
            char[] arr = word.toCharArray();

            for(int i=arr.length-1;i>=0;i--){
                char ch = arr[i];
                if(!root.map.containsKey(ch)){
                    root.map.put(ch,new Trie());
                }
                root = root.map.get(ch);
            }
        }

        public void getWords(Trie root, List<String> res, String sb){
            if(root.map.isEmpty()){
                res.add(new String(sb));

                return;
            }

            Map<Character,Trie> map = root.map;
            for(Character ch:map.keySet()){
                getWords(map.get(ch),res,sb+ch+"");
            }
        }
// cdf, abcdf, df
// fdcba, lkihg



        List<String> findSuffixes(List<String> input){
            Trie root = new Trie();

            for(String str:input){
                addWord(root,str);
            }

            List<String> output = new ArrayList<>();
            getWords(root,output,"");
            return output;
        }


}
