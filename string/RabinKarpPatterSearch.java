package string;

public class RabinKarpPatterSearch {

    private int base = 101;
    private long reCalculateHash(char[] str,int oldIndex, int newIndex,int patternLen,long oldHash) {
        long newHash = oldHash - str[oldIndex];
        newHash = newHash/base;
        newHash += str[newIndex]*Math.pow(base, patternLen - 1);
        return newHash;
    }
    private long calculateHash(char[] str, int k){
        long hash = 0;
        for (int i = 0 ; i <= k; i++) {
            hash += str[i]*Math.pow(base,i);
        }
        return hash;
    }

    private boolean matchPattern(String str, int start, int end, String pattern) {
        int i=start;
        while(start <= end){
            if(str.charAt(start) != pattern.charAt(start-i)){
                return false;
            }
            start++;
        }
        return true;
    }
    private int findPattern(String str, String pattern){
        if(str == null || str.isEmpty() || pattern == null || pattern.isEmpty()){
            return  0;
        }
        int pLen = pattern.length();
        int sLen = str.length();
        long patternHash = calculateHash(pattern.toCharArray(),pLen-1);
        long strHash = calculateHash(str.toCharArray(),pLen-1);
        System.out.println(patternHash+" : "+strHash);
        for(int i=1;i<=sLen-pLen+1;i++){
            if(strHash == patternHash && matchPattern(str,i-1,i+pLen-2,pattern)){
                return i-1;
            }
            if(i < sLen-pLen+1)
                strHash = reCalculateHash(str.toCharArray(),i-1,i+pLen-1,pLen,strHash);
            System.out.println(strHash);
        }
        return -1;
    }

    public static void main(String[] args) {
        RabinKarpPatterSearch rb = new RabinKarpPatterSearch();
        System.out.print(rb.findPattern("banana","ana"));
    }
}
