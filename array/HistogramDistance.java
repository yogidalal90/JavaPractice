package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HistogramDistance {

    public static void main(String[] args) {
        int[] arr={2, 8, 3, 1, 3, 1, 6, 1, 1, 2};
        int[] res = new HistogramDistance().findMaxDistance(arr);
        System.out.print(res[0]+" : "+res[1]);
    }

    int[] findMaxDistance(int[] arr){
        int[] res = new int[2];
        int n = arr.length;
        Stack<Integer> st= new Stack<>();
        int maxDist = 0;
        int maxIdx = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()<arr[i]){
                st.pop();
            }

            int low = st.isEmpty()?maxIdx:st.peek();
            int dist = i-low;
            if(dist > maxDist){
                maxDist = dist;
                res[0]=low;
                res[1]=i;
            }

            if(arr[maxIdx] < arr[i])
                maxIdx=i;
            st.push(i);
        }
        return res;
    }
}
