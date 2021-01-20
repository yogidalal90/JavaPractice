package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllSubstrings {

    public static void main(String[] args) {
        String sentence = "amanaplacanaplacancanal";
        List<String> dict = new ArrayList<>();
        dict.add("can");dict.add("pla");dict.add("ana");
        List<Integer> res = findConcatenation(sentence,dict);
        for(int j:res)
            System.out.print(j+ " ");
    }
   static List<Integer> findConcatenation(String sentence, List<String> dict){

        Map<String , Integer> map = new HashMap<>();
        for(String s:dict){

            map.put(s,map.getOrDefault(s,0)+1);
        }

        int wordSize = dict.get(0).length();
        List<Integer> result = new ArrayList<>();

        for(int i=0;i+wordSize*dict.size()<=sentence.length();i++)
        {
            if(matching(i,map,sentence, wordSize,dict.size())){
            result.add(i);
        }

        }
        return result;
    }
    static boolean matching(int idx,Map<String,Integer> map,String sentence, int wordsize, int dictSize){
        Map<String,Integer> mapCopy = new HashMap<>();
        for(int i=idx;i<idx+wordsize*dictSize;i+=wordsize){
            String curr = sentence.substring(i,i+wordsize);
            if(map.containsKey(curr))
            {

                int count = mapCopy.getOrDefault(curr,0)+1;
                if(count>map.get(curr))
                    return false;
                else
                    mapCopy.put(curr,count);
            }else
                return false;

        }

        return true;
    }

}
