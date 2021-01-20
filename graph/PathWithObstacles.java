package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PathWithObstacles {

    public static void main(String[] args) {
        int[][] oranges = {
                {0,0,0},
                {0,1,1},
                {0,0,0}};
        System.out.println(shortestPaths(oranges,1));
    }
        public static int shortestPath(int[][] grid, int k) {
            int n = grid.length;
            int m = grid[0].length;

            int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

            Set<String> visited= new HashSet<>();
            Queue<int[]> que= new LinkedList<>();
            int steps = 0;
            que.offer(new int[]{0,0,0});
            visited.add("0_0_0");
            grid[0][0] = 2;

            while(!que.isEmpty()){
                int size= que.size();
                for(int i=0;i<size;i++) {
                    int[] itm = que.poll();
                    if(itm[0] == grid.length-1 && itm[1] == grid[0].length-1){
                        return steps;
                    }
                    int r = itm[0];
                    int c = itm[1];
                    int curK = itm[2];

                    for (int[] d : dir) {
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || (grid[nr][nc] ==1 && curK == k))
                            continue;
                        String str = nr + "_" + nc + "_" + curK;
                        if (visited.contains(str))
                            continue;
                        else{
                            visited.add(str);
                            int newK = grid[nr][nc] == 1?curK+1:curK;
                            que.offer(new int[]{r, c, newK});
                        }
                    }

                }
                steps++;

            }
            return -1;
        }

    public static int shortestPaths(int[][] grid, int k) {

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        if(grid.length == 0)
            return -1;
        Queue<int[]> queue = new LinkedList<>();
        int steps = 0;
        grid[0][0] = 2;
        queue.add(new int[]{0,0,0});
        HashSet<String> visited = new HashSet<>();
        visited.add("0_0_0");
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){

                int[] itm = queue.poll();
                if(itm[0] == grid.length-1 && itm[1] == grid[0].length-1){
                    return steps;
                }
                int r = itm[0];
                int c = itm[1];
                int curK = itm[2];

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length||
                            (grid[nr][nc] == 1 && curK == k))
                        continue;
                    String key = nr +"_"+nc+"_"+curK;
                    if(visited.contains(key)){
                        continue;
                    }else{
                        visited.add(key);
                        int newK = grid[nr][nc] == 1 ? curK+1 : curK;
                        queue.add(new int[]{nr,nc,newK});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}

