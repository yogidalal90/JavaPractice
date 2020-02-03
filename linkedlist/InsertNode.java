package linkedlist;


/**
 * Insert new node at various positions of a linkedList
 */
public class InsertNode  {
	
	void insertAtHead(Node head, int data){
		Node n = new Node(data);
		if(head == null){
			System.out.println("no LL exist. New LL created");
			n.next = null;
			return;
		}
		n.next = head;
		
	}
	
	void insertAtMid(Node prev, int data){
		if(prev == null){
			System.out.println("Prev cannot be null");
			return;
		}
		Node n = new Node(data);
		n.next = prev.next;
		prev.next = n;
		
	}
	
	void insertAtTail(Node head, int data){
		if(head == null){
			System.out.println("tail cannot be null");
			return;
		}
		Node n = new Node(data);
		n.next = null;
		while(head.next != null){
			head = head.next;
		}
		head.next = n;
		return;
		
	}

}
