package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array of real numbers greater than zero in form of strings.
 * Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
 * Return 1 for true or 0 for false.
 */
public class TripletsWithSumRange {
//0.234022 0.051717 0.820402 0.492629 0.004825 0.589073
    public static void main(String[] args) {
        ArrayList<String> in = new ArrayList();
        in.add("0.234022");
        in.add("0.051717");
        in.add("0.820402");
        in.add("0.492629");
        in.add("0.004825");
        in.add("0.589073");
        System.out.println(solve(in));
    }

    public static int solve(ArrayList<String> A) {
            //take variables a,b,c and assign it with first 3 numbers
            double a = Double.parseDouble(A.get(0));
            double b = Double.parseDouble(A.get(1));
            double c = Double.parseDouble(A.get(2));
            // excute the loop from index 3 onwards
            for(int i = 3; i < A.size(); i ++){
                // check if sum fall in (1, 2)
                if((a+b+c) > 1 && (a+b+c) < 2){
                    return 1;
                }
                // if not, then check is sum greater then 2
                // if so, then replece MAX(a,b,c) to new number
                else if((a+b+c) >= 2){
                    if(a > b && a > c){
                        a = Double.parseDouble(A.get(i));
                    }
                    else if( b > c){
                        b = Double.parseDouble(A.get(i));
                    }
                    else{
                        c = Double.parseDouble(A.get(i));
                    }
                }
                // else then sum must be less than 1
                // then replece MIN(a,b,c) to new number
                else{
                    if(a < b && a < c){
                        a = Double.parseDouble(A.get(i));
                    }
                    else if( b < c){
                        b = Double.parseDouble(A.get(i));
                    }
                    else{
                        c = Double.parseDouble(A.get(i));
                    }
                }
            }
            // check for last a, b, c  pair
            if((a+b+c) > 1 && (a+b+c) < 2){
                return 1;
            }
            else {
                return 0;
            }
    }

    public int repeatedNumber(final List<Integer> A) {
        if(A == null || A.isEmpty())
            return -1;

        HashSet map =new HashSet();
        for(int i=0;i<A.size();i++){
            if(map.contains(A.get(i))){
                return A.get(i);
            }
            map.add(A.get(i));
        }
        return -1;
    }
}
