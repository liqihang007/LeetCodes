
public class BestTimetoBuyandSellStock2 {

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
        	int[] newprices=new int [prices.length+1];
        	for (int i=0;i<prices.length;i++){
        		newprices[i]=prices[i];
        	}
        	newprices[prices.length]=0;
        	int marker=1;
        	int buy=0, sell=0;
        	for (int i=0;i<newprices.length-1;i++){
        		if (marker==1 && newprices[i+1]>newprices[i]){
        			buy=newprices[i];
    				marker=-1;
        		}
        		if (marker==-1 && newprices[i+1]<newprices[i]){
        			sell=newprices[i];
        			myreturn=myreturn+sell-buy;
    				marker=1;
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
