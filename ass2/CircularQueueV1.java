package comp2011.ass2;

// In this version, we try to mimic the physical setting of a queue.
// I.e., when there is only one element, it is both front and rear.
public class CircularQueueV1<T> {
    private static final int CAPACITY = 128;
    private T[] data;
    private int front, rear;

    @SuppressWarnings("unchecked")
	public CircularQueueV1() {
        data = (T[]) new Object[CAPACITY];
        front = 0;
        rear = -1;
        
    }

    public boolean isEmpty() {
    	return front == (rear+1)%CAPACITY;
    }

    // it's not physically full
    // but we cannot add more elements
    public boolean isFull() {
    	return front == (rear+2)%CAPACITY;
    }

    public void enqueue(T e) {
    	if (this.isFull()) {
    		System.out.println("queue is full");
    		System.exit(0);
    	}
    	this.rear = (this.rear+1)%CAPACITY;
    	this.data[rear] = e;
    }

    public T dequeue() {
    	if(this.isEmpty()) {
    		System.out.println("queue is empty");
    		System.exit(0);
    	}
    	T temp = this.data[front];
    	front = (front+1)%CAPACITY;
    	return temp;
    }

    public int size() {
    	return (this.rear-this.front+1+CAPACITY)%CAPACITY;
    }

    public String toString() {
    	String s = "";
    	for(int i = front;i<rear+CAPACITY+1;++i) {
    		s = s+" "+String.valueOf(data[i%CAPACITY]);
    	}
    	return s;
    }

    public static void main(String[] args) {
        CircularQueueV1<Integer> queue = new CircularQueueV1<Integer>();
        for (int i = 1; i <= 7; i++)
            queue.enqueue(i * 100);
        for (int i = 0; i < 5; i++)
            System.out.println(queue.dequeue());
        for (int i = 1; i <= 5; i++)
            queue.enqueue(i * 100);
        System.out.println("size = " + queue.size());
        for (int i = 0; i < 7; i++)
            System.out.println(queue.dequeue());
        System.out.println("size = " + queue.size());
    }
}
