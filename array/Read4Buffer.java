package array;

public class Read4Buffer {
    public int read(char[] buf, int n) {
        int i=0;
        char[] buf4 = new char[4];
        while(true){
            int count = read4(buf4);
            if(count==0){
                break;
            }
            for(int bi=0;bi<count && i<n;bi++){
                buf[i++]=buf4[bi];

            }

        }
        return i;
    }

    private int read4(char[] buf4) {
        return 0;
    }

}
