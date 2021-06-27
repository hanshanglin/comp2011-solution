package comp2011.mid;

public class Expression {

	
	/*
	 * This is the only difficult question.
	 * The main difficulties are 
	 * (1) a ] doesn't eat up all ['s;  ("[[[]]" is balanced.) and
	 * (2) only ORIGINALLY CONSECUTIVE is counted ("[()[]" is not balanced.).
	 * 
	 * Most answers I have seen fail to take care of (1).
	 */
	class Node{
		char type;
		int num;
		boolean change;
		public Node(char type){
			this.type = type;
			this.num = 0;
			this.change = false;
		}
	}
	
	public boolean isGeneralizedBalanced(String s) {
		Node[] record = new Node[20]; // 20 just for test
		int pos = 0;
		record[pos] = new Node('E');
		int n = s.length();
		for(int i = 0;i<n;i++) {
			char c = s.charAt(i);
			if(c == '(' || c=='[' || c=='{') {
				Node temp = new Node(c);
				while(s.charAt(i) == c) {
					temp.num+=1;
					i++;
				}
				i-=1;
				pos+=1;
				record[pos] = temp ;
			}
			else {
				if(c == ')') {
					if (record[pos].type!='(') {
						/*if (record[pos].change == false) return false;*/	
						while(pos!=0 && record[pos].change == true && record[pos].type!='(' )pos-=1;
						if(record[pos].type!='(') return false;
					}
					else {
						record[pos].num-=1;
						if(record[pos].num == 0) pos--;
						int tpos = pos;
						while(record[tpos].type == '(' && record[tpos].change == true) {tpos--;} 
						if(record[tpos].type == '(' ) record[tpos].change = true;
					}
				}
				
				if(c == ']') {
					if (record[pos].type!='[') {
						/*if (record[pos].change == false) return false;*/	
						while(pos!=0 && record[pos].change == true && record[pos].type!='[' )pos-=1;
						if(record[pos].type!='[') return false;
					}
					else {
						record[pos].num-=1;
						if(record[pos].num == 0) pos--;
						int tpos = pos;
						while(record[tpos].type == '['&& record[tpos].change == true) {tpos--;} 
						if(record[tpos].type == '[' ) record[tpos].change = true;
					}
				}
				
				if(c == '}') {
					if (record[pos].type!='{') {
						/*if (record[pos].change == false) return false;*/	
						while(pos!=0 && record[pos].change == true && record[pos].type!='{' )pos-=1;
						if(record[pos].type!='{') return false;
					}
					else {
						record[pos].num-=1;
						if(record[pos].num == 0) pos--;
						int tpos = pos;
						while(record[tpos].type == '{' && record[tpos].change == true) {tpos--;} 
						if(record[tpos].type == '{' ) record[tpos].change = true;
					}
				}
			}
		}
		while(pos!=0) {
			if (record[pos].change == false) return false;
			pos--;
		}
		return true;
	}

	public static boolean isBalanced(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') count++;
			else if (c == ')') count--;
			if (count < 0) return false;
		}
		return count == 0;
	}
	
	public static void main(String[] args) {
		String[] ss = {"{[]([])[]}", "[[((()]]", "[[[]]", "[()[(()]", "())"}; 
		Expression a = new Expression();
		for (int i = 0; i < ss.length; i++) 
		    System.out.println(ss[i] + 
		            (a.isGeneralizedBalanced(ss[i]) ? " is " : " is not ") + "balanced.");
	}

}
