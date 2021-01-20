package string;

public class SnakePattern {
    public static void main(String[] args) {
        System.out.print(encrypt("Hello World!"));
    }
    static String encrypt(String s){

        StringBuilder high=new StringBuilder();

        for(int i=1;i<s.length();i+=4){
            high.append(s.charAt(i));
        }
        for(int i=0;i<s.length();i+=2){
            high.append(s.charAt(i));
        }

        for(int i=3;i<s.length();i+=4){
            high.append(s.charAt(i));
        }

        return high.toString();
    }

}
