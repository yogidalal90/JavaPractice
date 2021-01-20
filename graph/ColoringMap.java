package graph;

public class ColoringMap {
    public static void main(String[] args) {
        int[][] grid = { {2,1,1}
                        ,{1,2,1},
                         {1,1,1}};
        int count = new ColoringMap().coloringMap(grid);
        System.out.print(count);
    }
    int coloringMap(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] !=0){
                    count++;
                    dfs(grid,i,j,grid[i][j]);
                }
            }
        }
        return count;
    }

    void dfs(int[][] grid, int i, int j, int color){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] != color)
            return;
        grid[i][j]=0;
        dfs(grid,i+1,j,color);
        dfs(grid,i-1,j,color);
        dfs(grid,i,j+1,color);
        dfs(grid,i,j-1,color);
    }

}
