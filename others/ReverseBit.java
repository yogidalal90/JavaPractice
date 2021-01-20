package others;

public class ReverseBit {

    public static void main(String[] args) {
        //964176192
        int num  =43261596;
        System.out.println(Integer.toBinaryString(num));
        int n = reverseBits(num);
        System.out.println(Integer.toBinaryString(n));
    }


    private static int reverseBits(int n){
        int num=0;

        for(int i=0;i<32;i++){
            num <<=1;
            num = num|(n &1);
            n >>=1;
        }
        return num;
    }

}
