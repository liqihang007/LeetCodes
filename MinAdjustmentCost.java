//Given an integer array, adjust each integers so that the difference of every adjcent integers are not greater than a given number target. 
//If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]| 
//You can assume each number in the array is a positive integer and not greater than 100 
//Given [1,4,2,3] and target=1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal. Return 2.

import java.*;

public class MinAdjustmentCost {

	//dp[i][j]: the minimal adjust cost on changing A[i] to j,  
	//dp[i][j] = min{dp[i-1][k] + |j-A[i]|} s.t. |k-j| <= target
	
	public static int minAdjustmentCost(int [] A, int tar){
		if(A.length<=0 || A==null) return 0;
		int n=A.length;
		int[][]dp=new int[n][101]; 
		for(int i = 0; i < n; i ++) { 
			for(int j = 1; j <= 100; j ++) { 
				if(i == 0) { 
					dp[i][j] = Math.abs(A[i] - j); // initialize cost
				} 
				else { 
					dp[i][j] = Integer.MAX_VALUE; 
					for(int m = 1; m <= 100; m ++) { 
						if(Math.abs(m - j) > tar) 
							continue; 
						int diff = Math.abs(A[i] - j) + dp[i - 1][m]; 
						dp[i][j] = Math.min(dp[i][j], diff); 
					} 
				} 
			} 
		} 
		int cost=dp[n-1][1];
		for (int i=2;i<=100;i++){
			cost=Math.min(cost,dp[n-1][i]);
		}
		return cost;
	}
	
	public static void main(String[] args) {
		int []A={1,4,2,3};
		System.out.println(minAdjustmentCost(A,1));
	}

}
