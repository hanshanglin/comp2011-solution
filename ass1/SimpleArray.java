package comp2011.ass1;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Grading policy: 
 * The marks of (2) are independent of that of (1).
 * In other words, even your algorithm is not correct or 
 * takes more-than-necessary time, you get full points
 * as long as your analysis of the algorithm is correct. 
 */
class Heap{
	/** use for q2 */
	private int[] heapArray;
	protected int size;
	private int curr;
	
	public Heap(int maxSize) {
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

class LoserTree
{
	/** use for q5 */
	private int[] lsTree = null;
	private int size = 0;
	private int[][] leaves;
	private int[] record;
 
	public LoserTree(int[][] sorse){
		this.leaves = sorse;
		this.size = sorse.length;
		this.lsTree = new int[size];
		this.record = new int[size];
		for (int i = 0; i < size; i++){
			lsTree[i] = -1;
		}
		for (int i = 0; i<size;i++) {
			record[i]=leaves[i].length;
		}
		for (int i = size - 1; i >= 0; i--){
			adjust(i);
		}

	}
 
	public int getLeaf(int i){
		if (record[i]==0) return Integer.MAX_VALUE;
		else {
			record[i]=record[i]-1;
			return leaves[i][leaves[i].length-record[i]-1];
		}
	}
	
	public int lookLeaf(int i){
		if (record[i]==0) return Integer.MAX_VALUE;
		else {
			return leaves[i][leaves[i].length-record[i]];
		}
	}
 
	public int getWinner(){
		int temp = lsTree[0];
		int win = getLeaf(lsTree[0]);
		adjust(temp);
		return win;
	}
 
	private void adjust(int s){
		int parent = (s + size) / 2;
		while (parent > 0)
		{
			if (s >= 0 && (lsTree[parent] == -1 || lookLeaf(lsTree[parent]) < lookLeaf(s))){
				int temp = s;
				s = lsTree[parent];
				lsTree[parent] = temp;
			}
			parent /= 2;
		}
		lsTree[0] = s;
	}
}


public class SimpleArray {

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
	
	/*
	 * The worst-case running time is __2nlogn + 3n__ = O(__nlogn__).
	 */
	public static int q2(int[] a) {
		int n = a.length;
		Heap hp = new Heap(n);
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
	
	/*
	 * The worst-case running time is __2k+2nlogk__ = O(__nlogk__). (k is the number of arrays, n is the number of elements in all arrays)
	 */
	public static int[] q5(int[][] a) {
		int full = 0;
		int k = a.length;
		int pos = 0;
		for(int i = 0;i<k;i++) {
			full+=a[i].length;
		} 
		int[] sol = new int [full];
		LoserTree ls = new LoserTree(a);
		for(int i = 0;i<full;i++) {
			sol[pos++] = ls.getWinner();
		}
		return sol;	
	}
	
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
		
		System.out.println("The smallest difference is " + q2(a));
		System.out.println("The largest difference is " + q3(a));
		Arrays.sort(a);
		int[] c = {-5, -2, 0, 2, 4}, d = {-2, -1, 1, 2, 4};
		System.out.println("c[i] = i when i = " + q1(c));
		System.out.println("The common elements are " + Arrays.toString(q4(c, d)));
		int[] e = {1,2,5, -2, 0, 2, 4};
		System.out.println(q6(e));
		int[][] q5set= {{1,4,7},{2,5,8},{3,6,9}};
		System.out.println(Arrays.toString(q5(q5set)));
		
		// you need to design testing codes for the bonus questions by yourself.
	}
}
