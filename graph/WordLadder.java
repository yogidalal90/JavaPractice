package graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.print(ladderLength(beginWord,endWord,wordList));
    }
    static class StrWithDist
    {
        String word;
        int dist;
        public StrWithDist(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
    }

    public static int ladderLength(String beginWord, String endWord, String[] wordList) {
        Set<String> set= new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }

        Queue<StrWithDist> que = new LinkedList<>();
        que.offer(new StrWithDist(beginWord,1));
        set.remove(beginWord);
        while(!que.isEmpty()){

            StrWithDist curr = que.poll();
            if(curr.word.equals(endWord))
                return curr.dist;
            String currWord  = curr.word;
            int currDist = curr.dist;
            for(int i=0;i<currWord .length();i++)
            {
                String start = i==0?"":currWord.substring(0,i);
                String end=i+1>currWord.length()?"":currWord.substring(i+1);
                for(int j=0;j<26;j++){
                    if(set.remove(start+(char)('a'+j)+end)){
                        que.offer(new StrWithDist(start+(char)('a'+j)+end,currDist+1 ));

                    }
                }
            }
        }



        return -1;

    }

}
