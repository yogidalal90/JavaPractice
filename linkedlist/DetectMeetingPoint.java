package linkedlist;

/**
 * Detect meeting point of two linkedLists
 */
public class DetectMeetingPoint {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node h1 = new Node(4);
        Node h2 = new Node(5);
        Node p1 = new Node(6);
        Node p2 = new Node(7);
        Node p3 = new Node(8);
        n1.next = n2;
        n2.next = n3;
        n3.next=p1;
        p1.next =p2;
        p2.next = p3;
        h1.next=h2;
        h2.next=p1;
        Node n = detectMeetingPt(n1,h1);
        if(n!= null)
            System.out.println(n.data);
        else
            System.out.println("null");
    }

    private static Node detectMeetingPt(Node n1, Node h1){
        if(n1 == null || h1 == null)
            return null;
        Node head1 = n1;
        Node head2 = h1;
        int countN =1;
        int countH = 1;
        while(n1.next!=null || h1.next != null){
            if(n1.next!=null){
                countN++;
                n1 = n1.next;
            }
            if(h1.next!=null){
                countH++;
                h1 =h1.next;
            }
        }
        int diff = countH-countN;

        while(diff != 0){
            if(diff < 0){
                head1 = head1.next;
                diff++;
            } else {
                head2=head2.next;
                diff--;
            }
        }

        Node meetingNode = null;
        while(head1 != head2){
            head1 = head1.next;
            head2= head2.next;
            meetingNode = head1;
        }
        return meetingNode;
    }

}
