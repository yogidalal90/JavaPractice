package sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestInsertionSort
{
    public static int singleNumber(int[] A) {
        Map map = new HashMap();

        for(int i:A){
            if(map.containsKey(i)){
                map.put(i,1);
            }
            map.put(i,2);
        }
        Set<Integer> s = map.keySet();
        for(int i : s)
        {
            if(map.get(i) == Integer.valueOf(1)){
                return i;
            }
        }
        return -1;
    }
}
