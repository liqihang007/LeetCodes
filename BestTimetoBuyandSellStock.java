//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction 
//(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class BestTimetoBuyandSellStock {

	public static int maxProfit(int[] prices) {
		if(prices.length<=1) return 0;
        int min=prices[0], max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min)
                min=prices[i];
            else
                max=Math.max(prices[i]-min,max);
        }
        return Math.max(max,0);
    }
	
	public static void main(String[] args) {
		int[] A={10,3,3,5,23,1,3,15};
		System.out.println(maxProfit(A));
	}

}
