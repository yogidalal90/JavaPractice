package Trie;
import java.util.*;
public class WordSquare {
    class Trie{
        Map<Character,Trie> map;
        boolean isWord;

        public Trie(){
            map  =new HashMap<>();
            isWord = false;
        }

    }

    public void buildTrie(Trie root, String word){
        Trie node = root;
        for(char ch:word.toCharArray()){
            Map<Character,Trie> currMap = node.map;
            if(currMap.get(ch)==null){
                currMap.put(ch,new Trie());
            }
            node = currMap.get(ch);
        }
        node.isWord = true;

    }

    private void findChildren(Trie node,List<String> res,String sb){
        if(node.isWord == true){
            res.add(new String(sb));
            return;
        }
        Map<Character,Trie> map = node.map;
        for(char ch:map.keySet()){
            findChildren(map.get(ch),res,sb+ ch+"");
        }
    }

    String getPrefix(List<String> square, int idx){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append(square.get(i).charAt(idx));
        }

        return sb.toString();
    }

    Trie searchPrefix(Trie root, String prefix){
        Trie node = root;
        if(node==null)
            return null;
        for(char ch:prefix.toCharArray()){
            if(node.map.containsKey(ch))
                node = node.map.get(ch);
            else
                return null;

        }
        return node;
    }




    public List<List<String>> wordSquares(String[] words) {
        Trie root = new Trie();
        for(String word:words){
            buildTrie(root,word);
        }
        List<List<String>> output = new ArrayList<>();

        for(int i=0;i<words.length;i++){
            List<String> square = new ArrayList<>();
            square.add(words[i]);
            buildWordSquare(square,words[i].length(),output,root);
        }
        return output;

    }

    void buildWordSquare(List<String> square, int len, List<List<String>> output, Trie root){
        if(square.size()==len)
        {
            output.add(new ArrayList<>(square));
            return;
        }

        String prefix = getPrefix(square,square.size());
        Trie node = searchPrefix(root,prefix);
        if(node==null)
            return;

        List<String> children = new ArrayList<>();
        findChildren(node,children,prefix);

        for(String child:children){
            square.add(child);
            buildWordSquare(square,len,output,root);
            square.remove(square.size()-1);
        }
    }

    public static void main(String[] args) {
        String[] arr ={"abat","baba","atan","atal"};
        List<List<String>> squares = new WordSquare().wordSquares(arr);
        for(List<String> ls:squares){
            for(String str:ls){
                System.out.print(str+ " ");
            }
            System.out.println();
        }

    }
}
