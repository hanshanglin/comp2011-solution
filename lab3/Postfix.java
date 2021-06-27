package comp2011.lab3;
import java.util.StringTokenizer;

public class Postfix {
	/*
	 * This method is not related to our course.
	 * Its purpose here is to demostrate the use of StringTokenizer.
	 * More imformation can be found in Java API. 
	 */
	public static void demo(String postfix) {
		StringTokenizer parser = new StringTokenizer(postfix, " \n\t\r+-*/", true);
		int i = 0;
		while (parser.hasMoreTokens()) {
			String token = parser.nextToken();
			System.out.println("token " + (++i) + " is: " + token);
		}
	}
	
    public static int evalPostFix(String postfix){
		StringTokenizer parser = new StringTokenizer(postfix, " \n\t\r+-*/ ", true);
		String m = "+-*/";
		IntStack stack = new IntStack();
		int index = 0;
		// 13 2 1 - - has five tokens,
		while (parser.hasMoreTokens()) {
			String token = parser.nextToken();
			index = m.indexOf(token);
			
			switch(index){
			case -1:{if(token.charAt(0)<48||token.charAt(0)>57 ) break;stack.push(Integer.valueOf(token));break;}
			case 0:{stack.push(stack.pop()+stack.pop());break;}
			case 1:{int temp = stack.pop();stack.push(stack.pop()-temp);;break;}
			case 2:{stack.push(stack.pop()*stack.pop());break;}
			case 3:{int temp = stack.pop();stack.push(stack.pop()/temp);break;}
			}
		}
        return stack.pop();
    }

    public static void main(String[] args) {
		demo("3 2 - 1 -");
		System.out.println("3 2 - 1 - = " + evalPostFix("3 2 - 1 -"));
		System.out.println("3 2 1 - - = " + evalPostFix("3 2 1 - -"));
        System.out.println("5 1 - 2 - 6 5 / + = " + evalPostFix("5 1 - 2 - 6 5 / +"));
    }
}
