package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringManipulation {

	/*
		Given two string check if they can be made equivalent by performing some operations on one or both string.

		swapEven:swap a character at an even-numbered index with a character at another even-numbered index

		swapOdd:swap a character at an odd-numbered index with a character at another odd-numbered index

		Given : s="cdab" , x="abcd"
		s -> cdab ->swap a and c ->adcb (swapEven)-> swap b and d (swapOdd) -> s="abcd" = x="abcd"

		Given: s="dcba" , x="abcd"
		no amount of operation will move character from an odd index to even index, so the two string will never be equals

		Given: s="abcd" ,x="abcdcd"
		x length to big so will never be equals


	 */


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        System.out.println(manipuateStrings("dcba", "abcd"));
    }


    /*  Logic
     *  for each character of first string,
     *  check if that char is in any even or odd position of the second string depending
     *  on the even or odd position of the
     *  first string char
     */



    public static boolean manipuateStrings(String first, String second){

        if(first==null || second ==null ||first.length()!=second.length()) return false;

        char[] firstToChar = first.toCharArray();
        char[] secondToChar = second.toCharArray();
        Map<Character, List<Integer>> oddMap = new HashMap<>();
        Map<Character, List<Integer>> evenMap = new HashMap<>();

        for(int i=0;i<first.length();i++){
            if(first.charAt(i)==second.charAt(i))continue;
            if(i%2 ==0) {
                List<Integer> list = evenMap.getOrDefault(first.charAt(i), new ArrayList<>());
                list.add(i);
                evenMap.put(first.charAt(i), list);
            }else{
                List<Integer> list = oddMap.getOrDefault(first.charAt(i), new ArrayList<>());
                list.add(i);
                oddMap.put(first.charAt(i), list);
            }
        }

        for(int i=0;i<second.length();i++){
            if(second.charAt(i)!=first.charAt(i)){
                char ch = second.charAt(i);
                if(i%2 ==0 ){
                    if(!evenMap.containsKey(ch)) return false;
                    List<Integer> list = evenMap.get(ch);
                    first = swap(first,i,list.get(0));
                    list.remove(0);
                    if(list.isEmpty()) evenMap.remove(ch);
                    else evenMap.put(ch,list);
                }else{
                    if(!oddMap.containsKey(ch)) return false;
                    List<Integer> list = oddMap.get(ch);
                    first = swap(first,i,list.get(0));
                    list.remove(0);
                    if(list.isEmpty()) oddMap.remove(ch);
                    else oddMap.put(ch,list);
                }
            }
        }
        return true;
    }

    static String swap(String s, int i,int j){
        char[] ch = s.toCharArray();
        char tmp = ch[i];
        ch[i]=ch[j];
        ch[j]=tmp;
        return ch.toString();
    }
}
