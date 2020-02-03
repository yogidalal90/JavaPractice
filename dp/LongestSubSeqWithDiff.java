package dp;

/**
 *
 *  Find longest subsequence having difference of k
 *
 *  E.g. K =2
 *  String : afcbedg
 *  o/p: 4 (acbd)
 */

public class LongestSubSeqWithDiff {

    public static void main(String[] args) {
        System.out.println(subSeq("afcbedg",2));
    }

    public static int subSeq(String s, int k){
        if(s ==null || s.isEmpty())
            return -1;
        int[] arr = new int[s.length()];
        int[] alphabet = new int[26];

        for(int i=0;i<s.length();i++){
            int charIndex = s.charAt(i)-'a';
            int lowerBound = Math.max(0,charIndex-k);
            int upperBound = Math.min(25,charIndex+k);
            for(int j=lowerBound;j<=upperBound;j++){
                arr[i] = Math.max(arr[i],alphabet[j]+1);
            }
            alphabet[charIndex]=Math.max(arr[i],alphabet[i]);
        }
        int maxVal = -1;
        for(int i:arr){
            maxVal = Math.max(i,maxVal);
        }
        return maxVal;
    }
}
