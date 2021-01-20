package Trie;

import java.util.*;
public class WordSearchII {
    public static void main(String[] args) {
        char[][] arr = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] word = {"oath","pea","eat","rain"};
        List<String> str= new WordSearchII().findWords(arr,word);
        for(String s:str)
            System.out.print(s+" ");
    }
    class Trie{
        String word;
        Map<Character,Trie>  map;

        public Trie(){
            word=null;
            map = new HashMap<>();
        }

    }

    public void buildTrie(Trie root, String word){
        Trie node= root;
        for(char ch:word.toCharArray()){
            if(!node.map.containsKey(ch))
                node.map.put(ch,new Trie());
            node = node.map.get(ch);
        }
        node.word =word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ls = new ArrayList<>();
        if(words.length<1 || board.length < 1)
            return ls;

        int n = board.length;
        int m = board[0].length;
        Trie root = new Trie();
        for(String word:words)
            buildTrie(root,word);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board, i, j, root,ls);
            }
        }
        return ls;
    }

    void dfs(char[][] board, int i, int j, Trie root, List<String> ls){
        char ch = board[i][j];

        if(ch=='-' || root.map.get(ch)==null)
            return;
        root = root.map.get(ch);
        if(root.word!= null){
            ls.add(root.word);
            root.word=null;
        }

        board[i][j]='-';

        if(i>0)
            dfs(board,i-1,j,root,ls);
        if(j>0)
            dfs(board,i,j-1,root,ls);

        if(i<board.length-1)
            dfs(board,i+1,j,root,ls);

        if(j<board[0].length-1)
            dfs(board,i,j+1,root,ls);

        board[i][j]=ch;

    }

}
