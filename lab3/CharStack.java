package comp2011.lab3;

public class CharStack {
	private static final int CAPACITY = 128;
	private char[] data;
    private int top;
    
    public CharStack() {
    	this.data = new char[CAPACITY];
    	this.top = 0;
    }
    
    public int gettop() {
    	return top;
    }
    public void push(char element) {
    	data[top++] = element;

    }
    
    public char pop() {
    	if(isEmpty()) return ' ';
    	return data[--top];
    }
    
    public char peep() {
    	if(isEmpty()) return '0';
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
