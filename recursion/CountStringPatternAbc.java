package recursion;

public class CountStringPatternAbc {
    public static void main(String[] args) {
        int n = 3; // Total number of characters
        int bCount = 1, cCount = 2;
        System.out.println(countStr(n,bCount,cCount));
    }
    private static int countStr(int n, int bCount, int cCount){

        if(bCount < 0 || cCount < 0) return  0;
        if(n==1) return 1;
        if(bCount ==0 || cCount==0) return 1;

        int res = countStr(n-1,bCount, cCount) +
                countStr(n-1,bCount-1, cCount)+
                countStr(n-1,bCount,cCount-1);
        return  res;
    }
}
