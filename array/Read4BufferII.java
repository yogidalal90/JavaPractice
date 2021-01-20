package array;

public class Read4BufferII {
    int buf4Size=4;
    int buf4Idx=4;
    char[] buf4 = new char[4];

    public int read(char[] buf, int n) {
        int bufIdx=0;
        while(bufIdx<n){
            if(buf4Idx>=buf4Size){
                buf4Size = count4(buf4);
                buf4Idx =0;
                if(buf4Size==0)
                    break;
            }
            buf[bufIdx++]=buf4[buf4Idx++];


        }
        return bufIdx;
    }

    private int count4(char[] buf4) {
        return 0;
    }

}
