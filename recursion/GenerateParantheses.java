package recursion;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    public static void main(String[] args) {
       List<String> ls = genParentheses(2);
       for(String s:ls)
           System.out.print(s+" ");
    }
  static  List<String> genParentheses(int pairs){
        List<String> ls = new ArrayList<>();
        generateParen(pairs,pairs,"",ls);
        return ls;

    }

   static void generateParen(int leftPairs, int rtPairs, String sb, List<String> list){
        if(leftPairs == 0 && rtPairs==0){
            list.add(sb);
            return;
        }
        if(leftPairs >0){
            generateParen(leftPairs-1,rtPairs,sb+"(",list);
        }
        if(rtPairs > leftPairs)
            generateParen(leftPairs,rtPairs-1,sb+")",list);


    }

}
