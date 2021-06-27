package comp2011.lec9;

import java.util.Arrays;

public class HeapSort {
	private static void swap(int[] a,int x,int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	} 
	
	public static void heapsort (int [] a ) {
		for (int i = 1; i < a . length ; i ++)
		insert (a , i );
		for (int i = a . length - 1; i > 0; i --)
		a [ i ] = deleteMax (a , i );
		}
	
	private static void adjustUp(int[] a, int cur) {
		if(cur==0)return;
		int p = (cur-1)/2;
		if(a[cur] > a[p]) swap(a,cur,p);
		adjustUp(a,p);
	}
	
	private static void adjustDown(int[] a,int cur, int end) {
		int child = cur*2+1;
		if(end<child)return;
		if(end == child) {
			if (a[cur]<a[child])swap(a,cur,child);
			return;
		}
		else {
			if(a[child]<a[child+1])child++;
			if(a[child] > a[cur]) {swap(a,cur,child); adjustDown(a,child,end);return;}
			return;
		}
	}
	
	public static int deleteMax (int [] a , int end ) {
		swap(a,0,end);
		end--;
		adjustDown(a,0,end);
		return a[end+1];
	}
	public static void insert (int [] a , int end ) {
		adjustUp(a,end);
	}

	
	public static void main(String args[]) {
		int[] num = new int[] {9,8,7,6,5,4,3,2,1};
		heapsort(num);
		System.out.println(Arrays.toString(num));
	}
}
