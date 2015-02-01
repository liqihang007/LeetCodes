//Implementations of all sort algorithms.

import java.util.*;

public class AllSortAlgorithms {

//	Quick Sort: O(n*logn - n^2)
	public static int[] quicksort(int[]A, int p, int q){
		if(p<q){
			int m=partition(A,p,q);
			quicksort(A,0,m-1);
			quicksort(A,m,q);
		}
		return A;
	}
	public static int partition(int[]arr, int i, int j){
	    int pivot = arr[(i + j) / 2];   
	    while (i <= j) {
	    	while (arr[i] < pivot)
	            i++;
	        while (arr[j] > pivot)
	            j--;
	        if (i <= j) {
	        	int tmp = arr[i];
	        	arr[i] = arr[j];
	        	arr[j] = tmp;
	        	i++;
	        	j--;
	        }
	    } 
	    return i;
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
		int[]A=new int[20];
		for(int i=0;i<A.length;i++){
			A[i]=(int)((Math.random()*Math.random()+Math.random())*10);
		} 
		System.out.println(Arrays.toString(A)+" ori A");
		System.out.println(Arrays.toString(quicksort(A,0,A.length-1))+" quicksort");
		System.out.println(Arrays.toString(insertionsort(A))+" insertion");
	}

}
