package array;

import recursion.PermutationSequence;

import java.util.HashMap;
import java.util.Map;

public class LargeWithMinFreq {
    public static int LargButMinFreq(int arr[])
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int maxEle = Integer.MIN_VALUE;
        int freq = Integer.MAX_VALUE;
        for(int i:map.keySet()){
            if(map.get(i)<freq){
                freq = map.get(i);
                maxEle=i;
            }else if(map.get(i)==freq){
               maxEle = Math.max(maxEle,i);
            }
        }
        return maxEle;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 50, 150, 40};
        System.out.print(LargButMinFreq(arr));
    }
}
