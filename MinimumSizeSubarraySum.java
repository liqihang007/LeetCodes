//Given an array of n positive integers and a positive integer s, find the minimal length of 
//a subarray of which the sum >= s. If there isn't one, return 0 instead.
//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.
//click to show more practice.
//More practice:
//If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

public class MinimumSizeSubarraySum {
	
//	O(NLogN) - search if a window of size k exists that satisfy the condition, update k like "wood cut"
	public int minSubArrayLen(int s, int[] nums) {
        int a=1, b=nums.length, min=0;
        while (a<=b) {
            int mid=(a+b)/2;
            if (windowExist(mid, nums, s)) {
                b=mid-1;
                min=mid;
            } else
            	a=mid+1;
        }
        return min;
    }


    private boolean windowExist(int size, int[] nums, int s) {
        int sum=0;
        for (int i=0; i<nums.length; i++) {
            if (i>=size) 
            	sum-=nums[i-size];
            sum+=nums[i];
            if (sum>=s)
            	return true;
        }
        return false;
    }
    
//    /*O(N) - keep a moving window expand until sum>=s, then shrink until sum<s. 
//	Each time after shrinking, update length. (similar to other solutions, 
//	just removed unnecessary min value assignment)*/		
//	public int minSubArrayLen(int s, int[] nums) {
//		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
//        while (j < nums.length) {
//            while (sum < s && j < nums.length) sum += nums[j++];
//            if(sum>=s){
//                while (sum >= s && i < j) sum -= nums[i++];
//                min = Math.min(min, j - i + 1);
//            }
//        }
//        return min == Integer.MAX_VALUE ? 0 : min;
//    }
}
