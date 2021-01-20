package string;
import java.util.*;
public class Strobogrammatic {
    public static void main(String[] args) {
        List<String> res = new Strobogrammatic().findStrobogrammatic(3);
        for(String str:res)
            System.out.print(str+" ");
    }
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n==0)
            return res;
        List<String> ls = new ArrayList<>();
        if((n&1) == 0){
            ls.add("");
        }else{
            ls.add("1");
            ls.add("0");
            ls.add("8");
        }
        res.addAll(ls);

        int i= ((n&1)==0)?2:3;

        for(;i<=n;i+=2){
            List<String> temp = new ArrayList<>();
            for(String s:res){
                temp.add("9"+s+"6");
                temp.add("8"+s+"8");
                temp.add("6"+s+"9");
                temp.add("1"+s+"1");
                if(i!=n)
                    temp.add("0"+s+"0");
            }
            res = temp;

        }
        return res;

    }

}
