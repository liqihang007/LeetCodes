//Given an unsorted array of integers, find the length of longest increasing subsequence.
//For example,
//Given [10, 9, 2, 5, 3, 7, 101, 18],
//The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
//Note that there may be more than one LIS combination, it is only necessary for you to return the length.
//Your algorithm should run in O(n2) complexity.
//Follow up: Could you improve it to O(n log n) time complexity?
		
import java.util.*;

public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) { // O(nlogn)
        int N=0, idx, x;
        for(int i=0; i<nums.length; i++) {
            x=nums[i];
            if (N<1 || x>nums[N-1])
                nums[N++]=x;
            else if ((idx=Arrays.binarySearch(nums, 0, N, x))<0)
            	/*As this statement is executed only if idx variable is negative 
            	(meaning there is no such tail in our DP part of the array at the moment), 
            	we use -(idx + 1) to convert it to the right position.
            	If we already have this number in the array Arrays.binarySearch() will 
            	return positive index (or 0) - we don't need to update anything. 
    			But if it is not in the array then we update it.*/
            	nums[-(idx+1)]=x;
        }
        return N;
    }
	
//	public static int lengthOfLIS(int[] nums) { // dp O(n^2)
//		if(nums==null || nums.length==0){return 0;}
//		int len=nums.length;
//		int[]dp=new int[len];
//		Arrays.fill(dp, 1);
//		for(int i=1;i<len;i++){
//			for(int j=0;j<i;j++){
//				if(nums[i]>=nums[j])
//					dp[i]=Math.max(dp[i],dp[j]+1);
//			}
//		}
//		int res=0;
//		for(int i:dp){
//			res=Math.max(i, res);
//		}
//		return res;
//	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[]{4, 2, 4, 5, 3, 7}));
	}

}
