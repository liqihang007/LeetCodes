//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

import java.util.*;

public class BestTimetoBuyandSellStock3 {

	public static int maxProfit(int[] prices) {
		int n=prices.length;
		if(n<=1)return 0;
        int[]L=new int[n];
        int min=prices[0];
        L[0]=0;
        for(int i=1;i<n;i++){
            min=Math.min(prices[i],min);
            L[i]=Math.max(L[i-1],prices[i]-min);
        }
        int[]R=new int[n];
        int max=prices[n-1];
        R[n-1]=0;
        for(int i=n-2;i>=0;i--){
            max=Math.max(prices[i],max);
            R[i]=Math.max(R[i+1],max-prices[i]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,L[i]+R[i]);
        }
        return res;
    }
	public static void main(String[] args) {
		int[]A=new int[]{4,4,6,1,1,4,2,5};
		System.out.println(maxProfit(A));
	}

}
