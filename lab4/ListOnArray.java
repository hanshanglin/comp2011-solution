package comp2011.lab4;



public class ListOnArray {
	private int[] data;
	private static final int SIZE = 128; // it needs to be even.
	
	
	public ListOnArray() {
		data = new int[SIZE];
		data[0]=0;
		data[SIZE-1]=1;
		for(int i = 1;i<SIZE-1;i+=2) {
			data[i+1] = i+2;
		}
		data[SIZE-1]=1;
	}

	public boolean isEmpty() {
		return data[0]==0;
	}

	public boolean isFull() {
		return data[SIZE-1]==0;
	}

	public void err() {
		System.out.println("Oops...");
	}

	public void insertAtFront(int x) {
		if(isFull()) {
			err();
			return;
		}
		int pos = data[SIZE-1];
		data[pos] = x;
		data[SIZE-1] = data[pos+1];
		data[pos+1] = data[0];
		data[0]=pos;	
	}

	public void insertAtTail(int x) {
		if(isEmpty()) {
			insertAtFront(x);
			return;
		}
		if(isFull()) {
			err();
			return;
		}
		int currTail = data[0];
		while(data[currTail+1]!=0) {
			currTail=data[currTail+1];
		}
		int pos = data[SIZE-1];
		data[pos] = x;
		data[SIZE-1] = data[pos+1];
		data[pos+1]=0;
		data[currTail+1]=pos;
	}

	public int deleteFirst() {
		if(isEmpty()) {
			err();
			return -1;
		}
		int pos = data[0];
		data[0] = data[pos+1];
		data[pos+1] = data[SIZE-1];
		data[SIZE-1]=pos;
		return data[pos];
	}

	public int deleteLast() {
		if(isEmpty()) {
			err();
			return -1;
		}
		int pos = data[0];
		if(data[pos+1]==0) {
			return deleteFirst();
		}
		while(data[data[pos+1]+1]!=0) {
			pos = data[pos+1];
		}
		int temp = data[pos+1];
		data[pos+1]=0;
		data[temp+1]=data[SIZE-1];
		data[SIZE-1] = temp;
        return data[temp];
	}

	// this method should print out the numbers in the list in order
	// for example, after the demonstration, it should be "75, 85, 38, 49"
	public String toString() {
		if (isEmpty()) return "List is Empty!";
		
		String s = "";
		int pos = data[0];
		while(data[pos+1]!=0) {
			s = s+String.valueOf(data[pos])+", ";
			pos = data[pos+1];
		}
		s = s+String.valueOf(data[pos]);
		return s;
	}

	public static void main(String[] args) {
		ListOnArray list = new ListOnArray();
		System.out.println(list);
		list.insertAtFront(75);
		list.insertAtFront(99);
		list.insertAtTail(85);
		list.insertAtTail(38);
		System.out.println(list);
		list.deleteFirst();
		System.out.println(list);
		list.insertAtTail(49);
		System.out.println(list);
	}
}
