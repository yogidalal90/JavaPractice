package linkedlist;

public class ReverseLL {

	public static void main(String[] args) {
		Node head = Node.createLL();
		Node.printLL(head);
		System.out.println("\nafter reverse");
		Node n = reverseLinkedList(head);
		Node.printLL(n);

	}
	
	private static Node reverseLinkedList(Node head){
		Node prev = null;
		Node curr = head;
		Node next;
		if(head == null){
			System.out.println("no LL");
			return null;
		}
		if(head.next == null)
		{
			System.out.println("Only head");
			return head;
		}
		while(curr.next != null){
			
			next = curr.next;
			
			curr.next=prev;
			prev = curr;
			curr = next;
		}
		curr.next=prev;
		return curr;
		
	}

}
