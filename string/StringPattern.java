package string;

/**
 * Given a pattern containing only I’s and D’s. I for increasing and D for decreasing.
 * Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can’t repeat.
 * E.g. Input: II       Output: 123
 *      Input: DIDI     Output: 21435
 *      Input: IIDDD    Output: 126543
 */
public class StringPattern {

    public static void main(String[] args) {
        System.out.print(PrintMinNumberForPattern("DIDI"));
    }
    static String PrintMinNumberForPattern(String arr)  {

        if(arr == null || arr.isEmpty() || arr.length() >8)
            return "";

        int lastNum = 0;
        int count =0;
        int p=0,q=0;
        int n=arr.length();
        String str = "";

        while(q<n){
            if(arr.charAt(q)=='D') {
                count++;
                q++;
            }else{
                lastNum = lastNum+count+1;
                int currNum = lastNum;
                while(p<=q){
                    str +=currNum+"";
                    currNum--; p++;
                }
                count=0;
            q++;
            }
        }
        if(p<=q){
            lastNum = lastNum+count+1;
            int currNum = lastNum;
            while(p<=q){
                str +=currNum+"";
                currNum--; p++;
            }
        }


        return str;

    }

}
