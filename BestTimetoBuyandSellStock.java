//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction 
//(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class BestTimetoBuyandSellStock {

	public static int maxProfit(int[] prices) {
		int len = prices.length;
	    if (len <= 1) return 0;
	    int min = prices[0];
	    int max = Integer.MIN_VALUE;
	    for (int i = 1; i < len; i ++) {
	        max = Math.max(max, prices[i] - min);
	        min = Math.min(min, prices[i]);
	    }
	    return Math.max(max, 0);
    }
	
	public static void main(String[] args) {
		int[] A={10,3,3,5,23,1,3,15};
		System.out.println(maxProfit(A));
	}

}
