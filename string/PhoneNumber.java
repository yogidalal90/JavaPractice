package string;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    public static void main(String[] args) {
        System.out.print(phoneMnemonic("204"));
    }
    public static List<String> phoneMnemonic(String phoneNumber) {

        List<String> out = new ArrayList<>();
        char[] chArr = new char[phoneNumber.length()];
        phoneNumHelper(out,chArr,phoneNumber,0);
        return out;
    }
    static String[] arr =  {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    static void phoneNumHelper(List<String> out, char[] chArr, String phoneNumber, int idx){
        if(idx == phoneNumber.length()){
            out.add(new String(chArr));
        }else{
            for(int i=0;i<arr[phoneNumber.charAt(idx)-'0'].length();i++){
                chArr[idx]=arr[phoneNumber.charAt(idx)-'0'].charAt(i);
                phoneNumHelper(out,chArr,phoneNumber,idx+1);
            }
        }

    }
}
