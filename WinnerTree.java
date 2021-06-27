package test;
public class WinnerTree{
    private int size;
    private int[] tree;
    private int[] data;
    public WinnerTree(int[] a){
        this.data = a;
        this.size = a.length;
        this.tree = new int[size-1];
        form();
    }
    public void form(){
        for(int i=0;i<size-1;i++){
            tree[i] = i;
        }
        for(int i = size-2;i>=0;i--){
            adjust(i);
        }
    }
    public int deleteMax(){
        int temp = data[tree[0]];
        data[tree[0]] = Integer.MIN_VALUE;
        adjustToRoot(tree[0]);
        return temp;
    }

    private void adjust(int a){
        if (a>=size) return;
        int lc = 2*a+1;
        int rc = lc+1;
        if (rc<size-1){
            tree[a] = data[tree[lc]]>data[tree[rc]]?tree[lc]:tree[rc];
            return; 
        }
        if (lc<size-1){
            tree[a] = data[tree[lc]]>data[rc-size+1]?tree[lc]:(rc-size+1);
            return;
        }
        if (lc>=size-1){
            tree[a] = data[lc-size+1]>data[rc-size+1]?(lc-size+1):(rc-size+1);
            return;
        }
        return;
    }
    private void adjustToRoot(int a){
        a = a+size-1;
        int p = (a-1)/2;
        while (p>0) {
            adjust(p);
            p = (p-1)/2;
        }
        adjust(0);
    }

    public static void main(String[] args) {
        int[] a = new int[]{14,5,123,54,546,2,634765,123,45677,123,6542,123456,126512};
        WinnerTree tree = new WinnerTree(a);
        int n = a.length;
        for(int i = 0;i<n;i++){
            System.out.print(String.valueOf(tree.deleteMax())+" ");
        } 
    }
}