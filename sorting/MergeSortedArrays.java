package sorting;

import java.util.*;

public class MergeSortedArrays {
   static class ArrayEntry{
        int arrId;
        int value;
        public ArrayEntry( int value,int arrId){
            this.arrId =arrId;
            this.value = value;
        }
    }

    public static List mergeSortedArrays( List<List<Integer>> sortedArrays){

        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());

        for(List<Integer> ls:sortedArrays){
            iters.add(ls.iterator());
        }

        PriorityQueue<ArrayEntry> pq = new PriorityQueue(sortedArrays.size(), new Comparator<ArrayEntry>(){

            @Override
            public int compare(ArrayEntry a1, ArrayEntry a2){
                return Integer.compare(a1.value,a2.value);
            }
        });

        for(int i=0;i<sortedArrays.size();i++){
            if(iters.get(i).hasNext())
                pq.add(new ArrayEntry(iters.get(i).next(),i));
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            ArrayEntry arr= pq.poll();
            list.add(arr.value);
            int i=arr.arrId;
            if(iters.get(i).hasNext())
                pq.offer(new ArrayEntry(iters.get(i).next(),i));

        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(0);
        ls.add(1);
        ls.add(3);
        ls.add(6);
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(1);
        ls1.add(4);
        ls1.add(13);
        ls1.add(16);
        List<Integer> ls2 = new ArrayList<>();
        ls2.add(03);
        ls2.add(12);
        ls2.add(13);
        ls2.add(15);
        List<List<Integer>> list = new ArrayList<>();
        list.add(ls); list.add(ls2); list.add(ls1);
        List<Integer> out = mergeSortedArrays(list);
        for(int i:out){
            System.out.print(i+" ");
        }
    }
}
