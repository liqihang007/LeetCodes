//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
//For example,
//Given input array A = [1,1,2],
//Your function should return length = 2, and A is now [1,2].

import java.util.*;

public class RemoveDuplicatesfromSortedArray {

	public static int removeDuplicates(int[] A) {
        if(A==null || A.length==0){
        	return 0;
        }
        if(A.length==1){
        	return 1;
        }
        else{
        	Arrays.sort(A);
        	int count=1;
        	for (int i=1;i<A.length;i++){
        		if (A[i]!=A[i-1]){
        			A[count]=A[i];
        			count++;
        		}
        	}
        	return count;
        }
    }
	
	public static void main(String[] args) {
		int[] A={10,3,3,5,23,1,3,15};
		System.out.println(removeDuplicates(A));
	}

}
