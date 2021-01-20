package string;

/**
 * Given a string, eliminate all “b” and “ac” in the string, replace them in-place and iterate over the string once.
 */
public class PatternABC {
    public static  String removeChars(String str){

        if(str==null || str.isEmpty())
            return str;

        int n = str.length();
        int p=0,q=0;
        char[] ch = str.toCharArray();
        while(p<n){
            if(p!= n-1 && (str.charAt(p)=='a' && str.charAt(p+1)=='c')){
            p +=2;
        }else if(str.charAt(p)=='b') {
            p++;
        } else {
                ch[q++]=str.charAt(p++);
            }

        }
        str = new String(ch);
        return str.substring(0,q);
    }

    public static void main(String[] args) {
        System.out.print(removeChars("aabbb"));
    }

}
