package comp2011.ass1;

import java.security.SecureRandom;
import java.util.Arrays;

public class Question4 {
	
	/*
	 * The worst-case running time is __4n__ = O(_n___).
	 */
	public static int[] q4(int[] a, int[] b) {
		int n1 = a.length;
		int n2 = b.length;
		int pos1 = 0;
		int pos2= 0;
		int common_pos = 0;
		int[] common = new int[n1>n2?n2:n1];
		while(pos1<n1 && pos2<n2) {
			if(a[pos1]==b[pos2]) {
				common[common_pos++]=a[pos1];
				pos1++;
				pos2++;
			}
			else if(a[pos1]<b[pos2]) {
				pos1++;
			}
			else {
				pos2++;
			}
		}
		if(common_pos==0) return null;
		int[] r_common = new int[common_pos];
        System.arraycopy(common, 0, r_common, 0,common_pos);
		return r_common;	
	}
	public static void main(String[] args) {
		/*
		 * The testing data are for your convenience. 
		 * They are not part of the question specification.
		 * You codes are expected to work on all kinds of data.
		 * You may want to change the values of N and R to test your codes.
		 */
		int N = 10, R = 1000;
		SecureRandom random = new SecureRandom();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) a[i] = random.nextInt(R) - 50;
		//int a[]= {-9, 45, 4, 17, -14, 11, -47, -26, -40, 40, 23, 38, 36, 9, -49, 21, 29, 32, -33, 35};
		//Arrays.sort(a);
		System.out.println("a: " + Arrays.toString(a));
		
	
		Arrays.sort(a);
		int[] c = {-5, -2, 0, 2, 4}, d = {-2, -1, 1, 2, 4};
		
		System.out.println("The common elements are " + Arrays.toString(q4(c, d)));
	
		// you need to design testing codes for the bonus questions by yourself.
	}
}
