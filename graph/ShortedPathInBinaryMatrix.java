package graph;
import java.util.*;
public class ShortedPathInBinaryMatrix {
        int[][] dirs ={{-1,-1},{-1,0},{-1,1},{1,-1},{0,1},{1,0},{0,-1},{1,1}};
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if(grid[0][0] == 1 || grid[n-1][n-1]==1)
                return -1;

            Queue<Integer> que=new LinkedList<>();
            que.offer(0);
            que.offer(0);
            grid[0][0]=1;
            int step=1;
            while(!que.isEmpty()){
                int lth=que.size()/2;
                for(int i=0;i<lth;i++){
                    int row =que.poll();
                    int col = que.poll();
                    if(row==n-1 && col==n-1)
                        return step;

                    for(int[] dir:dirs){
                        if(isValid(row+dir[0],col+dir[1],grid)){
                            int cRow =row+dir[0];
                            int cCol = col+dir[1];
                            que.offer(cRow);
                            que.offer(cCol);
                            grid[cRow][cCol]=1;
                        }
                    }

                }
                step++;
            }
            return -1;
        }
        boolean isValid(int row, int col, int[][] grid){
            int n= grid.length;
            return (row>=0 && row<n && col >=0 && col<n && grid[row][col]==0);
        }
    }

