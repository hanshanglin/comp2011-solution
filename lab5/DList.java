package comp2011.lab5;

public class DList<T> {
    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> previous;
        Node(T a) {
            element = a;
            next = previous = null;
        }
    }

	private Node<T> head; // firstNode
	private Node<T> tail; // lastNode

	public DList() {
        Node<T> head = new Node<T>(null);
        Node<T> tail = new Node<T>(null);
        head.previous = null;
        head.next = tail;
        tail.previous = head;
        tail.next = null;
        this.head = head;
        this.tail = tail;
	}

	public boolean isEmpty() {
        return head.next == tail; 
	}

	public void err() {
		System.out.println("Oops...");
	}
	
	public void insertFirst(T e) {
        Node<T> newNode = new Node<T>(e);
        
        newNode.next = head.next;
        newNode.previous = head;
        head.next.previous = newNode;
        head.next  =newNode;
        
	}
	
    public void insertLast(T e) {
        Node<T> newNode = new Node<T>(e);
        newNode.previous = tail.previous;
        newNode.next = tail;
        tail.previous.next = newNode;
        tail.previous = newNode;
    }


	public T removeFirst() {
        if (isEmpty()) { err(); return null;}
        Node<T> temp = head.next;
	    head.next = head.next.next;
	    head.next.previous = head;
	    
	    temp.previous = null;
	    temp.next = null;
        return temp.element;
	}

	public T removeLast() {
        if (isEmpty()) { err(); return null;}
        Node<T> temp = tail.previous;
        tail.previous = tail.previous.previous;
        tail.previous.next = tail;
        
        temp.next = null;
        temp.previous = null;
        return temp.element;
	}

    public T delete(Node<T> node) {
        
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.previous = node.next = null;
        return node.element;
    }
    
    public DList<T> merge(DList<T> l1,DList<T> l2){
    	DList<T> sol = new DList<T>();
    	sol.head = l1.head;
    	sol.tail = l2.tail;
    	l1.tail.previous.next = l2.head.next;
    	l2.head.next.previous = l1.tail.previous;
    	return sol;
    }

	public String toString() {
        if (isEmpty()) return "The list is empty.";
        StringBuilder sb = new StringBuilder();
        Node<T> cur = head.next;
        while ( cur != tail ) {
            sb.append(" - Previous: " + (cur.previous == null ? " Null " : cur.previous.element) + "\n");
            sb.append("    Current: " + cur.element + "\n");
            cur = cur.next;
        }
        return sb.toString();
    }
	
	// There is a bug! Please fix it and post on the forum.
	public void reversev1() {
	    if (head.next == tail || head.next == tail.previous) return;
	    
        Node<T> curr = head;
	    while (curr != tail) {
	        Node<T> temp = curr.next;
	        curr.next = curr.previous;
	        curr.previous = temp;
	        curr = temp;
	    }
	    tail.next = tail.previous;
	    tail.previous = null;
	    curr = head;
	    head = tail;
	    tail = curr;
	}
	
	public void reversev2() {
		if (head.next == tail || head.next == tail.previous) return;
		reverse(head);
		
		Node<T> temp = tail;
		tail=head;
		head = temp;
		
	}
	private void reverse(Node<T> curr) {
		if (curr == null) return;
		Node<T> temp = curr.next;
		curr.next = curr.previous;
		curr.previous = temp;
		reverse(temp);
	}
	
    
    public static void main(String[] args) {
        DList<String> list = new DList<String>();
        list.insertFirst("Shenzhen");
        list.insertFirst("Hong Kong");
        list.insertLast("Guangzhou");
        System.out.println(list);
        list.insertLast("Changsha");
        list.insertLast("Wuhan");
        list.insertLast("Zhengzhou");
        list.insertLast("Beijing");
        list.insertLast("Shenyang");
        System.out.println(list);
        System.out.println("delete the last, which is " + list.removeLast());
		System.out.println(list);
        list.reversev1();
        System.out.println("after reversion, it becomes \n" + list);
        list.reversev2();
        System.out.println("after reversion again, it becomes \n " + list);
    }
}
