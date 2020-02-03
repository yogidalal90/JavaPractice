package dp;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * Count minimum number of flips required to have all signs as +.
 * Can only flip K signs at a time.
 *  ++--+-+-- 3 : +++++++++
 *
 */
public class PanCakeProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("A-small-practice.in"));
        int rowNum =1;
        String st;
        String mixPancakes = null;
        int flipperSize = 0;
        String[] input = new String[2];
        while ((st = br.readLine()) != null) {
            System.out.println();
                System.out.print("CASE #"+rowNum++ +":");
                input = st.split(" ");
            mixPancakes = input[0];
            flipperSize = Integer.valueOf(input[1]).intValue();
            flipPanCakes(mixPancakes,flipperSize);
         }



    }

  public static void flipPanCakes(String mixPancakes, int flipperSize){
      int counter =0;

      boolean[] panBool = new boolean[mixPancakes.length()];

      for(int i=0;i<mixPancakes.length();i++){
          if(mixPancakes.charAt(i) == '+')
          {
              panBool[i]=true;
          }
      }

      for(int i=0;i<panBool.length-flipperSize+1;i++){
          if(!panBool[i]){
              counter++;
              for(int j=i;j<i+flipperSize;j++){
                  panBool[j]  = !panBool[j];
              }
          }
      }
      for(int i = panBool.length-flipperSize+1;i<panBool.length;i++ ){
          if(!panBool[i]){
              System.out.print(" IMPOSSIBLE");
              return;
          }
      }

      System.out.print(" "+ counter);
  }

}
