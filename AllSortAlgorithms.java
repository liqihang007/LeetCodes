//Implementations of all sort algorithms.

import java.util.*;

public class AllSortAlgorithms {

//	Quick Sort: O(n*logn - n^2)
	public static int[] quicksort(int[]A, int p, int q){
		if(p<q){
			int m=partition(A,p,q);
			A=quicksort(A,0,m-1);
			A=quicksort(A,m+1,q);
		}
		return A;
	}
	public static int partition(int[]A, int p, int q){
		int i=p-1, temp;
		for (int j=p;j<=q-1;j++){
			if(A[j]<=A[q]){
				i++;
				temp=A[j];	// swap A[i+1] and A[j]
				A[j]=A[i];
				A[i]=temp;
			}
		}
		temp=A[q];
		A[q]=A[i+1];
		A[i+1]=temp;
		return i+1;
	}

//	Merge Sort: O(n*logn)
	
//	Insertion Sort: O(n^2)
	public static int[] insertionsort(int[]A){
		if(A.length<=1){return A;}
		for(int i=0;i<A.length;i++){
			int j=i;
			while(j>0 && A[j-1]>A[j]){
				int temp=A[j]; // swap A[j-1] and A[j]
				A[j]=A[j-1];
				A[j-1]=temp;
				j--;
			}
		}
		return A;
	}
	
//	Bubble Sort: O(n^2)
	
//	Selection Sort: O(n^2)
	
//	Heap Sort: O(n*logn)
	
	public static void main(String[] args) {
		int[]A=new int[100];
		for(int i=0;i<A.length;i++){
			A[i]=(int)((Math.random()*Math.random()+Math.random())*10);
		} 
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(quicksort(A,0,A.length-1)));
		System.out.println(Arrays.toString(insertionsort(A)));
	}

}
