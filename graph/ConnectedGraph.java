package graph;

import sun.awt.image.ImageWatched;

import java.util.*;

public class ConnectedGraph {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n= 5;
        System.out.print(new ConnectedGraph().countComponents(n,edges));

    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        buildGraph(map,edges,n);
        Set<Integer> visited = new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                count++;
                dfs(map,visited,i);
            }
        }
        return count;
    }

    void dfs(Map<Integer, LinkedList<Integer>> map, Set<Integer> visited, int curr){
        visited.add(curr);

        for(Integer nbr:map.get(curr)){
            if(!visited.contains(nbr)){
                dfs(map,visited,nbr);
            }
        }
    }

    void buildGraph(Map<Integer, LinkedList<Integer>> map, int[][] edges, int n){
        for(int i=0;i<n;i++){
            map.put(i,new LinkedList<>());
        }

        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
    }
}
