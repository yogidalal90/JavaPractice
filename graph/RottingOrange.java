package graph;

import java.util.ArrayList;
import java.util.List;

public class RottingOrange {
    public static int orangesRotting(int[][] grid) {

        int n  =grid.length;
        if(n < 1)
            return 0;
        int m = grid[0].length;

        int total =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    List<Integer> rotten = new ArrayList<>();
                    rotten.add(i); rotten.add(j);
                    int count =0;
                    while(!rotten.isEmpty()){
                        count+=1;
                        int row = rotten.get(0);
                        int col = rotten.get(1);
                        rotten.remove(0); rotten.remove(0);
                        if(row >0 && grid[row-1][col]==1){
                            rotten.add(row-1); rotten.add(col);
                            grid[row-1][col]=2;
                        }
                        if(col >0 && grid[row][col-1]==1){
                            rotten.add(row); rotten.add(col-1);
                            grid[row][col-1]=2;
                        }
                        if(row <n-1 && grid[row+1][col]==1){
                            rotten.add(row+1); rotten.add(col);
                            grid[row+1][col]=2;
                        }
                        if(col <n-1 && grid[row][col+1]==1){
                            rotten.add(row); rotten.add(col+1);
                            grid[row][col+1]=2;
                        }

                    }
                    if(count>1) total+=1;
                }

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] oranges = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(oranges));
    }
}
