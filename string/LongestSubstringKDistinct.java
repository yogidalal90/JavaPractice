package string;

import java.util.*;

class LongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.print(findLength("absbscsd",3));
    }
    public static int findLength(String str, int k) {

        if (k < 1)
            return -1;
        Map<Character, Integer> map = new HashMap<>();


        int start = 0;
        int end = str.length();
        int max = -1;
        for (int i = 0; i < end; i++) {
            char ch = str.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() > k) {
                int newStart = map.get(ch);
                max = Math.max(max, i - start);
                while (map.size() > k) {
                    char cs = str.charAt(start);
                    int count = map.get(cs);
                    if (count > 1) {
                        map.put(cs, count - 1);
                    } else
                        map.remove(cs);
                    start++;
                }
            }
        }

        return Math.max(max, end - start);
    }
}

