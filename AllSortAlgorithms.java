//Implementations of 4 common sort algorithms: Quick Sort, Merge Sort, Insertion Sort, Bubble Sort, Counting Sort.

import java.util.*;

public class AllSortAlgorithms {

//	Quick Sort: O(n*logn - n^2)
	public static int[] quicksort(int[]A, int p, int q){
		if(p<q){
			int m=partition(A,p,q);
			quicksort(A,p,m-1);
			quicksort(A,m,q);
		}
		return A;
	}
	public static int partition(int[]A, int i, int j){
	    int pivot = A[(i + j) / 2];   
	    while (i < j) {
	    	while (A[i] < pivot)
	            i++;
	        while (A[j] > pivot)
	            j--;
	        if (i < j) {
	        	int tmp = A[i];
	        	A[i] = A[j];
	        	A[j] = tmp;
	        	i++;
	        	j--;
	        }
	    } 
	    return i;
	}

//	Merge Sort: O(n*logn)
	public static void mergesort(int[]A, int a, int b){
		if(a<b){
			int mid = (a+b)/2;
			mergesort(A,a,mid);
			mergesort(A,mid+1,b);
			merge(A,a,mid,b);
		}
	}
	
	public static void merge(int[] A,  int p, int q, int r){
		int[]L=Arrays.copyOfRange(A, p, q+1);
		int[]R=Arrays.copyOfRange(A, q+1, r+1);
		int i=0, j=0, k=p;
		while(i<q-p+1 && j<r-q && k<=r){
			if(L[i]>R[j]){
				A[k]=R[j];
				j++;
			}
			else{
				A[k]=L[i];
				i++;
			}
			k++;
		}
		if(i==q-p+1){
			while(k<=r && j<r-q){
				A[k]=R[j];
				k++;
				j++;
			}
		}
		if(j==r-q){
			while(k<=r && i<q-p+1){
				A[k]=L[i];
				k++;
				i++;
			}
		}
	}
	
//	Insertion Sort: O(n^2)
	public static int[] insertionsort(int[]A){
		if(A.length<=1) return A;
		for(int i=1;i<A.length;i++){
			int j=i;
			while(j>0 && A[j-1]>A[j]){
				int tmp=A[j]; // swap A[j-1] and A[j]
				A[j]=A[j-1];
				A[j-1]=tmp;
				j--;
			}
		}
		return A;
	}
	
//	Bubble Sort: O(n^2)
	public static int[] bubblesort(int[]A){
		if(A.length<=1) return A;
		while(true){
			int ct=0;
			for(int i=1;i<A.length;i++){
				if(A[i]<A[i-1]){
					int tmp=A[i]; // swap A[j-1] and A[j]
					A[i]=A[i-1];
					A[i-1]=tmp;
					ct++;
				}
			}
			if(ct==0) break;
		}
		return A;
	}

//	Heap Sort
	public static int[] heapsort(int[] A) {
        for (int i=0;i<A.length;i++)
			modheap(A, i);
        return A;
    }
	
    public static void modheap(int[]A, int i){
        int j=(i-1)/2;
        if(i>0 && j>=0 && A[i]<A[j]){
        	int tmp=A[j];
        	A[j]=A[i];
        	A[i]=tmp;
        	modheap(A, j);
        }
    }
    
//    Counting Sort
    private static int[] countingsort(int[] A) {
    	int k=0;
    	for(int i:A)
    		k=Math.max(i,k);
    	int[] B = new int[A.length];
        int[] C = new int[k+1];
        for (int j = 0; j < A.length; j++) {
            int a = A[j];
            C[a] += 1;
        }
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int j = A.length - 1; j >= 0; j--) {
            int a = A[j];
            B[C[a] - 1] = a;
            C[a] -= 1;
        }
        return B;
    }
    
	public static void main(String[] args) {
		int[]A=new int[50];
		for(int i=0;i<A.length;i++){
			A[i]=(int)((Math.random()*Math.random()+Math.random())*10);
		} 
		System.out.println(Arrays.toString(A)+" ori A");
		int[]Q=A;
		System.out.println(Arrays.toString(quicksort(Q,0,Q.length-1))+" quicksort");
		int[]I=A;
		System.out.println(Arrays.toString(insertionsort(I))+" insertionsort");
		int[]B=A;
		System.out.println(Arrays.toString(bubblesort(B))+" bubblesort");
		int[]M=A; mergesort(M,0,M.length-1);
		System.out.println(Arrays.toString(M)+" mergesort");
		int[]H=A;
		System.out.println(Arrays.toString(heapsort(H))+" heapsort");
		int[]C=A;
		System.out.println(Arrays.toString(countingsort(C))+" countingsort");
	}

}
