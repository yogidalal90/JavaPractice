package graph;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    Map<Long, Node> map = new HashMap<>();
    static class Node{
        long data;
        Node parent;
        int rank;

        public Node(long data){
            this.data = data;
            this.parent = null;
            this.rank=0;
        }
    }

    private void makeSet(long data){
        Node node = new Node(data);
        node.parent = node;
        map.put(data,node);
    }

    private Node findParent(Node node){
        Node parent = node.parent;
        if(parent == node){
            return parent;
        }
        node.parent = findParent(parent);
        return node.parent;
    }

    private void union(long data1, long data2){
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findParent(node1);
        Node parent2 = findParent(node2);

        if(parent1.rank >= parent2.rank){
            parent1.rank = (parent1.rank==parent2.rank)?parent1.rank+1:parent1.rank;
            parent2.parent=parent1;
        }else{
            parent1.parent = parent2;
        }
    }

    private long findSet(long data){
        return findParent(map.get(data)).data;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        uf.makeSet(1);
        uf.makeSet(2);
        uf.makeSet(3);
        uf.makeSet(4);
        uf.makeSet(5);
        uf.makeSet(6);
        uf.makeSet(7);

        uf.union(1,2);
        uf.union(3,4);
        uf.union(4,5);
        uf.union(6,7);
        uf.union(6,3);
        uf.union(5,2);

        System.out.println(uf.findSet(3));
        System.out.println(uf.findSet(2));
        System.out.println(uf.findSet(4));
        System.out.println(uf.findSet(7));


    }
}
