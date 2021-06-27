package comp2011.ass1;

import java.security.SecureRandom;
import java.util.Arrays;

public class Question6 {
	
	/*
	 * The best-case running time is  __3__ = O(__1__).
	 * The worst-case running time is __3n__ = O(__n__).
	 */
	public static int q6(int[] a) {
		int n = a.length;
		for(int i =0;i<n-1;i++) {
			if (a[i]>=a[i+1]) return i;
		}
		if (n==0) return 0;
		else if (a[n-1]>=a[n-2]) return n-1;
		return -1;	
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
		
		System.out.println("q6: i="+q6(a));

		
		// you need to design testing codes for the bonus questions by yourself.
	}
}
