package string;

public class LookAndSay {
    public static void main(String[] args) {
        lookAndSay(4);
    }
    static String lookAndSay(int n){
        String s="1";
        for(int i=0;i<n;i++){
            s = nextNumber(s);
            System.out.println(s);
        }

        return s;
    }

    static String nextNumber(String s){

        StringBuilder sb = new StringBuilder();
        int count=1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1))
            count++;
		else{
                sb.append(count);
                sb.append(s.charAt(i));
                count=1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length()-1));
        return sb.toString();

    }


}
