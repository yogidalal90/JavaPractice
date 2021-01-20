package array;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
class Range{
    int start;
    int end;
    public Range(int start, int end){
        this.start = start;
        this.end =end;
    }
}

    public static void main(String[] args) {
        MissingRange mr  = new MissingRange();
        System.out.print(mr.findMissingRanges(new int[]{2,100},0,99));
    }
    public String findMissingRanges(int[] arr, int rangeStart, int rangeEnd){
        if(rangeEnd<rangeStart)
            return null;
        List<Range> ranges = findRanges(arr,rangeStart,rangeEnd);
        if(ranges.isEmpty())
            return null;
        StringBuilder result = new StringBuilder();
        for(Range r:ranges){
            if(r.start==r.end)
                result.append(r.start+",");
            else
                result.append(r.start+"-"+r.end+",");

        }
        String output = result.toString();
        output = output.substring(0,output.length()-1);
        return output;


    }

    private List<Range> findRanges(int[] arr, int rangeStart, int rangeEnd){
        List<Range> ls = new ArrayList<>();
        if(arr.length <1){			  ls.add(new Range(rangeStart,rangeEnd));
            return ls;
        }

        int start=rangeStart;//0
        int end=rangeStart;
        // {2,5,89}
        for(int i=0;i<arr.length;i++){
            if(arr[i]<rangeStart) continue;
      //      if(arr[i]>rangeEnd) break;
            if(start !=arr[i]) {
                if (arr[i] > rangeEnd)
                    end = rangeEnd;
                else
                    end = arr[i] - 1;
                ls.add(new Range(start, end));
                start = arr[i];
                start++;
            }else
                start++;


        }
//4 //100

        if(start!=rangeEnd+1)
            ls.add(new Range(start,rangeEnd));

        return ls;
    }

}
