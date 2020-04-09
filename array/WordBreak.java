package array;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] wb = new boolean[s.length()+1];
        wb[0] = true;
        for(int i=1;i<=s.length();i++){

            for(int j=i-1;j>=0;j--){
                wb[i]=wb[j] && wordDict.contains(s.substring(j,i));
                if(wb[i])
                    break;
            }
            System.out.println(wb[i]);
        }

        return wb[s.length()];
    }
}
