package others;

public class PowerXn {
    public static void main(String[] args) {
        PowerXn pow = new PowerXn();
        int n = 4;
        System.out.print(myPow(2,n));
    }
    public static double myPow(double x, int n) {
        boolean negate = false;
        double result = 1.0;
        if (n < 0) {
            negate = true;
            if (-n == n) {
                result = x;
                n++;
            }
            n = Math.abs(n);
        }
        while (n > 0) {
            if (n%2 == 1) {
                result *= x;
            }
            n = n/2;
            x = x*x;
        }
        if (negate) {
            result = 1.0 / result;
        }
        return result;
    }

}
