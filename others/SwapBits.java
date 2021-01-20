package others;

public class SwapBits {
    public static void main(String[] args) {
        System.out.print(swapBits(73,6,1));
    }

    private static int swapBits(int n, int i, int j){
        if( ((n >>> i)&1) != ((n>>>j)&1)){
            n = n^ (1<<i);
            n = n^ (1<<j);
        }
        return n;
    }

}
