package string;

public class EncodeSpreadSheet {

    public static void main(String[] args) {
        System.out.print(encodeSpreadSheets("ZZ"));
    }
    //if A == 1;
    static int encodeSpreadSheet(String col){

        int res = 0;
        for(char c:col.toCharArray()){
            res  = res * 26 + c-'A'+1;
        }
        return res;
    }
    //A starts with 0
    static int encodeSpreadSheets(String col){

        int res = 0;
        for(char c:col.toCharArray()){
            res  = res * 25 + c-'A';
        }
        return res;
    }

}
