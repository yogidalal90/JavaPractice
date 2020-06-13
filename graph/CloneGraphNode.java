package graph;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */

class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraphNode {
        private static Node cloneGraph(Node node) {

            if(node == null) return null;

            HashMap<Integer,Node> visited = new HashMap<>();

            Queue<Node> que = new LinkedList<>();

            Node finalNode = new Node(node.val);
            visited.put(node.val,finalNode);

            que.offer(node);

            while(!que.isEmpty()){
                Node qnode = que.poll();

                for(Node nbr:qnode.neighbors){
                    if(!visited.containsKey(nbr.val)){
                        Node n = new Node(nbr.val);
                        visited.put(nbr.val,n);

                        que.offer(nbr);
                    }
                    visited.get(qnode.val).neighbors.add(visited.get(nbr.val));
                }
            }
            return finalNode;
        }
}