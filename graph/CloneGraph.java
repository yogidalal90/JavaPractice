package graph;

import java.util.*;

public class CloneGraph {

    class Graphvertex{
        int label;
        List<Graphvertex> edges;

        public Graphvertex(int label) {
            this.label = label ;
            edges = new ArrayList <>();
        }

    }


    Graphvertex cloneGraph(Graphvertex g){
        if(g== null)
            return null;
        Queue<Graphvertex> que = new LinkedList<>();
        Graphvertex  clone = new Graphvertex(g.label);
        Map<Graphvertex,Graphvertex> map = new HashMap<>();
        que.offer(g);
        map.put(g,clone);
        while(!que.isEmpty()){

            Graphvertex graph = que.poll();
            Graphvertex  cloned = map.get(graph);
            for(Graphvertex edge:graph.edges){
                if(!map.containsKey(edge)){
                    map.put(edge,new Graphvertex(edge.label));
                    que.offer(edge);
                }
                cloned.edges.add(map.get(edge));
            }
        }
        return map.get(g);
    }

}
