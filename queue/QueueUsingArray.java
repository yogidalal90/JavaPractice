package queue;

public class QueueUsingArray {

	int arr[];
	int front;
	int rear;
	int size;
	int capacity;
	
	QueueUsingArray(int capacity){
		this.capacity = capacity;
		this.arr = new int[capacity];
		this.front = size = 0;
		this.rear = capacity-1;
	}
	
	boolean isFull(QueueUsingArray q){
		return (q.size == this.capacity);
	}
	
	boolean isEmpty(QueueUsingArray q){
		return (q.size == 0);
	}
	
	int front(){
		if(isEmpty(this))
			return Integer.MIN_VALUE;
		return this.arr[this.front];
	}
	
	int rear(){
		if(isEmpty(this))
			return Integer.MIN_VALUE;
		return this.arr[this.rear];
	}
	
	/**
	 * Update rear and size
	 * @param data
	 */
	void enqueue(int data){
		if(isFull(this)){
			System.out.println("queue is full");
			return;
		}
		this.rear = (this.rear+1)%capacity;
		this.arr[this.rear] = data;
		this.size = this.size +1;
		
	}
	
	int dequeue(){

		 if (isEmpty(this)) {
		 	System.out.print("Queue is Empty - Returning Integer.MIN_VALUE: ");
			 return Integer.MIN_VALUE;
		 }
		 int data = this.arr[this.front];
		 this.front = (this.front+1)%capacity;
		 this.size = this.size-1;
		return data;
	}
	
	public static void main(String[] args) {
		QueueUsingArray q = new QueueUsingArray(15);
		System.out.println("Enqueued item is 1");q.enqueue(1);
		System.out.println("Enqueued item is 2");q.enqueue(2);
		System.out.println("Enqueued item is 3");q.enqueue(3);
		System.out.println("Enqueued item is 4");q.enqueue(4);
		System.out.println("Enqueued item is 6");q.enqueue(6);
		System.out.println("Dequeued item is "+q.dequeue());
		System.out.println("Dequeued item is "+q.dequeue());
		System.out.println("Dequeued item is "+q.dequeue());
		System.out.println("Dequeued item is "+q.dequeue());
		System.out.println("Dequeued item is "+q.dequeue());
		System.out.println("Dequeued item is "+q.dequeue());

	}
}
