package comp2011.lab7;

import java.security.SecureRandom;
import java.util.Arrays;

public class Sorting {
	public static void selectionSort(int[] a) {
	}
 
	// you should have done this in lab 2
	public static void insertionSort(int[] a) {
		System.out.println("Hey, I cannot sort, because you haven't implement me yet.");		
	}

	// you should have done this in lab 2
	public static void bubbleSort(int[] a) {
		System.out.println("Hey, I cannot sort, because you haven't implement me yet.");		
	}

    private static void mergesort(int[] a, int l, int h) {

    }

    public static void mergesort(int[] a) {
    	mergesort(a, 0, a.length - 1);
    }

    // iterative version of mergesort
    public static void ms(int[] a) {
    }

    private static int lomuto(int[] a, int l, int h) {
    	int low = l;
    	int fast = l;
    	while(fast<h) {
    		while(a[low] < a[h]&&low<h) {
    			low++;
    		}
    		while(a[fast] >= a[h]&&fast<h-1) {
    			fast++;
    		}
    		int temp = a[fast];
    		a[fast] = a[low];
    		a[low] = temp;
    		low++;
    	}
    	int temp = a[fast];
		a[fast] = a[low];
		a[low] = temp;
        return low;
    }
    
    private static int hoare(int[] a, int l, int h) {
        return -1;
    }
    private static void quicksort(int[] a, int l, int h) {
    	if(l>=h) return;
    	int p = lomuto(a,l,h);
    	lomuto(a,l,p-1);
    	lomuto(a,p+1,h);
    }

    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static void testRandom(int n) {
		long startTime = 0; 
		double duration = 0;

		int[] a = new int[n];
		int[] b = new int[n];
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < n; i++)
			a[i] = random.nextInt(n);

		System.out.println("an array of " + n + " elements:");
		for (int i = 0; i < n; i++) b[i] = a[i];
		startTime = System.currentTimeMillis();
		selectionSort(b);
		duration = (System.currentTimeMillis() - startTime) / 1000.;
		System.out.println("selectionSort takes " + duration + " seconds.");
		
		for (int i = 0; i < n; i++)	b[i] = a[i];
		startTime = System.currentTimeMillis();
		insertionSort(b);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("insertionSort takes " + (duration) + " seconds.");
		
		for (int i = 0; i < n; i++)	b[i] = a[i];
		startTime = System.currentTimeMillis();
		bubbleSort(b);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("bubbleSort takes " + (duration) + " seconds.");

		for (int i = 0; i < n; i++)	b[i] = a[i];
		startTime = System.currentTimeMillis();
		mergesort(b);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("recursive mergesort takes " + (duration) + " seconds.");

		for (int i = 0; i < n; i++)	b[i] = a[i];
		startTime = System.currentTimeMillis();
		ms(b);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("iterative mergesort takes " + (duration) + " seconds.");

		for (int i = 0; i < n; i++) b[i] = a[i];
		startTime = System.currentTimeMillis();
		quicksort(b);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("quicksort takes... " + duration + " seconds.\n\n");
	}
	
    public static void testAscending(int n) {
		long startTime = 0; 
		double duration = 0;

		int[] a = new int[n];
		System.out.println("an array of " + n + " ascending elements:");

		for (int i = 0; i < n; i++) a[i] = i;
		startTime = System.currentTimeMillis();
		selectionSort(a);
		duration = (System.currentTimeMillis() - startTime) / 1000.;
		System.out.println("selectionSort a sorted array takes " + duration + " seconds.");
		
		for (int i = 0; i < n; i++) a[i] = i;
		startTime = System.currentTimeMillis();
		insertionSort(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("insertionSort a sorted array takes " + (duration) + " seconds.");
		
		for (int i = 0; i < n; i++) a[i] = i;
		startTime = System.currentTimeMillis();
		bubbleSort(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("bubbleSort a sorted array takes " + (duration) + " seconds.");

		for (int i = 0; i < n; i++) a[i] = i;
		startTime = System.currentTimeMillis();
		mergesort(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("recursive mergesort a sorted array takes " + (duration) + " seconds.");

		for (int i = 0; i < n; i++) a[i] = i;
		startTime = System.currentTimeMillis();
		ms(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("iterative mergesort a sorted array takes " + (duration) + " seconds.");

		for (int i = 0; i < n; i++) a[i] = i;
		startTime = System.currentTimeMillis();
		quicksort(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("quicksort a sorted array takes... " + duration + " seconds.\n\n");
	}

    public static void testDescending(int n) {
		long startTime = 0; 
		double duration = 0;

		int[] a = new int[n];
		System.out.println("an array of " + n + " descending elements:");

		for (int i = 0; i < n; i++) a[i] = -i;
		System.out.println(Arrays.toString(a));
		startTime = System.currentTimeMillis();
		selectionSort(a);
		duration = (System.currentTimeMillis() - startTime) / 1000.;
		System.out.println("selectionSort a reversely sorted array takes " + duration + " seconds.");
		System.out.println(Arrays.toString(a));
		
		for (int i = 0; i < n; i++) a[i] = -i;
		startTime = System.currentTimeMillis();
		insertionSort(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("insertionSort a reversely sorted array takes " + (duration) + " seconds.");
		
		for (int i = 0; i < n; i++) a[i] = -i;
		startTime = System.currentTimeMillis();
		bubbleSort(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("bubbleSort a reversely sorted array takes " + (duration) + " seconds.");

		for (int i = 0; i < n; i++) a[i] = -i;
		startTime = System.currentTimeMillis();
		mergesort(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("recursive mergesort a reversely sorted array takes " + (duration) + " seconds.");

		for (int i = 0; i < n; i++) a[i] = -i;
		startTime = System.currentTimeMillis();
		ms(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("iterative mergesort a reversely sorted array takes " + (duration) + " seconds.");

		for (int i = 0; i < n; i++) a[i] = -i;
		startTime = System.currentTimeMillis();
		quicksort(a);
		duration = (System.currentTimeMillis() - startTime)  / 1000.;
		System.out.println("quicksort a reversely sorted array takes... " + duration + " seconds.\n\n");
	}
    
    public static void main(String[] args) {
		int n = 32768; //2^15
		while (true) {
			// testRandom(n);
			// testAscending(n);
			testDescending(n);
			n *= 2;
		}
	}
}
