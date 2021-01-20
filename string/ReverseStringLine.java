package string;

public class ReverseStringLine {

    public static void main(String[] args) {
        System.out.print(reverseWords("this is bat"));
    }
    static String reverseWords(String s){
        if(s==null || s.isEmpty())
            return s;


        StringBuilder sb  = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        int start = 0;

        StringBuilder word = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) == ' '){

                if(word.length() >1)
                {
                    word = word.reverse();
                    sb.replace(start,i,word.toString());
                    start = i;
                    word =new StringBuilder();
                }else
                    word.append(sb.charAt(i));

            }
        }



        return sb.toString();
    }



}
