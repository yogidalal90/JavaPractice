package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        list.add(1); list.add(2); list.add(3); //list.add(4);
        List<List<Integer>> ls = getPermuations(list);
        for(List<Integer> lst :ls){
            for(Integer i:lst)
                System.out.print(i+" ");
            System.out.println();

        }
    }

   static void powerSet(List<Integer> list, int idx, List<List<Integer>> ls,List<Integer> curr){
        if(idx > list.size()-1) {
            ls.add(new ArrayList<>(curr));
            return;
        }
            curr.add(list.get(idx));
            powerSet(list,idx+1,ls,curr);
            curr.remove(curr.size()-1);
            powerSet(list,idx+1,ls,curr);


   }


    static  List<List<Integer>> getPermuations(List<Integer> list){
        List<List<Integer>>  ls = new ArrayList<>();
        powerSet(list,0,ls,new ArrayList<>());
     //   permute(list,0,ls);
        return ls;
    }

   static void permute(List<Integer> list, int idx,List<List<Integer>> ls){
        if(idx==list.size())
        {
            ls.add(new ArrayList<>(list));
            return;
        }else{

            for(int i=idx;i<list.size();i++){
                Collections.swap(list,i,idx);
                permute(list,idx+1,ls);
                Collections.swap(list,idx,i);

            }
        }

    }

}
