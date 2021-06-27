package comp2011.lab9;

import java.util.Scanner;
import comp2011.lec4.Queue;

class Student {
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String toString() {return id + ", " + name;}
}

/*
 * Binary search trees
 */
public class BinarySearchTree<T> {
    private class Node<T> {
        // The explicit use of variable key is non-standard.
        // We use it here to avoid the use of Comparator:
        // http://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
        int key;
        T data;
        public Node<T> leftChild, rightChild;

        public Node(int key, T data) {
            this.key = key;
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }

    Node<T> root;

    public BinarySearchTree() {
    	this.root = null;
    }

    // how to rewrite this with recursion?
    public Node<T> search(int key) {
        return recursiveSearch(root,key);
    }
    
    private Node<T> recursiveSearch(Node<T> cur,int key){
    	if(cur == null) return null;
    	if(cur.key==key)return cur;
    	if(cur.key>key)return recursiveSearch(cur.leftChild,key);
    	if(cur.key<key)return recursiveSearch(cur.rightChild,key);
    	
    	return null;
    	
    }
    
    public Node<T> insert (Node<T> curRoot, int key, T data) {
        if (curRoot == null) return new Node(key,data);
        if (curRoot.key >= key) {
        	curRoot.leftChild = insert(curRoot.leftChild,key,data); 
        	return curRoot;
        }
        if (curRoot.key < key) {
        	curRoot.rightChild = insert(curRoot.rightChild,key,data); 
        	return curRoot;
        }
    	return null;
    }
    
    // starter for the recursive version.
    public void insert (int key, T data) {
        Node<T> newNode = insert(root, key, data);
        if (root == null) root = newNode; 
    }

    // you're suggested to finish search() before this.
    /*whats this*/
    public void recInsert(int key, T data) { }
    
    public boolean delete(int key) { 
    	if (root == null) return false;
    	Node<T> cur = root;
    	Node<T> p = null;
    	while(cur.key!=key) {
    		p = cur;
    		if(cur.key >= key) {
    			cur = cur.leftChild;
    		}
    		else {
    			cur = cur.rightChild;
    		}
    	}
    	if(cur == null) return false;
    	
    	if (cur.leftChild ==null && cur.rightChild==null) {
    		if(p.leftChild == cur) {p.leftChild = null;return true;}
    		else {
    			p.rightChild =null;
    			return true;
    		}
    	}
    	else {
    		if(cur.leftChild ==null) {
    			if(p.leftChild == cur) {
    				p.leftChild = cur.rightChild;
    				return true;
    			}
    			else {
    				p.rightChild = cur.rightChild;
    				return true;
    			}
    		}
    		else {
    			if(cur.rightChild == null) {
    				if(p.leftChild == cur) {
        				p.leftChild = cur.leftChild;
        				return true;
        			}
        			else {
        				p.rightChild = cur.leftChild;
        				return true;
        			}
    			}
    			else { //two chile
    				Node<T> n = cur.leftChild;
    				while(n.rightChild!=null) {
    					n = n.rightChild;
    				}
    				n.rightChild.rightChild = cur.rightChild;
    				n.rightChild.leftChild =  cur.leftChild;
    				if(p.leftChild == cur) {
    					p.leftChild = n.rightChild;
    					n.rightChild = null;
    					return true;
    				}
    				else {
    					p.rightChild = n.rightChild;
    					n.rightChild = null;
    					return true;
    				}
    				
    				
    			}
    			
    		}
    	}
    }

    public void preorder(Node<T> curRoot) {
        if (curRoot == null) return;
        System.out.println(curRoot.data);
        preorder(curRoot.leftChild);
        preorder(curRoot.rightChild);
    }

    public void inorder(Node<T> curRoot) {
        if (curRoot == null) return;
        inorder(curRoot.leftChild);
        System.out.println(curRoot.data);
        inorder(curRoot.rightChild);
    }
    
    // can you do it without recursion?
    public void postorder(Node<T> curRoot) {
        if (curRoot == null) return;
        postorder(curRoot.leftChild);
        postorder(curRoot.rightChild);
        System.out.println(curRoot.data);
    }

    public Node<T> findMin() {
    	if(root == null) return null;
    	Node<T> cur = root;
    	while(cur.leftChild!=null) {
    		cur = cur.leftChild;
    	}
    	
    	return cur;
    }

    public Node<T> findMax() {
    	if(root == null) return null;
    	Node<T> cur = root;
    	while(cur.rightChild!=null) {
    		cur = cur.rightChild;
    	}
    	return cur;
    }
    
    
    public Node<T> predecessor(Node<T> x) { 
    	if(x.leftChild != null) {
    		Node<T> cur = x.leftChild;
    		while(cur.rightChild!=null) {
    			cur = cur.rightChild;
    		}
    		return cur;
    	}
    	else {
    		Node<T> p1 = null;
    		Node<T> p2 = root;
    		int key = x.key;
    		while(p2!=x && p2!=null) {
    			if(p2.key >= key) {
    				p2 = p2.leftChild;
    			}
    			else {
    				p1 = p2;
    				p2 = p2.rightChild;
    			}
    			
    		}
    		
    		
    		return p1;
    	}
    }

    public Node<T> successor(Node<T> x) {
    	if(x.rightChild != null) {
    		Node<T> cur = x.rightChild;
    		while(cur.leftChild!=null) {
    			cur = cur.leftChild;
    		}
    		return cur;
    	}
    	else {
    		Node<T> p1 = null;
    		Node<T> p2 = root;
    		int key = x.key;
    		while(p2!=x && p2!=null) {
    			p1 = p2;
    			if(p2.key >= key) {
    				p2 = p2.leftChild;
    			}
    			else {
    				
    				p2 = p2.rightChild;
    			}
    			
    		}
    		
    		
    		return p1;
    	}
    	}

    public void display() { inorder(root); }

    public void levelDisplay() { 
        Queue<Node<T>> queue = new Queue<Node<T>>();
        queue.enqueue(root);
        while (! queue.isEmpty() ) {
            Node<T> cur = queue.dequeue();
            if (cur == null) continue;
            System.out.println(cur.data);
            queue.enqueue(cur.leftChild);
            queue.enqueue(cur.rightChild);
        }
    }

    public void levelDisplayV2() { 
        Queue<Node<T>> queue = new Queue<Node<T>>();
        if (root != null) queue.enqueue(root);
        while (! queue.isEmpty() ) {
            Node<T> cur = queue.dequeue();
            System.out.println(cur.data);
            if (cur.leftChild != null) queue.enqueue(cur.leftChild);
            if (cur.rightChild != null) queue.enqueue(cur.rightChild);
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree<Student> tree = new BinarySearchTree<Student>();
        tree.insert(214, new Student(214, "Chan Eason"));
        tree.insert(562, new Student(562, "Cheung Jacky"));
        tree.insert( 83, new Student( 83, "Ho Denise"));
        tree.insert(115, new Student(115, "Lam Carrie"));
        tree.insert( 97, new Student( 97, "Leung CY"));
        tree.insert(722, new Student(722, "Leung Gigi"));
        tree.insert(398, new Student(398, "Tang Gloria"));
        tree.insert(798, new Student(798, "Tong Timothy"));
        tree.insert(408, new Student(408, "Tsang Donald"));
        tree.insert(199, new Student(199, "Tse Kay"));
        tree.insert(337, new Student(337, "Tung Chee-hwa"));
        System.out.println("tree built.");
        //tree.levelDisplay();
        tree.inorder(tree.root);

        System.out.println("==========search=========");
        System.out.println("199: " + tree.search(199));
        System.out.println("336: " + tree.search(336));

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number to search");
        System.out.println(tree.search(keyboard.nextInt()));

        System.out.println("Press enter to start insertion");
        keyboard.nextLine();keyboard.nextLine();
        System.out.println("inserting two new students.");//just one student
        tree.insert(336, new Student(336, "Yung Joey"));
        System.out.println("==========after insertion=========");
        tree.display();
        System.out.println("336: " + tree.search(336));
        System.out.println("377: " + tree.search(377));
        System.out.println("Press enter to start deletion");
        keyboard.nextLine();
        tree.delete(798);
        System.out.println("==========after deleting 798=========");
        tree.levelDisplay();
        tree.delete(722);
        System.out.println("==========after deleting 722=========");
        tree.levelDisplay();
        System.out.println("Enter a number to search");
        System.out.println(tree.search(keyboard.nextInt()));
        keyboard.close();
    }
}
