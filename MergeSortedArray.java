//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//Note:
//You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
//The number of elements initialized in A and B are m and n respectively.

import java.util.*;

public class MergeSortedArray {

	public static void merge(int A[], int m, int B[], int n) {
        if(n>0){
        	for(int p=n+m-1;p>=0;p--){
	        	if(m==0){
	        		A[p]=B[n-1];
	        		n--;
	        	}
	        	else{
	        		if(m>0 && A[m-1]<B[n-1]){
	        			A[p]=B[n-1];
		        		n--;
		        		if(n==0){break;}
	        		}
		        	else{
		        		A[p]=A[m-1];
		        		m--;
		        		if(m<0){m=0;}
		        	}
	        	}
	        }
        }
    }
	
	public static void main(String[] args) {
		int[]A=new int[]{6,7,8,0,0,0,0,0,0};
		int[]B=new int[]{1,2,3,4};
		merge(A,1,B,1);
		System.out.println(Arrays.toString(A));
	}

}
