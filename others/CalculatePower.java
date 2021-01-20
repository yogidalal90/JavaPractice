package others;

public class CalculatePower {

    public static void main(String[] args) {
        System.out.print(myPow(2,2));
    }
    public static double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n<0){
            x=1/x;
            n=-n;
        }
        if(n%2==0){
            return myPow(x*x,n/2);
        }else
            return x*myPow(x,n-1);
    }
}
