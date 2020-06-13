package array;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * @author Yogita
 */
public class MultiplyString {
    public static void main(String[] args) {
        System.out.println(multiply("96","145"));
    }
    private static String multiply(String num1, String num2) {
        if(num1.isEmpty() || num2.isEmpty())
            return "0";

        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();

        int[] list=  multiply(ch1,ch2);

        StringBuilder sb = new StringBuilder();
        for(int i:list){
            if(i == 0 && sb.length()==0) continue;
            sb.append(i);
        }
        return sb.length()==0?"0":sb.toString();
    }

    /**
     * "num1[i] * num2[j]" will be placed at indices [i + j, i + j + 1]
     */
    private static int[]  multiply(char[] ch1, char[] ch2){
        int n1 = ch1.length, n2 = ch2.length;
        int[] list = new int[n1+n2];

        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int a = ch1[i]-'0';
                int b = ch2[j]-'0';
                int mi = i+j;
                int ci = i+j+1;
                int mul = (a*b)+list[ci];

                list[mi]+=mul/10;
                list[ci]= mul%10;
            }
        }
        return list;
    }
}
