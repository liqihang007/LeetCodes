
public class BestTimetoBuyandSellStock {

	public static int maxProfit(int[] prices) {
        int myreturn=0;
        if (prices.length<=1 || prices==null){
        	return myreturn;
        }
        if (prices.length==2){
        	if (prices[1]>prices[0]){
        		return prices[1]-prices[0];
        	}
        	else{
        		return myreturn;
        	}
        }else{
        	int[] maxafterdate=new int [prices.length];
        	maxafterdate[prices.length-1]=0;
        	maxafterdate[prices.length-2]=prices[prices.length-1];
        	for (int i=prices.length-2;i>=0;i--){
        		maxafterdate[i]=Math.max(maxafterdate[i+1],prices[i+1]);
        	}
        	int[] profit=new int [prices.length];
        	for (int i=0;i<prices.length;i++){
        		profit[i]=maxafterdate[i]-prices[i];
        		if(profit[i]>myreturn){
        			myreturn=profit[i];
        		}
        	}
        }
        return myreturn;
    }
	
	public static void main(String[] args) {
		int[] A={10,3,3,5,23,1,3,15};
		System.out.println(maxProfit(A));
	}

}
