//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

import java.util.*;

public class BestTimetoBuyandSellStock3 {

	public static int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1){return 0;}
        else{
        	int [] L=new int[prices.length];
        	L[0]=0;
        	int minL=prices[0];
        	for(int i=1;i<prices.length;i++){
        		if(prices[i]<minL){minL=prices[i];}
        		L[i]=Math.max(L[i-1],prices[i]-minL);
        	}

        	int [] R=new int[prices.length];
        	R[prices.length-1]=0;
        	int maxR=prices[prices.length-1];
        	for(int i=prices.length-2;i>=0;i--){
        		if(prices[i]>maxR){maxR=prices[i];}
        		R[i]=Math.max(R[i+1],maxR-prices[i]);
        	}
        	
        	int res=0;
        	for(int i=0;i<prices.length-1;i++){
        		if(L[i]+R[i+1]>res){res=L[i]+R[i+1];}
        	}
        	res=Math.max(res, Math.max(L[prices.length-1],R[0]));
        	System.out.println(Arrays.toString(R));
        	return res;
        }
    }
	public static void main(String[] args) {
		int[]A=new int[]{7,11,4,1,2};
		System.out.println(maxProfit(A));
	}

}
