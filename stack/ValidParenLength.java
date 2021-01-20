package stack;

public class ValidParenLength {

    int validParenLength(String paren){

        int left=0, right=0;
        int n = paren.length();
        int max =0;
        for(int i=0;i<n;i++){
            if(paren.charAt(i)=='(')
            left++;
	else
            right++;
            if(left==right){
                max = Math.max(max,2*left);
            }
            if(right>left){
                left=0;right=0;
            }
        }

         left=0; right=0;
        for(int i=n-1;i>=0;i--){
            if(paren.charAt(i)=='('){
                left++;
            }else
            right++;
            if(left==right)
                max= Math.max(max,2*left);
            else if(left>right){
                left=0; right=0;
            }

        }

        return max;

    }

}
