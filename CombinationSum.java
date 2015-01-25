//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//The same repeated number may be chosen from C unlimited number of times.
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7] 
//[2, 2, 3] 

import java.util.*;

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result= new ArrayList<>();
		if (candidates!=null && candidates.length>0){
			Arrays.sort(candidates);
			ArrayList<Integer> templist = new ArrayList<Integer>();
			findcomb(result,0,candidates,target, templist);
		}
		return result;
    }
	
	public static void findcomb(List<List<Integer>> result, int i, int[] candidates, int target, ArrayList<Integer> templist){
		if(target<0){
			return;
		}
		if(target==0){
			result.add(new ArrayList<Integer>(templist));
			return;
		}
		if(target>0){
			for (int j=i;j<candidates.length;j++){
				if(j>i && candidates[j]==candidates[j-1]){
					continue;
				}
				templist.add(candidates[j]);
				findcomb(result,j,candidates,target-candidates[j], templist);
				templist.remove(templist.size()-1);
			}
		}
    }
	
	public static void main(String[] args) {
//		int[] A={3,3,5,7,4,3,4};
		int[] A={1,2};
		System.out.println(combinationSum(A,2));
	}

}
