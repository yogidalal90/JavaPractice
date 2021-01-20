package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        List<List<Integer>> ls = subSet(3,2);
        for(List<Integer> lst :ls){
            for(Integer i:lst)
                System.out.print(i+" ");
            System.out.println();

        }
    }

    static List<List<Integer>> subSet(int n , int k){
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> list  = new ArrayList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
        subSet(list,k,0,new ArrayList<>(),ls);
        return ls;


    }

   static void subSet(List<Integer> list, int k , int idx, List<Integer> curr,
                List<List<Integer>> ls){
        if(curr.size()==k){
            ls.add(new ArrayList<>(curr));
            return;
        }

        int remaining = k-curr.size();
        for(int i=idx;i<list.size() && remaining <= list.size()-i+1;i++){
            curr.add(list.get(i));
            subSet(list,k,idx+1,curr,ls);
            curr.remove(curr.size()-1);

        }


    }

}
