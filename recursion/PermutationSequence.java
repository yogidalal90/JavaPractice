package recursion;

public class PermutationSequence {

    String permutation=""; int turn=0;
    public String getPermutation(int n, int k) {
        StringBuilder num = new StringBuilder();
        for(int i=1;i<=n;i++){
            num.append(i);
        }
        permute(num.toString(),k,0);
        return permutation;
    }

    public void permute(String num, int k, int ci){
        if(ci==num.length()-1) {
            turn +=1;
   //         System.out.println(turn+": "+ num);
            if (k == turn) {
                permutation = num;
            }
            return;
        }

        for(int i=ci;i<num.length();i++){
            num = swap(num,i,ci);
            permute(num,k,ci+1);
            num = swap(num,ci,i);
        }
    }

    String swap (String num, int i,int j){
        char ci = num.charAt(i);
        char cj= num.charAt(j);
        StringBuilder string = new StringBuilder(num);
        string.insert(i, cj);
        string.deleteCharAt(j+1);
        System.out.println(num+" : "+i+" : "+j+" : "+string.toString());
        return string.toString();
    }

    public static void main(String[] args) {
        PermutationSequence seq = new PermutationSequence();
        seq.getPermutation(3,5);
        System.out.print(seq.permutation);
    }
}
