package string;

public class GenerateStringFromPattern {

    public static void main(String[] args) {
        String str = "1??0?101";
        generateString(str.toCharArray(),0);
    }

    private static void generateString(char[] ch, int ci){
        if(ci == ch.length){
            System.out.println(ch);
            return;
        }


        if(ch[ci]=='?'){
            ch[ci]='1';
            generateString(ch,ci+1);
            ch[ci]='0';
            generateString(ch,ci+1);
            ch[ci]='?';
        }else{
            generateString(ch,ci+1);
        }
    }


}
