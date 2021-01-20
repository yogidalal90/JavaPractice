package Trie;

public class Similarity {
    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");
        float slowness = new Similarity().findSimilarity("Meerut","Mcsruth");
        System.out.println(slowness);
    }

    public float findSimilarity(String str1, String str2){
        if(str1 == null ){
// TODO handle
        }

        int n1 = str1.length();
        int n2 = str2.length();

        int[][] matches = new int[n1][n2];

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                char ch1 = str1.charAt(i);
                char ch2 = str2.charAt(j);
                if(ch1==ch2){
                    if(j==0 && i==0){
                        matches[i][j]=0;
                    }else if(i==0)
                        matches[i][j]=i+1;
                    else if(j==0)
                        matches[i][j]=j+1;
                    else{
                        matches[i][j]= matches[i-1][j-1];
                    }

                }else{
                    if(j==0 && i==0)
                        matches[i][j]=1;
                    else if(i==0)
                        matches[i][j] =  matches[i][j-1]+1;
                    else if(j==0)
                        matches[i][j] =  matches[i-1][j]+1;
                    else{
                        matches[i][j] = Math.min( matches[i-1][j], matches[i][j-1])+1;
                    }

                }
            }
        }
        int matchCount =  matches[n1-1][n2-1];
        System.out.println(matchCount);
        int lth = Math.min(n1,n2);
        float slowness = (matchCount/lth);
        return slowness;
    }
}
