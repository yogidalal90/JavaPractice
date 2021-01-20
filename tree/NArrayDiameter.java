package tree;

import java.util.*;

public class NArrayDiameter {

    public static void main(String[] args) {
        Node node = new Node(0);
        Node child1 = new Node(1);
        Node child2 = new Node(2);
        Node child3 = new Node(3);
        Node child4 = new Node(4);
        Node child5 = new Node(5);
        Node child6 = new Node(6);
        Node child7 = new Node(7);
        List<Node> ls1 = new ArrayList<>();
        ls1.add(child1);

        ls1.add(child2);
        ls1.add(child3);


        node.children=ls1;
        List<Node> ls2 = new ArrayList<>();
        ls2.add(child4);
        ls2.add(child5);
        child1.children=ls2;
        List<Node> ls3 = new ArrayList<>();
        ls3.add(child6);
        ls3.add(child7);
        child3.children=ls3;
        int serial = new NArrayDiameter().nArrDiameter(node);
        System.out.print(serial);
    }
    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }
    }
    int nArrDiameter(Node n){
        if(n==null)
            return 0;
        int h1 =0;
        int h2 = 0;
        for(Node child:n.children){

            int dep = depth(child);
            if(dep  > h1){
                h2=h1;
                h1=dep;
            }else if(dep>h2){
                h2=dep;
            }
        }
        int maxDia=0;
        for(Node child:n.children){
            maxDia =  Math.max(maxDia,nArrDiameter(child));

        }
        return Math.max(maxDia,h1+h2+1);
    }

    int depth(Node n){
        if(n==null)
            return 0;
        int depth = 0;
        for(Node child:n.children){
            depth  = Math.max(depth,depth(child));
        }
        return depth+1;

    }



}
