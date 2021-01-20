package array;

import java.util.Stack;

public class RectangleArea{

    public static void main(String[] args) {
        int[] arr= {2,1,3,2,3};
        System.out.print(largestRectatngle(arr));
    }
       public static  int largestRectatngle(int[] arr){

            Stack<Integer> st = new Stack<>();
            int max =0;
            for(int i=0;i<arr.length;i++){
                if( st.isEmpty() || arr[st.peek()] <=arr[i])
                    st.push(i);
                else{
                    while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                        int idx = st.pop();
                        int diffBtwIndex = st.isEmpty() ? i : i - 1 - st.peek();
                        max = Math.max(max, diffBtwIndex * arr[idx]);
                    }
                    //    st.push(i);
                }
            }

            int i=arr.length;
            while(!st.isEmpty()){
                int idx = st.pop();
                int diffBtwIndex = st.isEmpty()?i:i-1-st.peek();
                max = Math.max(max, diffBtwIndex *arr[idx]);
            }
            return max;
        }
}
