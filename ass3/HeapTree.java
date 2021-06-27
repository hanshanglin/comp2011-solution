package comp2011.ass3;

/*
 * A binary tree having the heap-order property,
 * but may not be complete.  
 */
public class HeapTree {
    private class Node {
        int element;
        public Node leftChild, rightChild;

        public Node(int key) {
            this.element = key;
        }

        public String toString() {
            return String.valueOf(element);
        }
    }

    Node root;
    public HeapTree() {root = null;}    
    public HeapTree(int e) {root = new Node(e);}

    // after this operation, t2 no longer exists.
    public void merge(HeapTree t2) {
    	if(this.root == null) {
    		this.root = t2.root;
    		return;
    	}
    	if (t2.root == null)return;
    	if(this.root.element < t2.root.element) {
    		Node temp = this.root;
    		this.root = t2.root;
    		merge(this.root,temp);
    		return;
    	}
    	merge(this.root,t2.root);
    }
    private void merge(Node cur1,Node cur2) {
    	if(cur1 == cur2) return;
    	if(cur1.leftChild == null) {
    		cur1.leftChild = cur2;
    		return;
    	}
    	if(cur1.rightChild == null) {
    		cur1.rightChild = cur2;
    		return;
    	}
    	if(cur1.leftChild.element<cur2.element && cur1.rightChild.element<cur2.element) {
    		Node temp = cur1.leftChild;
    		cur1.leftChild = cur2;
    		merge(cur2,temp);
    		return;
    	}
    	if(cur1.leftChild.element<cur2.element) {
    		merge(cur1.rightChild,cur2);
    	}
    	else {
    		merge(cur1.leftChild,cur2);
    	}
    }
    
    public static void main(String[] args) {
        int[] a1 = {214, 562, 83, 115, 97, 722, 398, 798, 408, 199, 37, 336, 722, 722, 722};
        int[] a2 = {100, 79, 67, 2, 7, 73, 42, 24, 63, 36, 13, 25, 1};
        HeapTree t1 = new HeapTree(); // an empty one
        for (int i:a1) 
            t1.merge(new HeapTree(i));
        HeapTree t2 = new HeapTree(); // an empty one
        for (int i:a2) 
            t2.merge(new HeapTree(i));
        t1.merge(t2);

        
        // you may add something to here test your codes.
    }
}
