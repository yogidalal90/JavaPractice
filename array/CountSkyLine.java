package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountSkyLine {

    public static void main(String[] args) {
        List<List<Integer>> ls = countSkyLine(new int[]{1,2,1,4,1,2,4,4,8}, 3);
        System.out.print(ls.size());
    }

    static List<List<Integer>> countSkyLine(int[] arr, int k){

        HashMap<Integer,Integer> map =new HashMap<>();

        HashMap<Integer,Integer> idx=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(!idx.containsKey(arr[i])){
                idx.put(arr[i],i);
            }
        }

        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            if(idx.containsKey(num/2) && idx.get(num/2)<i){
                if(map.containsKey(num/2)){
                    map.put(num, map.get(num/2)+1);
                }else
                    map.put(num,1);
            }else
                map.put(num,1);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(Integer i:map.keySet()){
            int K=k;
            if(map.get(i)>=K){
                List<Integer> ls = new ArrayList<>();
                while(K>0){
                    ls.add(0,i);
                    i=i/2;
                    K--;
                }
                list.add(ls);

            }
        }
        return list;

    }

}
