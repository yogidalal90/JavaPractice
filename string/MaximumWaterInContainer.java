package string;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class MaximumWaterInContainer {

    public int maxArea(int[] container) {

        if(container == null || container.length == 0){
            return 0;
        }
        int max = 0;

        int start=0, end=container.length-1;

        while(start<end){
            int front = container[start];
            int back = container[end];

            int curr = (end-start)*(Math.min(front,back));
            max = Math.max(curr,max);
            if(front<back)
                start++;
            else
                end--;
        }
        return max;

    }
}
