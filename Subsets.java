//Given a set of distinct integers, S, return all possible subsets.
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,3], a solution is:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

import java.util.*;

public class Subsets {
	public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> set=new ArrayList<>();
        set.add(new ArrayList<Integer>());
        if (S.length>=1){
            Arrays.sort(S);
        	for(int i=0;i<S.length;i++){
            	int k=set.size();
        		for (int j=0;j<k;j++){
        			List<Integer> temp1 = new ArrayList<Integer>(set.get(j));
        			temp1.add(S[i]);
        			set.add(temp1);
        		}
        	}
        }        
        return set;
    }
	
	public static void main(String[] args) {
		int[] S=new int[]{1,2,2};
		System.out.println(Arrays.toString(S));
		System.out.println(subsets(S));
	}
}
