package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge K number of linkedLists into one.
 */
public class MergeKListsLogic {

    public static void main(String[] args) {
        //1,2,5,6
        Node n1 = new Node(6);
        Node n2 = new Node(5, n1);
        Node n5 = new Node(2, n2);
        Node n6 = new Node(1, n5);
        //2,3,4,
        Node n7 = new Node(4);
        Node n3 = new Node(3, n7);
        Node n4 = new Node(2, n3);
        //4,7,8
        Node n8 = new Node(8);
        Node n9 = new Node(7, n8);
        Node n10 = new Node(4, n9);

        List<Node> ls = new ArrayList<>();
        ls.add(n6);
        ls.add(n4);
        ls.add(n10);

        Node finalList = mergeKLists(ls);

    }


    private static Node mergeKLists(List<Node> ls) {
        Node finalNode = null;
        if (ls == null || ls.isEmpty())
            return null;


        for (int i = 0; i < ls.size(); i++) {
            finalNode =  mergeTwoLists(finalNode, ls.get(i));
            System.out.println("\niteration: "+i);
            Node.printLL(finalNode);
        }
        return finalNode;
    }

    private static Node mergeTwoLists(Node n1, Node n2) {
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;
        Node finalNode = null;
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                finalNode = insertNodeAtEnd(finalNode, n1.data);
                n1 = n1.next;
            } else if (n1.data > n2.data) {
                finalNode = insertNodeAtEnd(finalNode, n2.data);
                n2 = n2.next;
            } else {
                finalNode = insertNodeAtEnd(finalNode, n2.data);
                finalNode = insertNodeAtEnd(finalNode, n1.data);
                n1 = n1.next;
                n2 = n2.next;
            }
        }
        if (n1 == null) {
            finalNode = insertListAtEnd(finalNode, n2);
        }
        if (n2 == null) {
            finalNode = insertListAtEnd(finalNode, n1);
        }
        return finalNode;
    }

    private static Node insertListAtEnd(Node head,Node n){
       Node curr = head;
        if(head == null){
            curr = n;
        } else {
            while(head.next != null){
                head = head.next;
            }
            head.next = n;

        }
        return curr;
    }
    private static Node insertNodeAtEnd(Node head, int data) {
        Node curr = head;
        if (head == null) {
            head = new Node(data);
            curr = head;
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = new Node(data);
        }
        return curr;
    }
}
