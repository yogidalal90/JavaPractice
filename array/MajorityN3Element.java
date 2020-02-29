package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear
 * time and constant additional space.
 * If so, return the integer. If not, return -1.
 * If there are multiple solutions, return any one.
 */
public class MajorityN3Element {

    public static void main(String[] args) {
        int[] ele = {1000441, 1000441, 1000994};
        List<Integer> list = new ArrayList<>();
        for(int i:ele){
            list.add(i);
        }
        System.out.println(findMajorityElement(list));
    }

    private static int findMajorityElement(List<Integer> a) {
        if(a ==null |a.isEmpty()){
            return -1;
        }
        int majIndex = a.size()/3;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:a){
            int count = 0;
            System.out.println(i);
            if(map.containsKey(i)){
                 count = map.get(i);
            }
            count  = count+1;
            map.put(i,count);
            if(count > majIndex){
                return i;
            }
        }
        return  -1;
    }
}
