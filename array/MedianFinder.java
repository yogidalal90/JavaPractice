package array;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> lowPq;
    private PriorityQueue<Integer> hiPq;
    /** initialize your data structure here. */
    public MedianFinder() {
        lowPq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        hiPq  = new PriorityQueue<>();
    }

    private void addNum(int num) {
        lowPq.add(num);
        hiPq.add(lowPq.peek());
        lowPq.remove();
        if(lowPq.size()<hiPq.size()){
            lowPq.add(hiPq.peek());
            hiPq.remove();
        }
    }

    private double findMedian() {
        if(lowPq.isEmpty() )
            return 0;
        return lowPq.size()>hiPq.size() ? (double)lowPq.peek(): ((double)lowPq.peek()+(double)hiPq.peek())/2;
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
      obj.addNum(10);  obj.addNum(10); obj.addNum(20); obj.addNum(8); obj.addNum(1);obj.addNum(9);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 *
 */
