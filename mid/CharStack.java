package comp2011.mid;

public class CharStack {
	private node[] data;
	private int top;
	class node{
		public char c;
		public int num;
		boolean changed;
		node(char c, int num){
			this.c = c;
			this.num = num;
			changed = false;
		}
	}
	
	
	public CharStack() {
		data = new node[16];
		top = -1;
	}
	
	public void push(char c) {
		node a = new node(c,0);
		data[++top] = a;
	}
	
	public node pop() {
		if(isEmpty()) System.out.println("Hey, I'm still empty");
		return data[top--];
	}
	
	public char peektype() {
		if(isEmpty()) System.out.println("Hey, I'm still empty");
		return data[top].c;
	}
	public int peekNum() {
		if(isEmpty()) System.out.println("Hey, I'm still empty");
		return data[top].num;
	}
	public void add() {
		data[top].num++;
	}
	public void min() {
		data[top].num--;
	}
	public void change() {
		data[top].changed = true;
	}
	public boolean ischanged() {
		return data[top].changed;
	}
	
	public boolean isEmpty() {
		return top < 0;
	}

	
	
}
