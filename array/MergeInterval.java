package array;

import java.util.ArrayList;

public class MergeInterval {
    public static void main(String[] args) {
        MergeInterval mi =new MergeInterval();
        int[][] intervals = {{1,4},{0,0}};
        int[][] merged = mi.merge(intervals);
        for(int i=0;i<merged.length;i++){
            for(int j=0;j<=1;j++) {
                System.out.print(merged[i][j]+ " ");
            }
            System.out.println();
        }
    }
        private int[][] merge(int[][] intervals) {
            if(intervals.length < 1 || intervals[0].length < 1){
                return null;
            }
            int start = intervals[0][0];
            int end = intervals[0][1];
            int rows = intervals.length;

            ArrayList<Integer> lists = new ArrayList<>();
            ArrayList<ArrayList<Integer>> merge = new ArrayList<>();
            int mr = 0;
            for(int i=1;i<rows;i++){
                for(int j=0;j<=1;j++){
                    if(intervals[i][0] <start){
                        start = intervals[i][0];
                    }
                    if(intervals[i][j] > end){
                        if(j == 1){
                            end = intervals[i][j];
                        } else {
                            lists.add(start);
                            lists.add(end);
                            merge.add(mr,lists);

                            lists = new ArrayList<>();
                            mr +=1;
                            start = intervals[i][j];
                            end = -1;
                        }
                    }
                }
            }
            lists.add(start);
            lists.add(end);
            merge.add(mr,lists);

            int[][] merged = new int[merge.size()][2];
            for(int i=0;i<merge.size();i++){
                for(int j=0;j<=1;j++) {
                    merged[i][j] = merge.get(i).get(j);
                }
            }
            return merged;
        }
    }