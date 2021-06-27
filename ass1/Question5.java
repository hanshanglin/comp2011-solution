package comp2011.ass1;

import java.util.Arrays;

class LsTree
{
	/** use for q5 */
	private int[] lsTree = null;
	private int size = 0;
	private int[][] leaves;
	private int[] record;
 
	public LsTree(int[][] sorse){
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


public class Question5 {
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
		LsTree ls = new LsTree(a);
		for(int i = 0;i<full;i++) {
			sol[pos++] = ls.getWinner();
		}
		return sol;	
	}
	
	public static void main(String[] args) {
		/*
		 * The testing data are for your convenience. 
		 * They are not part of the question specification.
		 * You codes are expected to work on all kinds of data.
		 * You may want to change the values of N and R to test your codes.
		 */


		int[][] q5set= {{1,4,7},{2,5,8},{3,6,9}};
		System.out.println("q5set1:" + Arrays.toString(q5set[0]));
		System.out.println("q5set2:" + Arrays.toString(q5set[1]));
		System.out.println("q5set3:" + Arrays.toString(q5set[2]));
		System.out.println("q5: "+Arrays.toString(q5(q5set)));
		
		// you need to design testing codes for the bonus questions by yourself.
	}
}
