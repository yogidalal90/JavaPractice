package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromeDecomposition {

    public static void main(String[] args) {
       /* List<List<String>> ls = decomPalin("02012");
        for(List<String> lst :ls){
            for(String i:lst)
                System.out.print(i+" ");
            System.out.println();*/
        String s ="a sa";
       String[] str = s.split(" ");
for(String st:str)
    System.out.println(st);
    //}
    }
    static List<List<String>> decomPalin(String palin){
        List<List<String>> list = new ArrayList<>();
        decompose(palin,0,new ArrayList<>(),list);
        return list;
    }

   static void decompose(String palin, int idx,List<String> ls,List<List<String>> list){

        if(idx == palin.length())
        {
            list.add(new ArrayList<>(ls));
            return;
        }


        for(int i=idx+1;i<=palin.length();i++){
            String s = palin.substring(idx,i);
            if(isPalin(s)){
                ls.add(s);
                decompose(palin,idx+1,ls,list);
                ls.remove(ls.size()-1);
            }

        }
    }

    static boolean isPalin(String s){
        if(s==null || s.isEmpty() || s.length()<2)
                return true;
        int start =0, end =s.length()-1;
        while(start<end)
        {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

}
