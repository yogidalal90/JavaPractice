package array;

import java.util.ArrayList;

public class SubarraySum {

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        ArrayList<Integer>  list = new ArrayList<>();
        int n = A.size();
        int start =0;int sum =0; int curr=0; int end=-1;
        boolean found=false;


        for(int r=0;r<n;r++){
            sum +=A.get(r);

            while(sum>B) sum -=A.get(start++);

            if(sum == B){
                for(int i=start;i<=r;i++){
                    list.add(A.get(i));
                }
                return list;
            }
        }

        list.add(-1);
        return list;
    }
}
