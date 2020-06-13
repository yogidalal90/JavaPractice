package array;

import java.util.*;

public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob. hIt, baLl";
        String[] banned ={"bob", "hit"};
        System.out.println(mostCommonWord(paragraph,banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.isEmpty()){
            return paragraph;
        }
        paragraph = paragraph.replace('!',' ');
        paragraph = paragraph.replace('?',' ');
        paragraph = paragraph.replace(',',' ');
        paragraph = paragraph.replace(';',' ');
        paragraph = paragraph.replace('.',' ');
        paragraph = paragraph.replace("'"," ");

        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> ban = new HashSet<>();

        for(String s: banned){
            ban.add(s);
        }



        String[] str =  paragraph.split(" ");
        String output = ""; int count =0;
        for(String s:str){
            int curr = 0;
            s = s.toLowerCase();
            Queue<Integer> que = new LinkedList<>();


            if(!ban.contains(s) && !s.isEmpty()){
                curr = map.getOrDefault(s,0)+1;

                map.put(s,curr);
                if(curr > count){
                    count = curr;
                    output = s;
                }
            }
        }
        return output;
    }
}
