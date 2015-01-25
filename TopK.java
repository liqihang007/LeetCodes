// Top-K problem, search k largest(or smallest) numbers in an array.

import java.util.*;

public class TopK {
	// top largest - min heap - heap[0] is the k-th largetest 
	// top smallet - max heap - heap[0] is the k-th smallest 
	private static int[] findtopk(int[] A, int k){
		int[] heap=new int[k];
		for(int i=0;i<k;i++){
			heap[i]=A[i];
		}
		for (int i=k/2;i>=1;i--){
			modheap(heap, i);
		}
		for (int i=k;i<A.length;i++){
			if(A[i]>heap[0]){
				heap[0]=A[i];
				modheap(heap, 1);
			}
		}
		return heap;
	}
	
	private static void modheap(int[] A, int i){  // A[0] is the smallest in A
		int min=i;
		if(2*i<=A.length && A[2*i-1]<A[i-1]){
			min=2*i;
		}
		if(2*i+1<=A.length && A[2*i]<A[min-1]){
			min=2*i+1;
		}
		if(min!=i){ // swap A[i-1] and A[min-1]
			int temp=A[i-1];
			A[i-1]=A[min-1];
			A[min-1]=temp;
			modheap(A,min);
		}
	}
	
	public static void main(String[] args) {
		int[] A=new int[50];
		for(int i=0;i<A.length;i++){
			A[i]=(int)(Math.random()*10);
		}
		int[] topk=findtopk(A,10);
//		int[] A={1,2,3,4,5,6,7,8,9,8,7,65,5,8,10};
//		int[] topk=findtopk(A,5);
		System.out.println(Arrays.toString(topk));
	}

}
