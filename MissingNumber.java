//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
//find the one that is missing from the array.
//For example,
//Given nums = [0, 1, 3] return 2.

import java.util.*;

public class MissingNumber {

	public static int missingNumber(int[] nums) {
		Arrays.sort(nums);
		if(nums.length==0)
			return 0;
		if(nums[0]!=0)
            return 0;
		if(nums[nums.length-1]==nums.length-1)
            return nums.length;
		int a=0, b=nums.length-1;
		while(a<b){
			int mid=(a+b)/2;
			if(nums[mid]==mid)
				a=mid+1;
			else
				b=mid;
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[]A=new int[] {0,2,3};
		System.out.println(missingNumber(A));
	}
}
