package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 809. Expressive Words
 * For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation:
 * choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.
 *
 * Input:   S = "heeellooo"
 *          words = ["hello", "hi", "helo"]
 * Output: 1
 */
public class ExpressiveWords {
    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words={"hello", "hi", "helo"};
        System.out.println(new ExpressiveWords().expressiveWords(s,words));
    }
    private int expressiveWords(String S, String[] words) {
        if(S==null || S.isEmpty())
            return 0;

        WordCounter sCounter = new WordCounter(S);
        int count=0;

        for(String word:words){
            WordCounter wCounter = new WordCounter(word);
            boolean valid=true;
            String sWord = sCounter.value;
            String currWord = wCounter.value;
            if(!sWord.equals(currWord))
                continue;
            List<Integer> scount = sCounter.counter;
            List<Integer> wcount = wCounter.counter;
            for(int i=0;i<scount.size();i++){
                if(scount.get(i)<wcount.get(i)){
                    valid =false;
                    break;
                }
                if(scount.get(i)<3 && wcount.get(i)!= scount.get(i)){
                    valid =false;
                    break;
                }
            }
            if(valid)
                count++;
        }
        return count;
    }

    static class WordCounter{
        String value;
        List<Integer> counter;

        private WordCounter(String S){
            StringBuilder sb = new StringBuilder();
            counter = new ArrayList<>();

            char[] ch = S.toCharArray();
            counter.add(1); int i=1; int j=0;

            sb.append(ch[j]);
            while(i<S.length()){
                if(ch[i]==ch[i-1]){
                    counter.set(j,counter.get(j)+1);
                }else{
                    j++;
                    counter.add(j,1);
                    sb.append(ch[i]);
                }
                i++;
            }
            value = sb.toString();
        }
    }
}