package queue;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream.
 * For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 */
public class KthLargestStream {

    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        KthLargestStream kt = new KthLargestStream(3,nums);
        System.out.println(kt.add(3));
        System.out.println(kt.add(5));
    }

    private final PriorityQueue<Integer> q;
    private final int k;
    private KthLargestStream(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int a :nums) {
            add(a);
        }
    }

    private int add(int val) {

        q.offer(val);
        if (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }
}
