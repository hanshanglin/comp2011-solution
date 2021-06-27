package comp2011.ass2;

import java.util.regex.Pattern;

public class DuplicateRemover {
	public static String remove(String s) {
		Pattern p=Pattern.compile("(.)\\1{1}");
		String[] sol = p.split(s, 2);
		if (sol.length == 1) return sol[0];
		else return remove(sol[0]+sol[1]);

        
	}
	
	public static void main(String[] args) {
		String s;
		s = "careermonk";
		System.out.println(s + " becomes " + remove(s));
		s = "mississippi";
		System.out.println(s + " becomes " + remove(s));
	}
}
