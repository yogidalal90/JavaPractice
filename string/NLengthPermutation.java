package string;

import java.util.HashSet;
import java.util.Set;

public class NLengthPermutation {
    static  StringBuilder ans = new StringBuilder();
    static String nLengthPermutation(int n, int d){

        if(n==1 && d==1)
            return "0";


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n-1;i++){
            sb.append("0");
        }
        String start = sb.toString();
        Set<String> set = new HashSet<>();
        dfs(start,set,d);
        ans.append(start);
        return new String(ans);

    }
    static void dfs(String s, Set<String> set, int d){

        for(int i=0;i<d;i++){
            String nbr = s+i;
            if(!set.contains(nbr)){
                set.add(nbr);
                dfs(nbr.substring(1),set,d);
                ans.append(i);
            }

        }

    }

    public static void main(String[] args) {
        int N = 2;
        int D = 2;
        System.out.println(nLengthPermutation(N, D));
    }
}
