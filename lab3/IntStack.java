package comp2011.lab3;

public class IntStack {

	private static final int CAPACITY = 128;
	private int[] data;
    private int top;
    
    public IntStack() {
    	this.data = new int[CAPACITY];
    	this.top = 0;
    }
    
    public int gettop() {
    	return top;
    }
    public void push(int element) {
    	data[top++] = element;

    }
    
    public int pop() {
    	if(isEmpty()) return -1;
    	return data[--top];
    }
    
    public int peep() {
    	if(isEmpty()) return -1;
    	return data[top-1];
    }
    
    public boolean isEmpty() {
    	return top==0;
    }
    
    public String toString() {
    	return new String(data, 0, top);
    	// or
    	// (new String(data)).substring(0, top);
    }


}
