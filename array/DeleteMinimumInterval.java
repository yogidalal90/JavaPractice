package array;

import java.util.*;

/**
 * Given a list of closed intervals, each interval is in the range of 1 to 200,
 * and can overlap with other intervals. Return the minimum number of intervals to delete from the list,
 * such that every integer from 1 to 200 is covered by at most 3 intervals.
 */
public class DeleteMinimumInterval {
    static class Interval{
        int start;
        int end;

        public Interval(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(2,5));
        input.add(new Interval(1,4));
        input.add(new Interval(2,5));
        input.add(new Interval(3,5));
        int res = new DeleteMinimumInterval().deleteMinInterval(input);
        System.out.print(res);
    }

    private int deleteMinInterval(List<Interval> input) {
        int count=0;
        input.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end,o2.end);
            }
        });
        int n = input.size();
        Map<Integer, List<Integer>> map = new HashMap();

        for(int i=0;i<n;i++){
            Interval curr = input.get(i);
            for(int j=curr.start;j<=curr.end;j++) {
                List<Integer> list = map.getOrDefault(j, new ArrayList<>());
                list.add(i);
                map.put(j,list);
            }

        }

        for(int i=0;i<200;i++){
            if(!map.containsKey(i))
                continue;
            List<Integer> list  = map.get(i);
            if(list.size()<3)
                continue;

            for(int j=0;j<list.size()-3;j++){
                int idx= list.get(j);
                Interval interval =input.get(idx);
                count++;
                for(int k=interval.start;k<=interval.end;k++){
                    map = deleteFromMap(map,k,idx);
                }
            }
        }

        return count;
    }

    public Map<Integer, List<Integer>>  deleteFromMap(Map<Integer, List<Integer>> map, int key, int idx){
        List<Integer> list = map.get(key);
        list.remove(new Integer(idx));
        map.put(key,list);
        return map;
    }

}
