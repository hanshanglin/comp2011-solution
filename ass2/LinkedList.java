package comp2011.ass2;

import comp2011.lec4.Stack;

public class LinkedList<T> {
	static class Node<T> {
		T element;
		Node<T> next;
		
		public Node(T a) {
			element = a;
			next = null;
		}
	}

	Node<T> head;
	
	public LinkedList() {
		head = null;
	}
	
	public void insertFirst(T a) {
		Node<T> newNode = new Node<T>(a);
		newNode.next = head;
		head = newNode;
	} 
	
	// Warning: please don't try to find the merge point 
	// by searching the element 55; it may be any number.
    public Node<T> mergePoint(LinkedList<T> l2) {
    	if(this.head.next == null && l2.head.next == null)return null;
    	int l1size = 0;
    	int l2size = 0;
    	Node<T> l1curr = this.head;
    	Node<T> l2curr = l2.head;
    	while(l1curr.next!=null) {
    		l1curr = l1curr.next;
    		l1size = l1size+1;
    	}
    	while(l2curr.next!=null) {
    		l2curr = l2curr.next;
    		l2size = l2size+1;
    	}
    	if(l1curr!=l2curr)return null;
    	l1curr = this.head;
    	l2curr = l2.head;
    	if(l1size>l2size) {
    		for(int i  = l1size-l2size;i>0;--i) {
    			l1curr = l1curr.next;
    		}
    	}
    	else {
    		for(int i  = l2size-l1size;i>0;--i) {
    			l2curr = l2curr.next;
    		}
    	}
    	while(l1curr!=null) {
    		if(l1curr==l2curr) return l1curr;
    		l1curr = l1curr.next;
    		l2curr = l2curr.next;
    	}
        return null;
    }
    
	public String toString() {
        if (head == null) return "The list is empty.";
        StringBuilder sb = new StringBuilder();
        sb.append(head.element);
        Node<T> cur = head.next;
        while ( cur != null ) {
            sb.append(" -> " + cur.element);
            cur = cur.next;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	
        int[] a = {60, 99, 38, 55, 37, 75, 12};
        int[] b = {37, 58, 57, 89};
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        for (int i: a) l1.insertFirst(i);
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        for (int i: b) l2.insertFirst(i);
        Node<Integer> n55 = l1.head;
        while(n55.element != 55) n55 = n55.next;
        Node<Integer> n99 = l2.head;
        while(n99.next != null) n99 = n99.next;
        n99.next = n55;
        System.out.println(l1);
        System.out.println(l2);
        Node<Integer> node = l1.mergePoint(l2);
        System.out.println((node==null)?"null":node.element);//*/
    	/*
        int[] a = {60, 99, 38, 55, 37, 75, 12};
        int[] b = {4,2,1};
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        for (int i: a) l1.insertFirst(i);
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        for (int i: b) l2.insertFirst(i);
        Node<Integer> n55 = l1.head;
        while(n55.element != 55) n55 = n55.next;
        Node<Integer> n99 = l2.head;
        while(n99.next != null) n99 = n99.next;
        l1.head.next = l2.head;
        System.out.println(l1);
        System.out.println(l2);
        Node<Integer> node = l1.mergePoint(l2);
        System.out.println((node==null)?"null":node.element);//*/
    }
}
