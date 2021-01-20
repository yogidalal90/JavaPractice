package others;

public class BinaryToHexa {
    public static void main(String[] args) {
        BinaryToHexa bx = new BinaryToHexa();
        System.out.print(bx.convertBinaryToHexa(11));
    }
    private String convertBinaryToHexa(int num){
        if(num==0)
            return  "0";
        char[] hexa = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        int count=0;
        StringBuilder sb = new StringBuilder();

        while(count<8 && num !=0){
            sb.append(hexa[num & 15]);
            num = num >>4;
        }
        return sb.reverse().toString();
    }
}
