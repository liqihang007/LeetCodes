//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

import java.util.*;

public class PerfectSquares {

	public static int numSquares(int n) {
	    int[] record = new int[n+1];
	    for(int i=0;i<=n;i++){
	        record[i]=i;
	        for(int j=1;j*j<=i;j++){
	            if(record[i-j*j]+1<record[i])
	                record[i]=record[i-j*j]+1;
	        }
	    }
	    return record[n];
	}
	
//	public static List<Integer> numSquareswOutput(int n) {
//		List<List<Integer>>res=new ArrayList<List<Integer>>();
//	    int[] record = new int[n+1];
//	    for(int i=0;i<=n;i++){
//	        record[i]=i;
//	        res.add(new ArrayList<Integer>(i));
//	        for(int j=1;j*j<=i;j++){
//	            if(record[i-j*j]+1<record[i]){
//	                record[i]=record[i-j*j]+1;
//	                List tmp=new ArrayList<Integer>(res.get(i-j*j));
//	                tmp.add(j*j);
//	                res.set(i,tmp);
//	            }
//	        }
//	    }
//	    return res.get(n);
//	}
	
	public static void main(String[] args) {
		System.out.println(numSquares(12));
		System.out.println(numSquareswOutput(13));
	}

}
