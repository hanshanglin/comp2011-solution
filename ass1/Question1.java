package comp2011.ass1;

import java.security.SecureRandom;
import java.util.Arrays;

public class Question1 {

	/*
	 * The worst-case running time is __5logn__ = O(__logn__).
	 */
	public static int q1(int[] a) {
		int high = a.length-1;
		int low = 0;
		int mid = 0;
		while(low<=high) {
			mid = (high+low)/2;
			if(a[mid]==mid) return mid;
			if(a[mid]<mid) low=mid+1;
			else high=mid-1;
		}
		/*int pos = 0;
		while( pos<n && a[pos]<pos) {
			pos+=1;
		}
		while(pos<n) {
			if (a[pos]>pos) pos = a[pos];
			else return pos;
		}*/
		
		return -1;	
	}
	public static void main(String[] args) {
		/*
		 * The testing data are for your convenience. 
		 * They are not part of the question specification.
		 * You codes are expected to work on all kinds of data.
		 * You may want to change the values of N and R to test your codes.
		 */
		int N = 10, R = 100;
		SecureRandom random = new SecureRandom();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) a[i] = random.nextInt(R) - 50;
		//int a[]= {-9, 45, 4, 17, -14, 11, -47, -26, -40, 40, 23, 38, 36, 9, -49, 21, 29, 32, -33, 35};
		//Arrays.sort(a);
		Arrays.sort(a);
		System.out.println("a: " + Arrays.toString(a));
		System.out.println("c[i] = i when i = " + q1(a));
	}
		// you need to design testing codes for the bonus questions by yourself.
	
}
