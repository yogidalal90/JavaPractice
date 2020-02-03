package queue;

import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> inStack = new Stack<Integer>();
	Stack<Integer> outStack = new Stack<Integer>();
	
	void push(Stack<Integer> s, int data){
		s.push(data);
	}
	
	int pop(Stack<Integer> s){
		return s.pop();
	}

	Stack<Integer> copyStack(Stack<Integer> s1 ,Stack<Integer> s2){
		if(s1 == null || s2 == null){
			return null;
		}
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		return s2;
	}

	boolean emptyStacks(){
		if(inStack.isEmpty() && outStack.isEmpty()){
			return  true;
		}
		return  false;
	}

	int dequeue(){
		if(emptyStacks()) {
			System.out.println("empty stack");
			return Integer.MIN_VALUE;
		}
			if(!inStack.isEmpty()){
				outStack = copyStack(inStack,outStack);
			}
		return outStack.pop();
	}
	void enqueue(int data){
		if(!emptyStacks()) {
			if (!outStack.isEmpty()) {
				inStack = copyStack(outStack, inStack);
			}
		}
		inStack.push(data);
	}
	public static final void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		System.out.println("enqueue: 1 ");queue.enqueue(1);
		System.out.println("enqueue: 9 ");queue.enqueue(9);
		System.out.println("enqueue: 3 ");queue.enqueue(3);
		System.out.println("enqueue: 4 ");queue.enqueue(4);
		System.out.println("dequeue: "+queue.dequeue());
		System.out.println("dequeue: "+queue.dequeue());
		System.out.println("dequeue: "+queue.dequeue());
		System.out.println("dequeue: "+queue.dequeue());

	}
	
}

