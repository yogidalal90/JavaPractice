package others;

public class MissingEleUsingBit {

    public static void main(String[] args) {
        //Series should be of continuous natural numbers, can not be like {1,2,3,4,7}. it should be {1,2,4,3,6} for n=5
        int[] a = {1, 2, 6, 4, 3};
        int n = 5;
        System.out.println("missing element: " + missingEle(a, n));
    }
    /**
     * Only for array with elements starting from 1 to n and one missing element
     * @param a
     * @param n
     * @return
     */
    private static int missingEle(int[] a, int n){
        int xor = 0;

        for(int i=0;i<n;i++){
            xor ^= a[i]^i+1;
        }

        xor ^= n+1;
        return xor;
    }

}
