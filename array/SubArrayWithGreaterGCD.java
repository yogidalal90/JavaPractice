package array;

public class SubArrayWithGreaterGCD {
    public static void main(String[] args) {
        SubArrayWithGreaterGCD sub= new SubArrayWithGreaterGCD() ;
        System.out.print(sub.subArray(new int[]{12, 6, 12, 24, 4},2));
    }
    int subArray(int[] arr, int gcd){
        int lth=0; int max=0;
        for(int i=0;i<arr.length-1;i++){
            if(gcd(arr[i],arr[i+1])>gcd){
                lth++;
                if(i+1==arr.length-1)
                    lth++;
            }else{
                max = Math.max(max,lth);
                lth=0;
            }

        }
        max = Math.max(max,lth);
        return max==0?0:max;
    }

    int gcd(int a, int b){
        if(a==0 || b==0)
                return 0;
        if(a==b)
            return a;
        if(a>b)
            return gcd(a-b,b);
        return gcd(a,b-a);
    }
}
