//Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
//According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, 
//and the other N-h papers have no more than h citations each."
//For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had 
//received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers 
//with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
//Note: If there are several possible values for h, the maximum one is taken as the h-index.

import java.util.*;

public class HIndex {

	public static int hIndex(int[] citations) {
		if(citations==null)   return 0;
	    int[] buffer=new int[citations.length+1];
	    Arrays.fill(buffer, 0);
	    for(int num : citations) { // counting sort
	        int idx=Math.min(num, citations.length);
	        buffer[idx]++;
	    }
	    int res=0;
	    for(int i=buffer.length-1; i>=0 ; i--) {
	        res+=buffer[i];
	        if(res>=i) 
	        	return i;
	    }
	    return 0;
    }

	public static void main(String[] args) {
		System.out.println(hIndex(new int[]{3,0,6,1,5}));
		System.out.println(hIndex(new int[]{1,1}));
	}

}
