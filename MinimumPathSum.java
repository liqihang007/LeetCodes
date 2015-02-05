//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//Note: You can only move either down or right at any point in time.

import java.util.*;

public class MinimumPathSum 
{
	public static int minPathSum(int[][] grid) 
	{
        if (grid==null){return 0;}
        if (grid.length==1 && grid[0].length==1){return grid[0][0];}
        else{
        	int m=grid.length, n=grid[0].length;
        	int[][] dp=new int[m][n];
        	dp[m-1][n-1]=grid[m-1][n-1];
        	for (int i=n-2;i>=0;i--){
        		dp[m-1][i]=dp[m-1][i+1]+grid[m-1][i];
        	}
        	for (int j=m-2;j>=0;j--){
        		dp[j][n-1]=grid[j][n-1]+dp[j+1][n-1];
        	}
        	for (int i=m-2;i>=0;i--){
        		for (int j=n-2;j>=0;j--){
        			dp[i][j]=Math.min(dp[i+1][j],grid[i][j])+grid[i][j];
        		}
        	}
        	return table[0][0];
        }
    }
	
	public static void main(String[] args) 
	{
//		int[][] xx=new int[][]{{1,2,3,4,2,4},{2,4,1,3,4,1},{1,2,2,1,4,5}};
		int[][] xx=new int[][]{{1}};
		int x=minPathSum(xx);
		System.out.println(x);
	}
}
