package string;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward
 */
public class BasicCalculator {
    private int calculate(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int n= s.length();
        int left = 0; //to hold prev val
        int num = 0; //to hold current number
        int opt = 0; // to hold *,/ operation: 1=*, -1 = /
        int sign = 1; // to hold +,- operation
        int res = 0; //to hold result
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c==' ')continue;

            if(Character.isDigit(c)){
                num = num*10+ (c-'0');
            }else{
                if(opt == 1)  num = left*num;
                else if(opt == -1) num = left/num;
                opt=0;

                if(c == '/'|| c=='*'){
                    left =num;
                    opt = c=='*'?1:-1;
                } else if(c=='+' || c== '-'){
                    res += sign * num; // if + sign => res+num. if -ve sign -> res-num
                    sign = c=='+'?1:-1;
                }
                num =0;
            }
        }


        // for addressing last number
        if(opt == 1)  res += sign * left*num;
        else if(opt == -1) res += sign * left/num;
        else res += sign * num;
        return res;
    }



    public static void main(String[] args) {
            String s = "3+2*2";

            int ret = new BasicCalculator().calculate(s);
            String out = String.valueOf(ret);
            System.out.print(out);
        }
}
