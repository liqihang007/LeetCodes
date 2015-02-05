//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//For example,
//Given sorted array A = [1,1,1,2,2,3],
//Your function should return length = 5, and A is now [1,1,2,2,3].

import java.util.*;

public class RemoveDuplicatesfromSortedArray2 {

	public static int removeDuplicates(int[] A) {
        if(A==null || A.length==0){
        	return 0;
        }
        if(A.length<=2){
        	return A.length;
        }
        else{
        	int count=1;
        	int dup=0;
        	for (int i=1;i<A.length;i++){
        		if (A[i]!=A[i-1]){
        			A[count]=A[i];
        			count++;
        			dup=0;
        		}
        		else{
        			dup++;
        			if (dup<=1){
        				A[count]=A[i];
            			count++;
        			}
        		}
        	}
//        	System.out.println(Arrays.toString(A));
        	return count;
        }
    }
	
	public static void main(String[] args) {
//		int[] A={1,1,1,2,2,3};
		int[] A={1,1,1};

		System.out.println(removeDuplicates(A));
	}

}
