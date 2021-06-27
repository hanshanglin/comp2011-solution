package sort;

import java.util.Arrays;

public class QuickSort {
	public static void swap(int[]a, int x,int y) {
		int temp = a[x];
		a[x] =a[y];
		a[y] = temp;
	}
	
	public static void dqSort(int[] a, int l, int h){
	    if(l >= h)return;
	    if(a[l] > a[h]){
	        swap(a, l, h);
	    }
	     
	    int pivot1 = a[l];
	    int pivot2 = a[h];
	    
	    int i = l;
	    int k = l+1;
	    int j = h;
	 
	    OUT_lOOP:
	    while(k < j){
	        if(a[k] < pivot1){
	            i++;
	            swap(a, i, k);
	            k++;
	        }else
	        if(a[k] >= pivot1 && a[k] <= pivot2){
	            k++;
	        }else{
	            while(a[--j] > pivot2){
	                if(j <= k){
	                    break OUT_lOOP;
	                }
	            }
	            if(a[j] >= pivot1 && a[j] <= pivot2){
	                swap(a, k, j);
	                k++;
	            }else{
	                i++;
	                swap(a, j, k);
	                swap(a, i, k);
	                k++;
	            }
	        }
	    }
	    swap(a, h, j);
	    swap(a, l, i);
	    dqSort(a, l, i-1);
	    dqSort(a, i+1, j-1);
	    dqSort(a, j+1, h);
	}
	
	
	
	
	
	
    public static void quickSort(int[] a) {
        dqSort(a, 0, a.length - 1);
    }

    public static void qSort(int[] a, int l, int h) {
        if(l>=h) return;
        int pivot = partition(a, l, h);
        int[] pos = focus(a, l, h, pivot);
        qSort(a, l, pos[0]);
        qSort(a, pos[1], h);
    }

    public static int[] focus(int[] a, int l, int h, int p){
        int left = p-1;
        int right = p+1;
        while(right<=h){
            if (a[h] == a[p]){
                a[h] = a[right];
                a[right] = a[p];
                h--;
                right++;
            }
            h--;
        }
        while(l<=left){
            if (a[l] == a[p]){
                a[l] = a[left];
                a[left] = a[p];
                l++;
                left--;
            }
            l++;
        }
        return new int[]{left,right};
    }


    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot)
                high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 5, 8, 9, 6, 10, 5, 13, 15, 16, 4, 2, 5, 3, 9, 7, 6 };
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}

