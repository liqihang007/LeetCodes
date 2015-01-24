//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//Your algorithm should run in O(n) complexity.

import java.util.*;

public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] num) {
        int res=0;
        if(num.length==1){return 1;}
        if(num.length>1){
        	HashMap<Integer, Integer> hash=new HashMap<Integer, Integer>();
        	for (int i : num){
        		if(!hash.containsKey(i)){
        			int L=(hash.containsKey(i-1))? hash.get(i-1) : 0;
        			int R=(hash.containsKey(i+1))? hash.get(i+1) : 0;
        			int length=L+R+1; // the length of sequence that contains num[i]
        			hash.put(i,length); 
        			hash.put(i-L,length); 
        			hash.put(i+R,length);
        			res=Math.max(length, res);
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[]A=new int[]{100, 4, 200, 1, 3, 2};
		int[]B=new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
		System.out.println(longestConsecutive(A));
		System.out.println(longestConsecutive(B));
	}

}
