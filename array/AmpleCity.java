package array;

public class AmpleCity {
    public static void main(String[] args) {
        int[] fuel={1000,400,100,600,500,200,200};
        int[] dist={900,600,200,400,600,200,100};
        System.out.print(findAmpleCity(fuel,dist));
    }
    static int findAmpleCity(int[] fuel, int[] dist){

        int min = Integer.MAX_VALUE;
        int prev= 0; int idx = -1;
        for(int i=0;i<fuel.length;i++){
            int curr =fuel[i]-dist[i]+prev;
            if(curr>=0){
                idx=prev<min?i:idx;
                min = Math.min(min,prev);
            }
            prev= curr;
        }

        return idx;

    }


}
