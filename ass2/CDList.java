package comp2011.ass2;

import java.lang.reflect.Field;

public class CDList {

    class DNode {
        int element;
        DNode previous, next;

        DNode(int data) { this.element = data; }
    }

	private DNode head;
	// this method is provided for the purpose of test (in the main).
	// it's not for your use.
	public void insert(int e) {
		DNode newNode = new DNode(e);
		if (head == null) {
			newNode.next = newNode;
			newNode.previous = newNode;
			head = newNode;
			return;
		}
		newNode.next = head;
		newNode.previous = head.previous;
		head.previous = newNode;
		newNode.previous.next = newNode;
	}
	
	// you are not allowed to use insert()
	// or add any new method to this class
	public CDList[] split() {
		if(head.next==head)return new CDList[] {this,null};
		DNode h1 = head;
		DNode h2 = head.previous;
		DNode curr1=head;
		DNode curr2=head.previous;
		while(true) {
			if(curr1.next ==  curr2.previous) {
				curr1 = curr1.next;
				break;
			}
			if(curr1.next == curr2) {
				break;
			}
			curr1 = curr1.next;
			curr2 = curr2.previous;
		}
		curr1.next = h1;
		h1.previous = curr1;
		curr2.previous = h2;
		h2.next = curr2;
		h2 = h2.next!=h2?h2.next:h2;
		CDList sol1 = new CDList();
		CDList sol2 = new CDList();
		sol1.head = h1;
		sol2.head = h2;
		
		return new CDList[] {sol1,sol2};
	}

    public String toString() {
        if (head == null) return "The list is empty.";
        StringBuilder sb = new StringBuilder();
        DNode cur = head;
        sb.append(cur.element);
        cur = cur.next;
        while ( cur != head ) {
            sb.append(", " + cur.element);
            cur = cur.next;
        }
        return sb.toString();
    }

    
    public static void main(String[] args) {
        int[] a = {10, 9, 99, 37, 12, 25, 1, 77};
        CDList l = new CDList();
        for (int i: a) l.insert(i);
        System.out.println(l);
        CDList[] lists = l.split();
        System.out.println(lists[0]);
        System.out.println(lists[1]);
        
    }
}
