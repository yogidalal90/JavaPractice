package linkedlist;

import java.util.HashSet;

/**
 * Detect loop in a LinkedList using Hashset
 */
public class DetectLoopWithSet {
	public static void main(String[] args) {
		Node head = Node.createLL();
		if(head == null){
			System.out.println("no loop");
			return;
		}
		HashSet<Node> s = new HashSet<>();
		s.add(head);
		while(head !=null){
			head = head.next;
			if(s.contains(head)){
				System.out.println("loop detected "+head.data);
				return;
			}
			s.add(head);
			
		}
		System.out.println("no loop");
	}

}
