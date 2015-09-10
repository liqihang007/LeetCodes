//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete at most k transactions.

public class BestTimetoBuyandSellStock4 {

//	DP: t(i,j) is the max profit for up to i transactions by time j (0<=i<=K, 0<=j<=T).
//	tmpMax means the maximum profit of just doing at most i-1 transactions, using at most first j-1 prices, 
//	and buying the stock at price[j], which is used for the next loop.
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {            	
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

	public static void main(String[] args) {

	}
}
