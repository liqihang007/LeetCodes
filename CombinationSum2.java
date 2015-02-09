//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//Each number in C may only be used once in the combination.
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2,..., ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
//A solution set is: 
//[1, 7] 
//[1, 2, 5] 
//[2, 6] 
//[1, 1, 6] 

import java.util.*;

public class CombinationSum2 {

	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> res= new ArrayList<>();
		if (num==null || num.length==0) return res;
		Arrays.sort(num);
		findcomb(res, 0, num, target, new ArrayList<Integer>());
		return res;
    }
	
	public static void findcomb(List<List<Integer>> res, int k, int[] num, int target, ArrayList<Integer> mylist){
		if (target<0 || num.length<=0){
			return;
		}
		if (target==0 && num.length>=0){
			res.add(new ArrayList<Integer>(mylist));
			return;
		}
		if (target>0){
			for (int j=k;j<num.length;j++){
				if (j>k && num[j]==num[j-1]){
					continue;
				}
				mylist.add(num[j]);
				findcomb(res, j+1, num, target-num[j], mylist);
				mylist.remove(mylist.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A={3,5,4,3,4};
//		int[] A={1,1};
		System.out.println(combinationSum2(A,8));
		
	}

}
