package string;

public class StringMatchingKMP {

    private int[] buildPatternArray(String pattern){
        int n = pattern.length();
        int[] pArr = new int[n];
        pArr[0]=0;
        int j=0;
        for(int i=1;i<n;){
            if(pattern.charAt(i)==pattern.charAt(j))
            {
                pArr[i]=j+1;
                j++;i++;
            }else{
                if(j!=0)
                    j = pArr[j - 1];
                else {
                    pArr[i] = 0;
                    i++;
                }
            }
        }
        return  pArr;
    }

    private int SearchString(String pattern, String text){
        if(text == null || text.isEmpty() || pattern == null || pattern.isEmpty())
            return 0;

        int[] pArr = buildPatternArray(pattern);
        int n = text.length();
        int m = pattern.length();
        int j=0, i=0, index =0;

        while(i<n && j<m) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;i++;
            }else {
                if(j!=0)
                    j = pArr[j - 1];
                else
                    i++;
                index = i - j;
            }
            if (j == pattern.length()) {
                return index;
            }
        }
        return index==n-1?-1:index;
    }

    public static void main(String[] args) {
        StringMatchingKMP kmp = new StringMatchingKMP();
      int index =     kmp.SearchString("abcaby","abxabcabyabx");
      System.out.print(index);
    }
}
