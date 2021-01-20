package stack;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.print(longestValidParenthesis("(())"));
    }
    static int longestValidParenthesis(String paren){

        Stack<Integer> st = new Stack<>();
        int count=0;
        int start=0; st.push(-1);
        for(int i=0;i<paren.length();i++){
            char ch=paren.charAt(i);
            if( ch== '('){
                st.push(i);
            }else {
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else
                    count = Math.max(count,i-st.peek());

            }

        }
        return count;

    }
}
