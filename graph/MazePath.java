package graph;


import java.util.*;

public class MazePath {

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
            Coordinate cord = (Coordinate)c;
            if(cord.x != this.x || cord.y != this.y)
                return false;
            return true;
        }
        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
    }
    enum Color{
        WHITE, BLACK;
    }
    public List<Coordinate> searchMaze(Color[][] maze, Coordinate start, Coordinate dest){
        List<Coordinate> path = new ArrayList<>();
        if(start.equals(dest))
            return path;

        path.add(start);
        if(!pathExists(maze,start,dest,path))
        {
            path.remove(path.size()-1);
        }
        return path;

    }

    boolean pathExists(Color[][] maze, Coordinate start, Coordinate end, List<Coordinate> path){
        if(start.equals(end))
            return true;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:dirs){
            Coordinate next = new Coordinate(start.x+dir[0], start.y+dir[1]);
            if(!isInvalidDirection(next,maze)){
                maze[next.x][next.y]=Color.BLACK;
                path.add(next);
                if(pathExists(maze,next,end,path)){
                    return true;
                }
                path.remove(path.size()-1);
            }

        }
        return false;
    }

    boolean isInvalidDirection(Coordinate cord, Color[][] maze){
        int x = cord.x;
        int y = cord.y;
        return x<0 || x>=maze.length || y<0 || y>=maze[0].length || maze[x][y]== Color.BLACK;
    }
}
