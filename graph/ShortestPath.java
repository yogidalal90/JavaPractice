package graph;

import java.util.*;

public class ShortestPath {
    class Vertex {
        int data;
        List<Vertex> edges;
    }

    List<Vertex> findPath(Vertex start, Vertex end){

        Queue<Vertex> que = new LinkedList<>();
        Map<Vertex,Vertex> map = new HashMap<>();

        que.offer(start);
        map.put(start,null);
        while(!que.isEmpty()){
            Vertex  curr = que.poll();
            if(curr==end) break;
            for(Vertex v:curr.edges){
                if(!map.containsKey(v)){
                    map.put(v,curr);
                    que.offer(v);
                }
            }
        }

        if(!map.containsKey(end)) return null;
        List<Vertex> res = new LinkedList<>();
        Vertex curr = end;
        while(curr != null){
            res.add(0,curr);
            curr = map.get(curr);
        }
        return res;
    }

}
