package comp2011.mid;
import java.util.Arrays;

/*
 * the basic idea is to extend a circular array.  
 * 
 * DRAW DIAGRAMS!
 */
public class KillRing {
    private static final int MAX_ITEMS = 60;
    private int len = 0;
    private String[] data;
    private int cursor;
    private int start;
    private int end;
    
    public KillRing() {
    	this.data = new String[MAX_ITEMS];
    	this.len = 0;
    	this.cursor = 0;
    	this.start = 0;
    	this.end = 0;
    }

    public boolean isEmpty() {
        return len==0;
    }

    public void insert(String s) {
    	if (cursor == end && len == MAX_ITEMS) {
    		cursor = start;
    		data[cursor] = s;
    		start = (start+1)%MAX_ITEMS;
    		end = cursor;
    		return;
    	}
    	cursor = (cursor+1)%MAX_ITEMS;
    	end = cursor;
    	data[cursor] = s;
    	len+=1;
    	
    }

    public String read() {
    	if (isEmpty()) return null;
        return data[cursor];
    }
    
    public void moveCursor() {
    	if(isEmpty()) return;
    	if(cursor == start) {
    		cursor =end;
    		return;
    	}
    	cursor = (cursor -1 +len)%len;
    }

    public String toString() {
    	return Arrays.toString(data);
    }

    public static void main(String[] args) {
        KillRing queue = new KillRing();
        for (int i = 1; i <= 70; i++)
            queue.insert(String.valueOf(i * 10));
        System.out.println(queue);        
        for (int i = 0; i < 15; i++) {
            System.out.println(queue.read());
            queue.moveCursor();
        }
        queue.insert("Data");
        queue.insert("Structures");
        queue.insert("2011");
        queue.insert("2018");
        queue.insert("Fall");
        System.out.println(queue);
        for (int i = 0; i < 3; i++) {
            System.out.println(queue.read());
            queue.moveCursor();
        }
    }
}
