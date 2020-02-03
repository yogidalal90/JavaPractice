package linkedlist;

public class FloydDetectLoop {
	
	private static Node meetingPoint(Node p, Node q){
		
		if(p==null || q==null)
		{
			System.out.println("no loop");
			return null;
		}
		
		while( q!=null && p.next!=null ){
			
			q=q.next;
			p = p.next.next;
			if(p==q){
				System.out.println("found loop");
				return p;
			}
				
		}
		return null;
	}
	
	static Node detectLoop(Node q, Node p){
		if(p==null || q== null){
			System.out.println("no loop");
			return null;
		}
		while(p!=q && p.next!=null && q.next != null){
			p=p.next;
			q = q.next;
		}
		return p;
	}
	public static void main(String[] args) {
		Node head = Node.createLL();
		Node p = meetingPoint(head,head);
		if(p==null)
			System.out.println("no loop");
		else
			System.out.println(detectLoop(head,p).data);
		
	}

}
