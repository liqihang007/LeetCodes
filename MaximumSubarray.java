//Find the contiguous subarray within an array (containing at least one number) which has the largest sum. 
//For example, given the array [ -2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.

import java.util.*;

public class MaximumSubarray {

	public static int maxSubArray(int[] A) {
        int sum=0;
        if(A.length>=1){
        	sum=A[0];
        	int temp=A[0];
        	for(int i=1;i<A.length;i++){
        		temp+=A[i];
        		if(A[i]>temp){ // temp is negative
        			temp=A[i];
        		}
                sum=Math.max(temp,sum);
        	}
        }
        return sum;
    }
	
	public static void main(String[] args) {
		int A[]=new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(A));
	}

}
