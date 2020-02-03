package queue;

public class Queue {
        int[] queue = new int[12];
        int rear=-1, front=-1;
        int capacity = queue.length;
    public static void main(String[] args) {
        Queue u =new Queue();
        u.printQueue(u.queue);
        u.insert(1);
        u.insert(2);
        u.insert(3);
        u.remove();
        u.remove();
        u.remove();
        u.remove();
        u.insert(3);

    }

    void printQueue(int[] queue){
        for(int i=0;i<queue.length;i++){
            System.out.print(queue[i]+" ");
        }
    }
    public void insert(int item){
        if(isFull()){
            System.out.println("queue is full");
            return;
        }
        if(isEmpty()){
            front++;
        }
        this.rear = (this.rear+1)%capacity;
        System.out.println("inserted: "+item +" at "+rear);
        queue[rear] =item;
        System.out.println("Print queue");
        printQueue(queue);
    }

    public void remove(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return;
        }
        if(front == rear){
            System.out.print("removed: "+queue[front]+" from "+ front);
            queue[front] =0;
            front = -1;
            rear = -1;
            System.out.println();
            printQueue(queue);
            return ;

        }
        System.out.print("removed: "+queue[front]+" from "+ front);
        queue[front] =0;
        this.front = (this.front+1)%capacity;
        System.out.println();
        printQueue(queue);

    }

    public boolean isFull(){
        System.out.println("rear: "+rear + " front: "+front);
        // i.e. if front is 1 cell ahead of rear
        if((rear+1)% queue.length ==front) {
            printQueue(queue);
            return true;
        }
        return  false;
    }

    public boolean isEmpty(){
        if(front == -1)
            return true;
        return false;
    }
}
