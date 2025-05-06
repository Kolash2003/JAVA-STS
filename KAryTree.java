import java.util.*;

public class KAryTree {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int n=0, k=3;
        for(int x : new int[]{4,5,6,7,8,9,10}) arr[n++]=x;
        
        buildHeap(arr,n,k);
        print("Built Heap", arr, n);
        
        insert(arr,n++,k,3);
        print("Heap after insertion of 3", arr, n);
        
        System.out.println("Extracted max: "+extractMax(arr,n--,k));
        print("Heap after extraction", arr, n);
    }

    static void buildHeap(int[] a, int n, int k) {
        for(int i=(n-1)/k; i>=0; i--) restoreDown(a,n,i,k);
    }

    static void insert(int[] a, int n, int k, int e) {
        a[n] = e;
        for(int p=(n-1)/k; a[n]>a[p]; n=p, p=(n-1)/k) 
            swap(a,n,p);
    }

    static int extractMax(int[] a, int n, int k) {
        int max=a[0];
        a[0]=a[n-1];
        restoreDown(a,n-1,0,k);
        return max;
    }

    static void restoreDown(int[] a, int len, int i, int k) {
        while(true) {
            int max=i;
            for(int j=1; j<=k; j++) {
                int child=k*i+j;
                if(child<len && a[child]>a[max]) max=child;
            }
            if(max==i) break;
            swap(a,i,max);
            i=max;
        }
    }

    static void swap(int[] a, int i, int j) {
        int t=a[i]; a[i]=a[j]; a[j]=t;
    }

    static void print(String msg, int[] a, int n) {
        System.out.print(msg+": ");
        for(int i=0;i<n;i++) System.out.print(a[i]+" ");
        System.out.println();
    }
}
