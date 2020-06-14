package Trie;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 */
public class WordDictionary {

    class Trie{
        Map<Character,Trie> map;
        String item;
        public Trie(){
            map = new HashMap<Character, Trie>();
            item = "";
        }
    }


    Trie root ;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
        root.item = "";
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        Trie node = root;
        for(char c:word.toCharArray()){
            Trie dict = node.map.getOrDefault(c,new Trie());
            node.map.put(c,dict);
            node = dict;
        }
        node.item = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trie node = root;
        return searchWrapper(word.toCharArray(),0,node);
    }

    public boolean searchWrapper(char[] word, int i,  Trie node){

        if(i==word.length){
            return !node.item.equals(null);
        }
        char c = word[i];
        if(c != '.'){
            Trie dict = node.map.get(c);
            if (dict != null)
                return searchWrapper(word, i + 1, dict);
            else
                return false;
        }else{
            Set<Character> entries = node.map.keySet();
            for(char entry: entries) {
                Trie dict = node.map.get(entry);
                if(searchWrapper(word, i + 1, dict))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("had"));
        System.out.println(obj.search("bad") );
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
