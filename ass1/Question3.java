package comp2011.ass1;

import java.security.SecureRandom;
import java.util.Arrays;

public class Question3 {
	/*
	 * The worst-case running time is __3n__ = O(___n_).
	 */
	public static int q3(int[] a) {
		int n = a.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++) {
			if(a[i]<min) {
				min = a[i];
			}
			if(a[i]>max) {
				max = a[i];
			}
		}
		return max-min;	
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
		
	
		System.out.println("The largest difference is " + q3(a));

	
		
		// you need to design testing codes for the bonus questions by yourself.
	}
}
