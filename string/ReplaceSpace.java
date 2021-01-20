package string;
/*
URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string.
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        System.out.print(new ReplaceSpace().replaceSpace("Mr John Smith   "));
    }
    private String replaceSpace(String s){
        s = s.trim();
        char[] ch = s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(ch[i]==' ')
                sb.append("%20");
            else
                sb.append(ch[i]);
        }
        return sb.toString();
    }
}
