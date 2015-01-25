//Given a collection of integers that might contain duplicates, S, return all possible subsets.
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,2], a solution is:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]

import java.util.*;

public class Subsets2 {
	public static List<List<Integer>> subsetsWithDup(int[] num){
		List<List<Integer>> set=new ArrayList<>();
        set.add(new ArrayList<Integer>());
        if (num.length>=1){
            Arrays.sort(num);
        	for(int i=0;i<num.length;i++){
            	int k=set.size();
        		for (int j=0;j<k;j++){
        			List<Integer> temp1 = new ArrayList<Integer>(set.get(j));
        			temp1.add(num[i]);
        			set.add(temp1);
        		}
        	}
        }
        HashSet <List<Integer>> hash = new HashSet <List<Integer>>();
        for(List<Integer> check : set){
    		hash.add(check);
        }
        return new ArrayList<List<Integer>>(hash);
    }
	
	public static void main(String[] args) {
		int[] S=new int[]{1,2,2};
		System.out.println(Arrays.toString(S));
		System.out.println(subsetsWithDup(S));
	}
}