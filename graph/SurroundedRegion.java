package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region
 *
 * X X X X        X X X X
 * X O O X   ==>  X X X X
 * X X O X        X X X X
 * X O X X        X O X X
 *
 */
public class SurroundedRegion {
    private void solve(char[][] board) {
        int n = board.length;
        if(n<1)
            return;
        int m = board[0].length;
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                que.offer(i);que.offer(0);
            }
            if(board[i][m-1]=='O'){
                que.offer(i);que.offer(m-1);
            }
        }
        for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                que.offer(0);que.offer(j);
            }
            if(board[n-1][j]=='O'){
                que.offer(n-1);que.offer(j);
            }
        }

        while(!que.isEmpty()){
            int r = que.poll();
            int c = que.poll();
            board[r][c]='I';
            if(r+1<n && board[r+1][c]=='O')
            {
                que.offer(r+1); que.offer(c);
            }
            if(r>0 && board[r-1][c]=='O')
            {
                que.offer(r-1); que.offer(c);
            }
            if(c+1<m && board[r][c+1]=='O')
            {
                que.offer(r); que.offer(c+1);
            }
            if(c>0 && board[r][c-1]=='O')
            {
                que.offer(r); que.offer(c-1);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='I')
                    board[i][j]='O';
            }
        }

    }

    public static void main(String[] args) {
        char[][] regions = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedRegion surround = new SurroundedRegion();
        surround.solve(regions);
        for(int i=0;i<regions.length;i++){
            for(int j=0;j<regions[0].length;j++) {
                System.out.print(regions[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
