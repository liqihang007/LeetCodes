//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

import java.util.*;

public class SortColors {

	public static void sortColors(int[] A) {
        int i=0,j=A.length-1;
        while(i<j){
        	if(A[i]==0){i++;}
        	if(A[j]!=0){j--;}
        	if(i<j){
	        	int temp=A[i];
	        	A[i]=A[j];
	        	A[j]=temp;
        	}
        }
        for(i=0;i<A.length;i++){
        	if(A[i]!=0) break;
        }
//        System.out.println(Arrays.toString(A));
        j=A.length-1;
        while(i<j){
        	if(A[i]==1){i++;}
        	if(A[j]!=1){j--;}
        	if(i<j){
	        	int temp=A[i];
	        	A[i]=A[j];
	        	A[j]=temp;
        	}
        }
    }

	public static void main(String[] args) {
		int[] A=new int[]{0,2,1,1,0,2,2,1,0,2};
		System.out.println(Arrays.toString(A));
		sortColors(A);
		System.out.println(Arrays.toString(A));

	}

}
