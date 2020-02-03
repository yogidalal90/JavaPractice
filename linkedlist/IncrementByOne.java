package linkedlist;

/**
 * Add one to the data in last node.
 * 1 --> 2  --> 3 --> 4 --> 6
 */
public class IncrementByOne {

    public static void main(String[] args) {
        Node head = Node.createLL();
        Node.printLL(head);
        incrementLL(head);
    }
   private static void incrementLL (Node head) {
        Node nonNine=head;
        Node nine = head;
        Node curr = head;
        if(curr == null ) {
            System.out.println("No elements in the node");
        }
        while(curr != null) {
            if(curr.data == 9) {
                if(nine.data != 9)
                    nine = curr;
            } else {
                nine = curr;
                nonNine = curr;
            }
            curr = curr.next;
        }
        if(nonNine != null )
        {
            if(nonNine.data == 9 )
            {

                Node n = new Node(1);
                n.next = head;
                head= n;
            } else {
                nonNine.data += 1;
            }
        }
        if(nine != null && nine.data == 9) {
            while(nine != null) {
                nine.data=0;
                nine = nine.next;
            }
        }
       System.out.println("");
        Node.printLL(head);
    }

}
