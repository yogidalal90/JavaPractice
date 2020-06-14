package array;

import java.util.ArrayList;

public class PlusOne {
    public static void main(String[] args) {
        
	   int[] digits = {2,9,9,9};
        int[] num = plusOne(digits);
		for(int digit:num)
			System.out.print(digit+" ");

    }
    private  static  int[] plusOne(int[] digits) {
        
        int n = digits.length;
        if(n<1)
            return digits;
        
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i] = digits[i]+1;
                return digits;
            }
            digits[i]=0;
        }
        
        int[] num = new int[n+1];
        num[0]=1;
        return num;
    }
}
