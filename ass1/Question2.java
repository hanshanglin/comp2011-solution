package comp2011.ass1;

import java.security.SecureRandom;
import java.util.Arrays;

class myHeap{
	/** use for q2 */
	private int[] heapArray;
	protected int size;
	private int curr;
	
	public myHeap(int maxSize) {
		this.size = maxSize;
		heapArray = new int[maxSize];
		curr = 0;
	}
	
	public boolean compare(int a,int b) {
		return a>b;
	}
	
	public boolean insert(int key) {
		if(size == curr) {
			return false;
		}
		heapArray[curr]=key;
		adjustUp(curr);
		curr++;
		return true;
	}
	
	public int get() {
		if(curr == 0) {
			return -1;
		}
		return heapArray[0];
	}
	
	public int pop() {
		if(curr == 0) {
			return -1;
		}
		int temp = heapArray[0];
		heapArray[0] = heapArray[--curr];
		adjustDown(0);
		return temp;
	}
	
	private void swap(int index1, int index2) {
		int temp = heapArray[index1];
		heapArray[index1] =heapArray[index2];
		heapArray[index2] =temp;
		return;
	}
	
	private void adjustUp(int index) {
		int parent = (index-1)/2;
		while(parent >=0) {
			if(compare(heapArray[parent],heapArray[index])) {
				swap(index,parent);
				index = parent;
				parent = (index-1)/2;
			}
			else return;
		}
		return;
	}
	
	private void adjustDown(int index) {
		int ld;
		int rd;
		while(index<curr && index>=0) {
			ld = 2*index+1;
			rd = 2*index+2;
			if(ld>=curr) return; //no left child
			else if(rd>=curr) {
				if(compare(heapArray[index],heapArray[ld])) {
					swap(index,ld);
					index = ld;
				}
				else {
					return;	
				}
			}
			else {
				if(compare(heapArray[rd],heapArray[ld])) {
					if(compare(heapArray[index],heapArray[ld])) {
						swap(ld,index);
						index = ld;
					}
					else return;
				}
				else {
					if(compare(heapArray[index],heapArray[rd])) {
						swap(rd,index);
						index = rd;
					}
					else return;
					
				}
			}
		}
	}
}


public class Question2 {
	/*
	 * The worst-case running time is __2nlogn + 3n__ = O(__nlogn__).
	 */
	public static int q2(int[] a) {
		int n = a.length;
		myHeap hp = new myHeap(n);
		for(int i=0;i<n;i++) {
			hp.insert(a[i]);
		}
		int temp = hp.pop();
		int min = Integer.MAX_VALUE;
		for(int i=1;i<n;i++) {
			min = min>hp.get()-temp?hp.get()-temp:min;
			temp =hp.pop();
		}

		return min;	
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
		
		System.out.println("The smallest difference is " + q2(a));

		Arrays.sort(a);
		int[] c = {-5, -2, 0, 2, 4}, d = {-2, -1, 1, 2, 4};
	
		
		// you need to design testing codes for the bonus questions by yourself.
	}
}

