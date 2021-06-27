package comp2011.lab6;
import java.util.Arrays;

// finish the methods, 
// write both iterative and recursive versions.
public class DivideAndConquer {
    public static int iterativePeak(int[] a) {
        int high = a.length - 1;
        if(high == -1) return -1;
        if(high == 0) return 0;
        int low = 0;
        int mid = high/2;
        while(low<=high) {
        	if (a[mid] > a[mid-1]) {
        		if (a[mid] > a[mid+1]) return mid;
        		low = mid;
        	}
        	else {
        		high = mid;        		
        	}
        	mid = low + (high-low)/2;
        }
        return mid;
    }
    
    public static int recursivePeak(int[] a,int low,int high) {
    	if (low>high) return -1;
    	if (low == high) return high;
    	int mid = high/2;
    	if (a[mid]>a[mid-1]) {
    		if (a[mid] > a[mid+1]) return mid;
    		return recursivePeak(a,mid,high);
    	}
    	return recursivePeak(a,low,mid);
    }
    
    public static int[] iterativeMaxMin(int[] a) {
    	int n = a.length;
        if (n == 0) return null;
        int[] ans = new int[2];
        if (n == 1) {ans[0] = ans[1] = 0; return ans;}
        int pos = n%2==0?n-1:n-2;
        while(pos>=0) {
        	if (a[pos]<=a[pos-1]) {
        		pos-=2;
        		continue;
        	}
        	else {
        		int temp = a[pos];
        		a[pos] = a[pos-1];
        		a[pos-1] = temp;
        	}
        }
        ans[0] = a[0]; //max
        ans[1] = a[1];
        for (int i = 2;i<n;i+=2) {
        	if(a[i]> ans[0]) ans[0] = a[i];
        }
        for (int i = 3;i<n;i+=2) {
        	if(a[i]< ans[1]) ans[1] = a[i];
        }
        return ans;
    }
  


    
    public static int[] mergesort(int[] a,int low, int high) {
    	if(low >= high)return a;
        int n = high-low+1;
        int[] b = new int[n / 2];
        for (int i = 0; i < n / 2; i++) b[i] = a[low+i];
        b = mergesort(b,0,n/2-1);
        a = mergesort(a,low+ n / 2,high);
        a = merge(b, a, low+ n / 2,high);
        return a; 
    }
    
    public static int[] merge(int[] b, int [] a,int low,int high) {
    	int bn = b.length;
    	int bpos = 0;
    	int pos = low-bn;
    	while (low<=high && bpos<bn) {
    		if (b[bpos]<=a[low]) {
    			a[pos] = b[bpos];
    			pos++;
    			bpos++;
    			if (bpos == b.length) {
    				for(int i = low;i<=high;i++) {
    					a[pos] = a[i];
    					pos++;
    				}
    				return a;
    			}
    		}
    		else {
    			a[pos] = a[low];
    			pos++;
    			low++;
    			if(low == high+1) {
    				for(int i = bpos;i<bn;i++) {
    					a[pos] = b[i];
    					pos++;
    				}
    				return a;
    			}
    		}
    	}
    	return a;
    }

    
    public static void mergeSort2(int[] a){
        int len = a.length;
        int k = 1;
        while(k < len)        {
            MergePass(a, k, len);
            k *= 2;         
        }
    }
    private static void MergePass(int[] a, int k, int n) {
        int i = 0;
        int j;
        while(i < n - 2*k + 1){
            merge2(a, i, i + k-1, i + 2*k - 1);
            i += 2*k;
        }
        if(i < n - k ){
            merge2(a, i, i+k-1, n-1);
        }
    }
   
    private static void merge2(int[] arr, int low, int mid, int high)
    {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid+1;
        int k = 0;
        
        for(; i <= mid && j <= high; k++){
            if(arr[i] < arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
        }
        
        while(i <= mid)
            temp[k++] = arr[i++];
        
        while(j <= high)
            temp[k++] = arr[j++];
        
        for(int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }

    
    public static void main(String args[]) {
        int[] a = {12, 35, 1, 10, 1, 19, 49, 34};
        System.out.println(Arrays.toString(a));
        System.out.println(iterativePeak(a));
        System.out.println(recursivePeak(a,0,a.length-1));
        int[] ans = iterativeMaxMin(a);
        System.out.println("max = " + ans[0] + ", min = " + ans[1]);
        mergesort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        int[] b = {12, 35, 1, 10, 1, 19, 49, 34};
        mergeSort2(b);
        System.out.println(Arrays.toString(b));

    }
}
