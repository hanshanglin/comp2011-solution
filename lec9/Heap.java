package comp2011.lec9;

import java.util.Arrays;

/*
 * the heap structure
 * warning: this is NOT the heap in memory management.
 * */

public class Heap{

	private int[] heapArray;
	protected int size=0;
	private int curr=0;
	final static int maxSize = 100;

	
	public boolean compare(int a,int b) {
		return a>b;
	}
	
	public boolean insert(int[] heapArray,int key) {
		if(size == curr) {
			return false;
		}
		heapArray[curr]=key;
		adjustUp(curr);
		curr++;
		return true;
	}
	
	public int getmax() {
		if(curr == 0) {
			return -1;
		}
		return heapArray[0];
	}
	
	public int deleteMax() {
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

