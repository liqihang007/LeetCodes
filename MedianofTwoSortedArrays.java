//There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

import java.util.*;

public class MedianofTwoSortedArrays {

	public static double findMedianSortedArrays(int A[], int B[]) {
        int n=A.length, m=B.length;
		if ((m+n)%2==0){
        	return (findk(A,B,(m+n)/2) + findk(A,B,(m+n)/2+1))*0.5;
        }
        else{
        	return findk(A,B,(m+n+1)/2);
        }
    }
	
	public static int findk(int[] A, int[] B, int k){
		int n=A.length-1, m=B.length-1;
//		System.out.println(Arrays.toString(A)+" - "+Arrays.toString(B)+" - "+k);
		if(k<=1 && n>=0 && m>=0){return Math.min(A[0],B[0]);}
		if(n<0){
			if(k<1){k++;}
			return B[k-1];
		}
		if(m<0){
			if(k<1){k++;}
			return A[k-1];
		}
		if(A[(n+1)/2]<=B[(m+1)/2]){
			if(k>(n+1)/2+(m+1)/2+1)
				return findk(Arrays.copyOfRange(A, (n+1)/2+1,n+1), B, k-(n+1)/2-1);
			else
				return findk(A,Arrays.copyOfRange(B, 0,(m+1)/2),k);
		}
		else{
			if(k>(n+1)/2+(m+1)/2+1)
				return findk(A, Arrays.copyOfRange(B, (m+1)/2+1,m+1), k-(m+1)/2-1);
			else
				return findk(Arrays.copyOfRange(A, 0,(n+1)/2),B, k);
		}
	}
	
	public static void main(String[] args) {
		int A[]=new int[]{1,2};
		int B[]=new int[]{1,2};
//		System.out.println(Arrays.toString(Arrays.copyOfRange(A,0,1)));
		System.out.println(findMedianSortedArrays(A,B));
//		System.out.println(1/2+1+""+1);
	}

}
