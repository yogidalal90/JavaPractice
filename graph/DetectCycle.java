package graph;

import java.util.List;

public class DetectCycle {
    enum Color {WHITE,GREY,BLACK};
    class GraphVertex{

        Color color = Color.WHITE;
        List<GraphVertex> edges;

        public List<GraphVertex> getEdges() {
            return edges;
        }

        public void setEdges(List<GraphVertex> edges) {
            this.edges = edges;
        }
    }
    public boolean isDeadLock(List<GraphVertex> G){

        for(GraphVertex edge:G){
            if(edge.color == Color.WHITE && hasCycle(edge, null));
            return true;
        }
        return false;
    }

    boolean hasCycle(GraphVertex curr, GraphVertex prev){
        if(curr.color  == Color.GREY)
            return true;

        curr.color = Color.GREY;

        for(GraphVertex nbr:curr.getEdges()){

            if(nbr != prev && nbr.color != Color.BLACK){
                if(hasCycle(nbr,curr))
                    return true;
            }
        }
        curr.color = Color.BLACK;
        return false;

    }

}
