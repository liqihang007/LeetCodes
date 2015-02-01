//Given a sequence of integers, find the longest increasing subsequence (LIS).
//You code should return the length of the LIS.
//Example
//For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
//For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

import java.util.*;

public class LongestIncreasingSubsequence {

	public static int longestIncreasingSubsequence(int[] num){
		if(num==null || num.length==0){return 0;}
		int len=num.length;
		int[]dp=new int[len];
		Arrays.fill(dp, 1);
		for(int i=1;i<len;i++){
			for(int j=0;j<i;j++){
				if(num[i]>=num[j]){
					dp[i]=Math.max(dp[i],dp[j]+1);
				}
			}
		}
		int res=0;
		for(int i:dp){
			res=Math.max(i, res);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(longestIncreasingSubsequence(new int[]{4, 2, 4, 5, 3, 7}));
	}

}
