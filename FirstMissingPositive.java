//Given an unsorted integer array, find the first missing positive integer.
//For example,
//Given [1,2,0] return 3,
//and [3,4,-1,1] return 2.
//Your algorithm should run in O(n) time and uses constant space.

import java.util.*;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] A) {
        if (A==null || A.length==0){
        	return 1;
        }
        if (A.length==1){
        	if(A[0]<=0 || A[0]>=2){return 1;}
        	else{return 2;}
        }
        else{
        	TreeMap<Integer, Integer>tree=new TreeMap<Integer, Integer>();
        	for (int i=0;i<A.length;i++){
        		if (!tree.containsKey(A[i]) && A[i]>0){
        			tree.put(A[i],A[i]);
        		}
        	}
        	System.out.println(tree);
        	if(!tree.containsKey(1)){
        		return 1;
        	}
        	else{
        		for (int i=1;i<tree.get(tree.lastKey());i++){
	        		if (!tree.containsKey(i)){
	        			return i;
	        		}
	        	}
        		return tree.get(tree.lastKey())+1;
        	}
        }
    }
	
	public static void main(String[] args) {
		int[]A=new int[]{1,2000};
		System.out.println(firstMissingPositive(A));

	}

}
