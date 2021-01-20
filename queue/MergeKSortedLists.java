package queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        l1.add(2);
        l1.add(12);
        l1.add(15);
        l1.add(16);
        l2.add(1);
        l2.add(2);l2.add(5);l2.add(13);
        l3.add(5);l3.add(22);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1); list.add(l2); list.add(l3);
        List<Integer> merged = new MergeKSortedLists().mergeLists(list);
        for(int i:merged)
            System.out.print(i+" ");
    }
    class ListIndex{
        int listId;
        int listIdx;

        int getListId(){
            return this.listId;
        }

        int getListIdx(){
            return  this.listIdx;
        }

        public ListIndex(int id,int idx){
            listId=id;
            listIdx=idx;

        }
    }
    List<Integer> mergeLists (List<List<Integer>> sortedList){
        List<Integer> merged = new ArrayList<>();
        int n  = sortedList.size();
        PriorityQueue<ListIndex> li = new PriorityQueue<>(sortedList.size(), new Comparator<ListIndex>(){
            @Override
            public int compare(ListIndex l1, ListIndex l2) {
                return Integer.compare(sortedList.get(l1.getListId()).get(l1.getListIdx()), sortedList.get(l2.getListId()).get(l2.getListIdx()));
            }
            });
        for(int i=0;i<n;i++){
            ListIndex index = new ListIndex(i,0);
            li.offer(index);
        }

        while(!li.isEmpty()){
            ListIndex curr = li.poll();
            List<Integer> currList = sortedList.get(curr.getListId());
            int currIdx = curr.getListIdx();
            merged.add(currList.get(currIdx));
            if(currList.size()-1 != currIdx)
                li.offer(new ListIndex(curr.getListId(),currIdx+1));

        }
        return merged;

    }

}
