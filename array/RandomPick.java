package array;

import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * For example, given an input list of values [1, 9], when we pick up a number out of it,
 * the chance is that 9 times out of 10 we should pick the number 9 as the answer.
 * 
 */
public class RandomPick {
    public static void main(String[] args) {
        int[] w = {1,2,2,4,1,6};
        RandomPick pick = new RandomPick(w);
        System.out.println(pick.pickIndex());
    }
    int[] wts;
    public RandomPick(int[] w) {

        int n = w.length;
        for(int i=1;i<n;i++){
            w[i] +=w[i-1];
        }
        wts = w;
    }

    public int pickIndex() {
        int n = wts.length;
        Random rand = new Random();
        int idx  = rand.nextInt(wts[n-1])+1;
        int left = 0, right = n-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(wts[mid] == idx){
                return mid;
            }
            else if(wts[mid]<idx){
                left = mid+1;
            }else
                right = mid-1;
        }
        return left;

    }
}
