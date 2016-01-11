//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
//prove that at least one duplicate number must exist. 
//Assume that there is only one duplicate number, find the duplicate one.
//Note:
//You must not modify the array (assume the array is read only).
//You must use only constant, O(1) extra space.
//Your runtime complexity should be less than O(n2).
//There is only one duplicate number in the array, but it could be repeated more than once.

public class FindtheDuplicateNumber {
	
	public int findDuplicate(int[] nums) {
	    if (nums.length==0 || nums==null)
	        return 0;
	    int low=1, high=nums.length-1, mid;
	    while (low<high) {
	        mid=low+(high-low)/2;
	        int count=0;
	        for (int i=0; i<nums.length; i++) {
	            if (nums[i]<=mid) // count # of vals in nums <= mid
	                count++;
	        }
	        if (count>mid) // there is a duplicate value <= mid
	            high=mid;
	        else
	            low=mid+1;
	    }
	    return low;
	}
	
}
