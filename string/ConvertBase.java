package string;

public class ConvertBase {
    public static void main(String[] args) {
        System.out.print(convertBase("615",7,13));
    }

    public static String convertBase(String numAsString , int b1, int b2) {

        if(b1 == b2)
            return numAsString;

        boolean neg = numAsString.charAt(0)=='-'?true:false;
        int num=0;
        for(int i= neg?1:0;i<numAsString.length();i++){
            num *=b1;
            num += Character.isDigit(numAsString.charAt(i))?
                    numAsString.charAt(i)-'0': numAsString.charAt(i)-'A'+10;//num>10

        }
        return calculateFromBase(num, b2);


    }

    static String calculateFromBase(int num, int base){
        if(num == 0)
            return "";

        return calculateFromBase(num/base,base)+
                (char) (num%base >= 10? 'A'+ num%base-10 :'0'+num%base);

    }

}
