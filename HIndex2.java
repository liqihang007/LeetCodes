//Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
//Hint:
//Expected runtime complexity is in O(log n) and the input is sorted.

public class HIndex2 {

	public int hIndex(int[] citations) {
		if(citations.length==0) 
			return 0;
	    int size=citations.length, begin=0, end=size-1, mid;
	    while(begin<=end){
	    	mid=(begin+end)/2;
	        if(citations[mid]>=size-mid){
	            if(mid==0 || citations[mid-1]<size-mid+1) 
	            	return size-mid;
	            else 
	            	end=mid-1;
	        }
	        else
	        	begin = mid+1;
	    }
	    return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
