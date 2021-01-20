package string;

import javax.management.remote.rmi._RMIConnection_Stub;

/*
One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pal -> false
 */
public class OneAway {
    public static void main(String[] args) {
        System.out.print(isOneAway("pake","paleg"));
    }

    private static  boolean isOneAway(String str1, String str2){
        int n1 = str1.length()-1;
        int n2 = str2.length()-1;
        if(Math.abs(n1-n2) >1)
            return false;
        int count=0;
       int i=0; int j=0;
        while(i<=n1 && j<=n2){
            if(str1.charAt(i) != str2.charAt(j)) {
                if (count == 1)
                    return false;
                if (n1 > n2)
                    i++;
                if (n2 > n1)
                    j++;

                count++;
            }
                i++;
                j++;

        }
        if(i<n1 || j<n2)
            count++;
        return count <2;
    }
}
