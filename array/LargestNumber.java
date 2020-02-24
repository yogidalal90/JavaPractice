package array;

import java.util.*;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example: Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    public static void main(String[] args) {
        ArrayList numbers = new ArrayList<Integer> ();
        numbers.add(40);
        numbers.add(42);
        numbers.add(0);
        numbers.add(9);
        System.out.println(largestNumber(numbers));
    }

    private static String largestNumber(List<Integer> numList) {
        if (numList == null || numList.isEmpty()) {
            return null;
        }
        List<String> numStrings = new ArrayList<>();
        for (Integer i : numList) {
            String s = String.valueOf(i);
            // Handle leading 0s in the list of numbers
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '0')
                {
                    numStrings.add(s.substring(j));
                    break;
                }
            }
        }
        Collections.sort(numStrings, new MyComparator());
        StringBuilder buf = new StringBuilder();
        for(String s : numStrings){
            buf.append(s);
        }
        return buf.toString();
    }
}

class MyComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        String first = s1 + s2;
        String second = s2 + s1;
        return second.compareTo(first);
    }
}
