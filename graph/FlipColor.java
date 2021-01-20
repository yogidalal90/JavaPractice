package graph;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class FlipColor {

    class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object c){
            if(this == c)
                return true;
            if(c==null || c.getClass() != this.getClass())
                return false;
            MazePath.Coordinate cord = (MazePath.Coordinate)c;
            if(cord.x != this.x || cord.y != this.y)
                return false;
            return true;
        }
        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
    }
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    public void flipColor(boolean [][] maze, int x, int y){

        boolean color= maze[x][y];
        Queue<Coordinate> que = new LinkedList<>();
        Coordinate curr = new Coordinate(x,y);
        que.offer(curr);
        maze[x][y] = !color;
        while(!que.isEmpty()){
            int n = que.size();
            for(int i=0;i<n;i++){
                Coordinate cord = que.poll();

                for(int[] dir:dirs){
                    int nextx = cord.x+dir[0];
                    int nexty= cord.y+dir[1];
                    // need to add this method
                    if(isValid(nextx,nexty,maze,color)){
                        que.offer(new Coordinate(nextx,nexty));
                        maze[nextx][nexty]=!color;
                    }
                }
            }
        }
    }

    boolean isValid(int x, int y, boolean[][] maze, boolean color){
        return (x>=0 && x<maze.length && y >=0 && y<maze[0].length && maze[x][y] ==color);


    }

}
