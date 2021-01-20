package tree;

import java.util.*;
public class SerializeNArr {

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
        String serial = new SerializeNArr().serialize(node);
        System.out.print(serial);
        Node root = new SerializeNArr().deserialize(serial);
        System.out.print(root.val);
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

    public String serialize(Node root){

        if(root==null)
            return "";

        StringBuilder sb = new StringBuilder();
        serial(root,sb);
        return sb.toString();
    }

    public void serial(Node root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return ;
        }
        sb.append(root.val+",");
        if(root.children != null){
            sb.append(root.children.size()+",");
            for(Node c:root.children){
                serial(c,sb);
            }
        }
    }

    public Node deserialize(String str){
        if(str.isEmpty())
            return null;
        String[] s = str.split(",");
        Queue<String> que = new LinkedList<>(Arrays.asList(s));
       return buildTree(que);
    }

    Node buildTree(Queue<String> que){
        String val  = que.poll();
        if(val.equals("#"))
        {
            return null;
        }

        Node node = new Node(Integer.parseInt(val));
        int n= Integer.parseInt(que.poll());
        node.children =new ArrayList<>();
        for(int i=0;i<n;i++){
            node.children.add(buildTree(que));
        }
        return node;
    }

}
