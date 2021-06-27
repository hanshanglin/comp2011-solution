package comp2011.lec4;

import java.util.Arrays;

public class SelectionSort {
	public static void sort(int [] a,int start) {
		int n = a.length;
		if (start > n-1) return;
		int min = start;
		for (int i = start;i<n;i++) {
			if (a[i]< a[min])min = i;
		}
		swap(a,start,min);
		sort(a,start+1);
		
		
		
	}
	public static void swap(int[] a,int x,int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {9,8,7,6,5};
		sort(a,0);
		System.out.println(Arrays.toString(a));
	}
}
