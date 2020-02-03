package queue;

import tree.TreeNode;

public class QueueUsingLLForTree extends NodeWithTreeData {

	NodeWithTreeData front;
	NodeWithTreeData rear;

	public  QueueUsingLLForTree(){
		this.front = null;
		this.rear = null;
	}

	public void enqueue(TreeNode data){
		NodeWithTreeData newNode = new NodeWithTreeData(data);
		if(this.front == null){
			this.front = newNode;
			this.rear = newNode;
		}
		else{
			
			this.rear.next = newNode;
			this.rear = newNode;
		}
	}

	public boolean isEmpty(){
		if(this.front == null){
			System.out.println("empty queue");
			return  true;
		}
		return false;
	}
	public TreeNode dequeue(){
		if(isEmpty()){
			return  null;
		}
		TreeNode data = this.front.data;
		this.front = this.front.next;
		if(this.front == null)
			this.rear=null;
		System.out.println("Dequeued item is "+data.data);
		return data;
		
		
	}
	
	public static void main(String[] args) {
		QueueUsingLLForTree q=new QueueUsingLLForTree();
		System.out.println("Enqueued item is 10");q.enqueue(new TreeNode(10));
		System.out.println("Enqueued item is 20");q.enqueue(new TreeNode(20));
		q.dequeue();
		q.dequeue();
		System.out.println("Enqueued item is 30");q.enqueue(new TreeNode(30));
		System.out.println("Enqueued item is 40");q.enqueue(new TreeNode(40));
		System.out.println("Enqueued item is 50");q.enqueue(new TreeNode(50));
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
	}
	

}

