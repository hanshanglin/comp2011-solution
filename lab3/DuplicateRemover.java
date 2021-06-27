package comp2011.lab3;


import comp2011.lab3.CharStack;

public class DuplicateRemover {
	public static String remove(String s) {
		CharStack stack = new CharStack();
		char[] news = s.toCharArray();
		
		int n = s.length();
		for (int i =0;i<n;i++) {
			if (stack.isEmpty()) stack.push(news[i]);
			else if (stack.peep()==news[i]) stack.pop();
			else stack.push(news[i]);
		}
		if (stack.isEmpty()) return null;
		else {
			char [] sol = new char[stack.gettop()];
			for (int i = stack.gettop() ;i>0;i-- ) {
				sol[i-1]=stack.pop();
			} 
			return new String(sol);
		}
	}
	
	public static void main(String[] args) {
		String s;
		s = "careermonk";
		System.out.println(s + " becomes " + remove(s));
		s = "mississippi";
		System.out.println(s + " becomes " + remove(s));
	}
}
