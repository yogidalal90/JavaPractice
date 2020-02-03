package queue;

import linkedlist.Node;

public class QueueUsingLL extends Node{

	Node front;
	Node rear;
	
	QueueUsingLL(){
		this.front = null;
		this.rear = null;
	}
	
	public void enqueue(int data){
		Node newNode = new Node(data);
		if(this.front == null){
			this.front = newNode;
			this.rear = newNode;
		}
		else{
			
			this.rear.next = newNode;
			this.rear = newNode;
		}
	}

	public int dequeue(){
		if(this.front == null){
			System.out.println("empty queue");
			return Integer.MIN_VALUE;
		}
		int data = this.front.data;
		this.front = this.front.next;
		if(this.front == null)
			this.rear=null;
		return data;
		
		
	}
	
	public static void main(String[] args) {
		QueueUsingLL q=new QueueUsingLL();
		System.out.println("Enqueued item is 10"); q.enqueue(10);
		System.out.println("Enqueued item is 20");q.enqueue(20);
		System.out.println("Dequeued item is "+ q.dequeue());
		System.out.println("Dequeued item is "+ q.dequeue());
		System.out.println("Enqueued item is 30");q.enqueue(30);
		System.out.println("Enqueued item is 40");q.enqueue(40);
		System.out.println("Enqueued item is 50");q.enqueue(50);
		System.out.println("Dequeued item is "+ q.dequeue());
		System.out.println("Dequeued item is "+ q.dequeue());
		System.out.println("Dequeued item is "+ q.dequeue());
        System.out.println("Dequeued item is "+ q.dequeue());
	}
	

}

