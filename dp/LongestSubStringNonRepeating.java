package tree;

/**
 * Find the longest subString without any repeating character
 */
public class LongestSubStringNonRepeating {


    public static void main(String[] args) {
        String s = "dasfgvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
    private static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        char[] ch=s.toCharArray();
        String[] dp = new String[s.length()];
        dp[0]=ch[0]+"";
        int maxLength = 1;
        for(int i=1;i<ch.length;i++){

            if(dp[i-1].contains(ch[i]+"")){
                String prev = dp[i-1].substring(dp[i-1].indexOf(ch[i]+"")+1);
                dp[i] =prev.concat(ch[i]+"");
            } else {
                dp[i]=dp[i-1].concat(ch[i]+"");
                maxLength = Math.max(maxLength, dp[i].length());
            }
        }
        return maxLength;

    }
}
