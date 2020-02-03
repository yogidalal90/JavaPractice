package list;

import java.util.ArrayList;

public class PlusOne {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList();
        ar.add(2);
        ar.add(9);
       ar.add(9);
        System.out.println(plusOne(ar));

    }
    private  static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
            if(A == null || A.isEmpty()){
                return null;
            }

            int indexNine = -1;
            int lth = A.size();


            if(lth == 1 && A.get(0)==0){
                A.set(0,1);
                return A;
            }
            for(int i=lth-1;i>=0 && A.get(i)==9;i--)
                indexNine = i;

            if(indexNine ==-1){
                A.set(lth-1,A.get(lth-1)+1);
                while(A.get(0)==0)
                    A.remove(0);
                return A;
            }
            for(int i=indexNine;i<lth;i++){
                A.set(i,0);
            }
            if(indexNine == 0){
                A.add(0,1);
            } else {
                A.set(indexNine-1,A.get(indexNine-1)+1);
            }
            while(A.get(0)==0)
                A.remove(0);
            return A;
    }
}
