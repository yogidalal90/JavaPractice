package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDirectedGraph {
    boolean[] visited;
    public int solve(int A, int[][] B) {

        Map<Integer,List<Integer>> map = new HashMap<>();
        int n = B.length;
        for(int i=0;i<n;i++){
            List<Integer> ls = map.getOrDefault(B[i][0],new ArrayList<>());
            ls.add(B[i][1]);
            map.put(B[i][0],ls);
        }

        for(int i=1;i<=A;i++){
            visited = new boolean[A+1];
            if(dfs(i,map)==1)
                return 1;
        }
        return 0;
    }

    int dfs(int i, Map<Integer,List<Integer>> map ){
        if(visited[i]){
            return 1;
        }
        visited[i]=true;

        List<Integer> nbr = map.get(i);
        if(nbr == null){
            visited[i]=false;
            return 0;
        }
        for(int n:nbr){
            if(dfs(n,map) == 1){
                return 1;
            }
        }
        visited[i]=false;
        return 0;
    }
}
