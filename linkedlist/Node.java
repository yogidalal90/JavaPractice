package linkedlist;

public class Node implements  Comparable{
	public int data;
	public Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	
	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
	
	public Node() {
	}

	/**
	 * 1 --> 2  --> 3 --> 4 --> 6
	 * @return
	 */
	public static Node createLL (){
		Node n5 = new Node(1);
		Node n4 = new Node(9,n5);
		Node n3 = new Node(9,n4);
		Node n2 = new Node(9,n3);
		Node n1 = new Node(9,n2);
	//    n1.next.next.next.next = n1;
		return n1;
		
	}
	
	static void printLL (Node n){
		if(n==null){
			return;
		}
		System.out.print(n.data+" ");
		if(n.next !=null)
			printLL(n.next);
	}

	static void insertElementInBetween(Node n, int ele, Node prev){
		if(n==null && prev == null){
			n = new Node(ele);
			return;
		}
		if(n==null){
			Node temp = new Node();
			temp = prev.next;
			prev.next = new Node(ele, temp);
		}
		if(n.data < ele){
			insertElementInBetween(n.next, ele,n);
		}
		else 
		{
			Node temp = new Node();
			temp = prev.next;
			prev.next = new Node(ele, temp);
		}	
	}

	@Override
	public int compareTo(Object o) {
		Node n = (Node)o;
		if(this.data > n.data)
			return -1;
		if(this.data == n.data)
			return 0;
		return 1;
	}


}